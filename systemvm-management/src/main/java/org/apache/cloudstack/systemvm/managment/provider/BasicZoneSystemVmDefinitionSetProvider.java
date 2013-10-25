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
package org.apache.cloudstack.systemvm.managment.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.cloudstack.systemvm.managment.config.SystemVmConfiguration;
import org.apache.cloudstack.systemvm.managment.dao.SystemVmManagementDao;
import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition.SystemVmState;
import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinitionSet;
import org.apache.cloudstack.systemvm.managment.model.SystemVmRole;
import org.apache.cloudstack.systemvm.managment.model.impl.DefaultSystemVmDefinition;
import org.apache.cloudstack.systemvm.managment.model.impl.DefaultSystemVmDefinitionSet;
import org.apache.cloudstack.systemvm.managment.model.impl.DefaultSystemVmNetworkAssociation;
import org.apache.cloudstack.systemvm.managment.service.impl.SystemVmEvent;
import org.apache.cloudstack.systemvm.managment.util.SystemVmDefinitionSetUtils;

import com.cloud.dc.DataCenter.NetworkType;
import com.cloud.vm.SystemVm;

public class BasicZoneSystemVmDefinitionSetProvider implements SystemVmDefinitionSetProvider {

    SystemVmManagementDao systemVmManagementDao;
    SystemVmConfiguration configuration;

    @Override
    public Collection<SystemVmDefinitionSet> getSystemVmSet(SystemVmEvent event) {
        DefaultSystemVmDefinitionSet currentPod = new DefaultSystemVmDefinitionSet();
        DefaultSystemVmDefinitionSet otherPod = new DefaultSystemVmDefinitionSet();

        Map<Long, List<SystemVm>> existingVms = systemVmManagementDao.getSystemVmForNetworkByRole(event.getNetwork().getId(), 
                SystemVmRole.VirtualRouter);

        long currentPodId = event.getPod().getId(); 
        for ( Map.Entry<Long, List<SystemVm>> entry : existingVms.entrySet() ) {
            long podId = entry.getKey();
            List<SystemVm> systemVms = entry.getValue();

            if ( podId == 0 ) {
                /* These are somehow orphaned System VM that are associated to this network, just delete */
                add(SystemVmState.REMOVE, event, otherPod, systemVms);
            } else if ( podId == currentPodId ) {
                boolean first = true;
                for ( SystemVm systemVm : systemVms ) {
                    /* Only need one system vm per pod */
                    add(first ? SystemVmState.RUNNING : SystemVmState.REMOVE, event, currentPod, systemVm);
                    first = false;
                }
            } else {
                add(null, event, currentPod, systemVms);
            }
        }

        if ( currentPod.getSystemVmDefinitions().size() == 0 ) {
            currentPod.add(getBasicDefinition(event, SystemVmState.RUNNING));
        }

        return Arrays.asList((SystemVmDefinitionSet)currentPod, otherPod);
    }

    protected void add(SystemVmState state, SystemVmEvent event, DefaultSystemVmDefinitionSet result, List<SystemVm> systemVms) {
        for ( SystemVm systemVm : systemVms ) {
            add(state, event, result, systemVm);
        }
    }

    protected void add(SystemVmState state, SystemVmEvent event, DefaultSystemVmDefinitionSet result, SystemVm systemVm) {
        DefaultSystemVmDefinition def = getBasicDefinition(event, state);
        def.setSystemVmId(systemVm.getId());
        result.add(def);
    }

    protected DefaultSystemVmDefinition getBasicDefinition(SystemVmEvent event, SystemVmState state) {
        DefaultSystemVmDefinition def = new DefaultSystemVmDefinition(event);
        def.setRoles(SystemVmRole.getRoleSet(SystemVmRole.VirtualRouter));

        DefaultSystemVmNetworkAssociation guestAssoc = SystemVmDefinitionSetUtils.createAssoc(event.getNetwork(), true);
        DefaultSystemVmNetworkAssociation controlAssoc = 
                SystemVmDefinitionSetUtils.createAssoc(configuration.getControlNetwork(def), false);

        def.setSystemVmNetworkAssociation(SystemVmDefinitionSetUtils.createMap(guestAssoc, controlAssoc));
        def.setDesiredState(state);

        return def;
    }

    

    @Override
    public int canHandle(SystemVmEvent event) {
        if ( event.getZone().getNetworkType() == NetworkType.Basic && 
                event.getNetwork() != null && event.getPod() != null ) {
            return SystemVmDefinitionSetProvider.PRIORITY_NORMAL;
        }

        return SystemVmDefinitionSetProvider.PRIORITY_NONE;
    }

    public SystemVmManagementDao getSystemVmManagementDao() {
        return systemVmManagementDao;
    }

    @Inject
    public void setSystemVmManagementDao(SystemVmManagementDao systemVmManagementDao) {
        this.systemVmManagementDao = systemVmManagementDao;
    }

    public SystemVmConfiguration getConfiguration() {
        return configuration;
    }

    @Inject
    public void setConfiguration(SystemVmConfiguration configuration) {
        this.configuration = configuration;
    }

}
