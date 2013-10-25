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
package org.apache.cloudstack.systemvm.managment.model.impl;

import java.util.Map;
import java.util.Set;

import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition;
import org.apache.cloudstack.systemvm.managment.model.SystemVmNetworkAssociation;
import org.apache.cloudstack.systemvm.managment.model.SystemVmRole;
import org.apache.cloudstack.systemvm.managment.service.impl.SystemVmEvent;

import com.cloud.dc.DataCenter;
import com.cloud.dc.Pod;

public class DefaultSystemVmDefinition implements SystemVmDefinition {

    Set<SystemVmRole> roles;
    SystemVmState desiredState;
    SystemVmState currentState;
    Long systemVmId;
    Map<Long,SystemVmNetworkAssociation> systemVmNetworkAssociation;
    Pod pod;
    DataCenter zone;

    public DefaultSystemVmDefinition() {
    }
    
    public DefaultSystemVmDefinition(SystemVmEvent event) {
        this.zone = event.getZone();
        this.pod = event.getPod();
    }
    
    @Override
    public String toString() {
        return "DefaultSystemVmDefinition [roles=" + roles + ", desiredState=" + desiredState + ", currentState="
                + currentState + ", systemVmId=" + systemVmId + ", systemVmNetworkAssociation="
                + systemVmNetworkAssociation + ", pod=" + pod + ", zone=" + zone + "]";
    }

    public Set<SystemVmRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SystemVmRole> roles) {
        this.roles = roles;
    }

    public SystemVmState getDesiredState() {
        return desiredState;
    }

    @Override
    public void setDesiredState(SystemVmState desiredState) {
        this.desiredState = desiredState;
    }

    public SystemVmState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(SystemVmState currentState) {
        this.currentState = currentState;
    }

    public Long getSystemVmId() {
        return systemVmId;
    }

    public void setSystemVmId(Long systemVmId) {
        this.systemVmId = systemVmId;
    }

    public Map<Long, SystemVmNetworkAssociation> getSystemVmNetworkAssociation() {
        return systemVmNetworkAssociation;
    }

    public void setSystemVmNetworkAssociation(Map<Long, SystemVmNetworkAssociation> systemVmNetworkAssociation) {
        this.systemVmNetworkAssociation = systemVmNetworkAssociation;
    }

    public Pod getPod() {
        return pod;
    }

    public void setPod(Pod pod) {
        this.pod = pod;
    }

    public DataCenter getZone() {
        return zone;
    }

    public void setZone(DataCenter zone) {
        this.zone = zone;
    }

}
