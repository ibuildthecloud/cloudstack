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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition;
import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinitionSet;
import org.apache.cloudstack.systemvm.managment.provider.SystemVmDefinitionSetProvider;
import org.apache.cloudstack.systemvm.managment.service.SystemVmEventFactory;
import org.apache.cloudstack.systemvm.managment.service.SystemVmLifecycleOperations;
import org.apache.cloudstack.systemvm.managment.service.SystemVmManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.utils.db.EntityManager;
import com.cloud.vm.VirtualMachine.Type;

public class SystemVmManagerImpl implements SystemVmManager {

    private static final Logger log = LoggerFactory.getLogger(SystemVmManagerImpl.class);

    EntityManager entityManager;
    List<SystemVmDefinitionSetProvider> vmSetProvider;
    SystemVmEventFactory eventFactory;
    SystemVmLifecycleOperations operation;

    @Override
    public void process(String eventName, Class<?> entityType, Long entityId) throws InsufficientCapacityException, ResourceUnavailableException {
        SystemVmEvent event = eventFactory.getEvent(eventName, entityType, entityId);

        log.info("Processing {}", event);

        Collection<SystemVmDefinitionSet> vmDefinitionSets = getVmDefinitionSet(event);

        if ( vmDefinitionSets == null || vmDefinitionSets.size() == 0 ) {
            log.info("No associated SystemVMs found for [{}]", event);
            return;
        }

        preProcessLifeCycle(event, vmDefinitionSets);
//        preProcessEvent(event, vmDefinitionSets);
//        postProcessLifeCycle(event, vmDefinitionSets);
//        postProcessEvent(event, vmDefinitionSets);
    }

    protected void preProcessLifeCycle(SystemVmEvent event, Collection<SystemVmDefinitionSet> vmDefinitionSets) throws InsufficientCapacityException, ResourceUnavailableException {
        for ( SystemVmDefinitionSet set : vmDefinitionSets ) {
            preProcessLifeCycle(event, set);
        }
    }

    protected void preProcessLifeCycle(SystemVmEvent event, SystemVmDefinitionSet set) throws InsufficientCapacityException, ResourceUnavailableException {
        boolean operatingOnSystemVm = event.getVirtualMachine() == null ? false : (event.getVirtualMachine().getType() == Type.SystemVm);
        for ( SystemVmDefinition def : set.getSystemVmDefinitions() ) {
            if ( def.getDesiredState() == null )
                continue;

            if ( operatingOnSystemVm ) {
                /* If the current operation is on a system VM, we don't want to do any
                 * life cycle tasks.  Because weird loops will happen...
                 */
                def.setDesiredState(null);
                continue;
            }

            switch (def.getDesiredState()) {
            case REMOVE:
                operation.remove(def);
                break;
            case RUNNING:
                operation.startSystemVm(def);
                break;
            default:
                break;
            }
        }
    }

    protected Collection<SystemVmDefinitionSet> getVmDefinitionSet(SystemVmEvent event) {
        Map<Integer, SystemVmDefinitionSetProvider> canHandle = new TreeMap<Integer, SystemVmDefinitionSetProvider>(); 

        for ( SystemVmDefinitionSetProvider provider : vmSetProvider ) {
            int handleResult = provider.canHandle(event);
            if ( handleResult > SystemVmDefinitionSetProvider.PRIORITY_NONE ) {
                canHandle.put(handleResult, provider);
            }
        }

        if ( canHandle.size() > 0 ) {
            return canHandle.values().iterator().next().getSystemVmSet(event);
        } else {
            return Collections.emptySet();
        }
    }    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<SystemVmDefinitionSetProvider> getVmSetProvider() {
        return vmSetProvider;
    }

    @Inject
    public void setVmSetProvider(List<SystemVmDefinitionSetProvider> vmSetProvider) {
        this.vmSetProvider = vmSetProvider;
    }

    public SystemVmEventFactory getEventFactory() {
        return eventFactory;
    }

    @Inject
    public void setEventFactory(SystemVmEventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    public SystemVmLifecycleOperations getOperation() {
        return operation;
    }

    @Inject
    public void setOperation(SystemVmLifecycleOperations operation) {
        this.operation = operation;
    }

}