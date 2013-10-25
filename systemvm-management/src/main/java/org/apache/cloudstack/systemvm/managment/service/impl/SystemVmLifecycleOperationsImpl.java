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

import java.util.LinkedHashMap;

import javax.inject.Inject;

import org.apache.cloudstack.systemvm.managment.config.SystemVmConfiguration;
import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition;
import org.apache.cloudstack.systemvm.managment.service.SystemVmLifecycleOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.deploy.DeploymentPlan;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.OperationTimedoutException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.network.Network;
import com.cloud.offering.ServiceOffering;
import com.cloud.template.VirtualMachineTemplate;
import com.cloud.utils.exception.CloudRuntimeException;
import com.cloud.vm.NicProfile;
import com.cloud.vm.SystemVm;
import com.cloud.vm.VirtualMachine;
import com.cloud.vm.VirtualMachineManager;
import com.cloud.vm.dao.SystemVmDao;

public class SystemVmLifecycleOperationsImpl implements SystemVmLifecycleOperations {

    private static final Logger log = LoggerFactory.getLogger(SystemVmLifecycleOperationsImpl.class);

    SystemVmConfiguration configuration;
    SystemVmDao systemVmDao;
    VirtualMachineManager vmManager;

    public VirtualMachine remove(SystemVmDefinition def) {
        VirtualMachine vm = configuration.getSystemVmVO(def);
        expunge(vm);
        return vm;
    }

    public VirtualMachine startSystemVm(SystemVmDefinition def) throws InsufficientCapacityException, ResourceUnavailableException {
        VirtualMachine existing = configuration.getSystemVmVO(def);

        if ( shouldBeReplaced(def, existing) ) {
            expunge(existing);
            existing = null;
        }

        if ( existing == null ) {
            return createAndStart(def);
        } else {
            return start(def, existing, existing.getHypervisorType());
        }
    }

    protected VirtualMachine createAndStart(SystemVmDefinition def) throws InsufficientCapacityException, ResourceUnavailableException {
        Long podId = def.getPod() == null ? null : def.getPod().getId();
        InsufficientCapacityException lastException = null;
        for ( HypervisorType type : configuration.getSupportedHypervisors(def.getZone().getId(), podId) ) {
            try {
                return start(def, null, type);
            } catch (InsufficientCapacityException e) {
                lastException = e;
                log.warn("Failed to create a SystemVM for hypervisor [{}], will try a different hypervisor type", type, e);
            }
        }
        
        if ( lastException == null ) {
            throw new IllegalStateException("No hypervisor type available to deploy System VM on");
        }
        
        throw lastException;
    }

    protected VirtualMachine start(SystemVmDefinition def, VirtualMachine vm, HypervisorType type) throws InsufficientCapacityException, ResourceUnavailableException {
        if ( vm == null ) {
            vm = defineNewSystemVm(def, type);
        }

        try {
            vmManager.advanceStart(vm.getUuid(), null, configuration.getDeploymentPlan(def));
        } catch (OperationTimedoutException e) {
            throw new CloudRuntimeException(e);
        }

        return configuration.getSystemVmVO(def);
    }
    
    protected void expunge(VirtualMachine vm) {
        if ( vm == null )
            return;

        try {
            vmManager.expunge(vm.getUuid());
        } catch (ResourceUnavailableException e1) {
            //TODO: Find VM later and mark it as delete
            log.error("Failed to expunge VM [{}]", vm.getInstanceName(), e1);
        }
    }

    protected VirtualMachine defineNewSystemVm(SystemVmDefinition def, HypervisorType type) throws InsufficientCapacityException {
        ServiceOffering serviceOffering = configuration.getServiceOffering(def);
        VirtualMachineTemplate template = configuration.getVirtualMachineTemplate(type, def.getZone().getId());

        if ( template == null ) {
            log.info("No SystemVM template found for hypervisor type [{}] in zone [{}]", type, def.getZone().getId());
            return null;
        }

        long id = configuration.getNextId();

        SystemVm systemVm = systemVmDao.createSystemVm(id,
                configuration.getRoleString(def),
                serviceOffering,
                configuration.getVmInstanceName(def, id),
                template,
                configuration.getOwner(def));

        DeploymentPlan plan = configuration.getDeploymentPlan(def);
        LinkedHashMap<Network, NicProfile> nicProfiles = configuration.getNicProfiles(def);

        boolean success = false;
        
        try {
            vmManager.allocate(systemVm.getInstanceName(), template, serviceOffering, nicProfiles, plan, systemVm.getHypervisorType());
            success = true;
        } finally {
            if ( ! success ) {
                log.error("Failed to allocate in database VM [{}] for unknown reason", systemVm.getInstanceName());
                expunge(systemVm);
            }
        }

        def.setSystemVmId(systemVm.getId());
        return systemVmDao.findById(systemVm.getId());
    }

    protected boolean shouldBeReplaced(SystemVmDefinition def, VirtualMachine vm) {
        if ( vm == null )
            return false;
        
        switch (vm.getState()) {
        case Stopped:
            return needsNewTemplate(def, vm);
        case Destroyed:
        case Error:
        case Expunging:
            return true;
        case Migrating:
        case Running:
        case Shutdowned:
        case Starting:
        case Stopping:
            return false;
        case Unknown:
            return true;
        }
        
        return false;
    }
    
    protected boolean needsNewTemplate(SystemVmDefinition def, VirtualMachine vm) {
        VirtualMachineTemplate template = configuration.getVirtualMachineTemplate(vm.getHypervisorType(), def.getZone().getId());

        return ( vm.getTemplateId() != template.getId() ); 
    }

    protected void expungeVm(VirtualMachine vm) throws ResourceUnavailableException {
        vmManager.expunge(vm.getUuid());
    }

    public SystemVmDao getSystemVmDao() {
        return systemVmDao;
    }

    @Inject
    public void setSystemVmDao(SystemVmDao systemVmDao) {
        this.systemVmDao = systemVmDao;
    }

    public VirtualMachineManager getVmManager() {
        return vmManager;
    }

    @Inject
    public void setVmManager(VirtualMachineManager vmManager) {
        this.vmManager = vmManager;
    }

    public SystemVmConfiguration getConfiguration() {
        return configuration;
    }

    @Inject
    public void setConfiguration(SystemVmConfiguration configuration) {
        this.configuration = configuration;
    }

}
