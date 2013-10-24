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
package org.apache.cloudstack.systemvm.managment.config;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition;

import com.cloud.deploy.DeploymentPlan;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.network.Network;
import com.cloud.offering.ServiceOffering;
import com.cloud.template.VirtualMachineTemplate;
import com.cloud.user.Account;
import com.cloud.vm.NicProfile;
import com.cloud.vm.VirtualMachine;

public interface SystemVmConfiguration {
    
    List<HypervisorType> getSupportedHypervisors(long zoneId, Long podId);

    VirtualMachineTemplate getVirtualMachineTemplate(HypervisorType type, long zoneId);

    VirtualMachine getSystemVmVO(SystemVmDefinition def);

    ServiceOffering getServiceOffering(SystemVmDefinition def);

    String getVmInstanceName(SystemVmDefinition def, long id);

    long getNextId();

    Account getOwner(SystemVmDefinition def);

    String getRoleString(SystemVmDefinition def);

    DeploymentPlan getDeploymentPlan(SystemVmDefinition def);

    //TODO: This really should be Map, change VirtualMachineManager.allocate() to take map
    LinkedHashMap<Network, NicProfile> getNicProfiles(SystemVmDefinition def);

    Network getControlNetwork(SystemVmDefinition def);
}