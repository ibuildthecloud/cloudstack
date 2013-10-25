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

import javax.inject.Inject;

import org.apache.cloudstack.systemvm.managment.service.SystemVmEventFactory;

import com.cloud.dc.DataCenter;
import com.cloud.dc.Pod;
import com.cloud.host.Host;
import com.cloud.network.Network;
import com.cloud.org.Cluster;
import com.cloud.utils.db.EntityManager;
import com.cloud.vm.Nic;
import com.cloud.vm.VirtualMachine;

public class SystemVmEventFactoryImpl implements SystemVmEventFactory {

    EntityManager entityManager;

    @Override
    public SystemVmEvent getEvent(String eventName, Class<?> entityType, Long id) {
        SystemVmEvent event = new SystemVmEvent();
        event.setName(eventName);

        if ( entityType == Nic.class ) {
            populateNic(event, id);
        } else if ( entityType == Network.class ) {
            populateNetwork(event, id);
        } else if ( entityType == VirtualMachine.class ) {
            populateVirtualMachine(event, id);
        } else if ( entityType == DataCenter.class ) {
            populateZone(event, id);
        } else {
            throw new IllegalArgumentException("Unsupported class type [" + entityType + "]");
        }

        return event;
    }

    protected void populateNic(SystemVmEvent event, Long id) {
        Nic nic = entityManager.findById(Nic.class, id);

        if ( nic != null ) {
            event.setNic(nic);
            populateVirtualMachine(event, nic.getInstanceId());
            populateNetwork(event, nic.getNetworkId());
        }
    }

    protected void populateVirtualMachine(SystemVmEvent event, Long id) {
        VirtualMachine vm = entityManager.findById(VirtualMachine.class, id);

        if ( vm != null ) {
            event.setVirtualMachine(vm);
            Host host = entityManager.findById(Host.class, vm.getHostId());
            Cluster cluster = host == null ? null : entityManager.findById(Cluster.class, host.getClusterId());
            if ( cluster != null )
                populatePod(event, cluster.getPodId());
        }
    }

    protected void populateNetwork(SystemVmEvent event, Long id) {
        Network network = entityManager.findById(Network.class, id);

        if ( network != null ) {
            event.setNetwork(network);
            populateZone(event, network.getDataCenterId());
        }
    }

    protected void populateZone(SystemVmEvent event, Long id) {
        if ( event.getZone() != null )
            return;

        DataCenter zone = entityManager.findById(DataCenter.class, id);
        event.setZone(zone);
    }

    protected void populatePod(SystemVmEvent event, Long id) {
        if ( event.getPod() != null )
            return;

        Pod pod = entityManager.findById(Pod.class, id);
        event.setPod(pod);

        populateZone(event, pod.getDataCenterId());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}