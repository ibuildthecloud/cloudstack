/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.cloud.serializer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.cloudstack.framework.json.GsonStyleMapper;
import org.apache.cloudstack.storage.command.CopyCommand;
import org.apache.cloudstack.storage.to.SnapshotObjectTO;
import org.apache.cloudstack.storage.to.VolumeObjectTO;
import org.apache.log4j.Level;
import org.junit.Test;

import com.cloud.agent.api.BackupSnapshotCommand;
import com.cloud.agent.api.Command;
import com.cloud.agent.api.NetworkUsageCommand;
import com.cloud.agent.api.PingRoutingWithNwGroupsCommand;
import com.cloud.agent.api.SecStorageFirewallCfgCommand;
import com.cloud.agent.api.to.DataObjectType;
import com.cloud.agent.api.to.SwiftTO;
import com.cloud.host.Host;
import com.cloud.storage.Storage.ImageFormat;
import com.cloud.utils.Pair;
import com.cloud.vm.VirtualMachine;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class GsonHelperTest {

    @Test
    public void testSerialize() throws IOException {
        VolumeObjectTO v = new VolumeObjectTO();
        v.setBytesReadRate(42L);
        v.setChainInfo("chainInfo");
        v.setFormat(ImageFormat.BAREMETAL);
        SnapshotObjectTO s = new SnapshotObjectTO();
        CopyCommand copyCommand = new CopyCommand(v, s, 123, false);

        HashMap<String, Pair<Long, Long>> nwGrpStates = new HashMap<String, Pair<Long, Long>>();
        nwGrpStates.put("nwgrp1", new Pair<Long, Long>(42L, 43L));
        
        Map<String, VirtualMachine.State> states = new HashMap<String, VirtualMachine.State>();
         states.put("key1", VirtualMachine.State.Running);
        
        PingRoutingWithNwGroupsCommand pingCommand = new PingRoutingWithNwGroupsCommand(Host.Type.BaremetalDhcp, 42,
                states, nwGrpStates);
        
         SecStorageFirewallCfgCommand ssfc = new
         SecStorageFirewallCfgCommand();
         ssfc.addPortConfig("1.1.1.1", "22", true, "eth0");
         ssfc.addPortConfig("1.1.1.1", "2#", true, "eth1");

        Command[] commands = new Command[] { copyCommand, pingCommand, ssfc };

        String serialized = GsonHelper.getGson().toJson(commands);

        /* This is just to force the fields to be in a specific order */
        SimpleModule mixin = new SimpleModule();
        mixin.setMixInAnnotation(Command.class, CopyCommandMixin.class);
        ((GsonStyleMapper) JsonHelper.getJson()).getObjectMapper().registerModule(mixin);

        serialized = JsonHelper.getJson().writeValueAsString(commands);

        /*
         * This string was taken from running the same code against Gson before
         * we switched to Jackson
         */
        assertEquals(
                "[{\"org.apache.cloudstack.storage.command.CopyCommand\":{\"srcTO\":"
                        + "{\"org.apache.cloudstack.storage.to.VolumeObjectTO\":"
                        + "{\"accountId\":0,\"chainInfo\":\"chainInfo\",\"format\":\"BAREMETAL\",\"id\":0,\"bytesReadRate\":42}},\"destTO\":"
                        + "{\"org.apache.cloudstack.storage.to.SnapshotObjectTO\":{\"id\":0}},"
                        + "\"executeInSequence\":false,\"contextMap\":{},\"wait\":123}},"
                        + "{\"com.cloud.agent.api.PingRoutingWithNwGroupsCommand\":{\"newGroupStates\":{\"nwgrp1\":[42,43]},\"newStates\":"
                        + "{\"key1\":\"Running\"},\"_gatewayAccessible\":true,\"_vnetAccessible\":true,\"hostType\":\"BaremetalDhcp\","
                        + "\"hostId\":42,\"contextMap\":{},\"wait\":0}},{\"com.cloud.agent.api.SecStorageFirewallCfgCommand\":{\"portConfigs\":"
                        + "[{\"add\":true,\"sourceIp\":\"1.1.1.1\",\"port\":\"22\",\"intf\":\"eth0\"},{\"add\":true,\"sourceIp\":\"1.1.1.1\",\"port\":"
                        + "\"2#\",\"intf\":\"eth1\"}],\"isAppendAIp\":false,\"contextMap\":{},\"wait\":0}}]",
                serialized);

        Command[] deserialized = GsonHelper.getGson().fromJson(serialized, (Type) Command[].class);
        deserialized = JsonHelper.getJson().fromJson(serialized, Command[].class);

        assertTrue(deserialized[0] instanceof CopyCommand);
        assertTrue(deserialized[1] instanceof PingRoutingWithNwGroupsCommand);
        assertTrue(deserialized[2] instanceof SecStorageFirewallCfgCommand);

        assertTrue(((CopyCommand) deserialized[0]).getDestTO() instanceof SnapshotObjectTO);
        assertTrue(((CopyCommand) deserialized[0]).getSrcTO() instanceof VolumeObjectTO);

        assertEquals(new Long(42L), ((VolumeObjectTO) ((CopyCommand) deserialized[0]).getSrcTO()).getBytesReadRate());
        assertEquals("chainInfo", ((VolumeObjectTO) ((CopyCommand) deserialized[0]).getSrcTO()).getChainInfo());
        assertEquals(ImageFormat.BAREMETAL, ((VolumeObjectTO) ((CopyCommand) deserialized[0]).getSrcTO()).getFormat());

        assertEquals(new Long(42L), ((PingRoutingWithNwGroupsCommand)deserialized[1]).getNewGroupStates().get("nwgrp1").first());
        assertEquals(new Long(43L), ((PingRoutingWithNwGroupsCommand) deserialized[1]).getNewGroupStates()
                .get("nwgrp1").second());

        assertEquals("2#", ((SecStorageFirewallCfgCommand) deserialized[2]).getPortConfigs().get(1).getPort());
    }

    @Test
    public void testLoggingExclusion() {
        GsonHelper.s_logger.setLevel(Level.DEBUG);
        JsonHelper.s_logger.setLevel(Level.DEBUG);

        NetworkUsageCommand cmd = new NetworkUsageCommand("1", "2", false, "1.1.1.1");
        BackupSnapshotCommand backupCmd = new BackupSnapshotCommand(null, null, null, null, null, null, null, null,
                null, null, null, null, true, null, 42);
        backupCmd.setSwift(new SwiftTO());

        Command[] cmds = new Command[] { cmd, cmd };

        String output = GsonHelper.getGsonLogger().toJson(cmds);
        System.out.println(output);

        assertEquals("[{},{}]", JsonHelper.getJsonLogger().toJson(cmds));

        cmds = new Command[] { backupCmd };
        output = JsonHelper.getJsonLogger().toJson(cmds);
        
        assertTrue(output.contains("isVolumeInactive"));
        assertTrue(!output.contains("swift"));
    }



    @JsonPropertyOrder({ "newGroupStates", "newStates", "_gatewayAccessible", "_vnetAccessible", "hostType", "hostId",
            "srcTO", "destTO",
 "executeInSequence", "portConfigs", "isAppendAIp", "contextMap", "wait" })
    public static class CopyCommandMixin {

        @JsonIgnore
        public DataObjectType getObjectType() {
            return DataObjectType.TEMPLATE;
        }
    }

}
