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
package org.apache.cloudstack.systemvm.managment.service.impl;

import org.apache.cloudstack.api.InternalIdentity;

import com.cloud.dc.DataCenter;
import com.cloud.dc.Pod;
import com.cloud.network.Network;
import com.cloud.vm.Nic;
import com.cloud.vm.VirtualMachine;

public class SystemVmEvent {

    String name;
    DataCenter zone;
    Pod pod;
    Nic nic;
    VirtualMachine virtualMachine;
    Network network;

    public DataCenter getZone() {
        return zone;
    }

    public void setZone(DataCenter zone) {
        this.zone = zone;
    }

    public Nic getNic() {
        return nic;
    }

    public void setNic(Nic nic) {
        this.nic = nic;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VirtualMachine getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(VirtualMachine virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

    @Override
    public String toString() {
        return "SystemVmEvent [name=" + name + ", zone=" + getId(zone) + ", nic=" + getId(nic) + ", virtualMachine=" + getId(virtualMachine)
                + ", network=" + getId(network) + "]";
    }
    
    protected Long getId(InternalIdentity id) {
        return id == null ? null : id.getId();
    }

    public Pod getPod() {
        return pod;
    }

    public void setPod(Pod pod) {
        this.pod = pod;
    }

}
