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
package com.cloud.vm;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cloud.agent.api.Answer;
import com.cloud.agent.manager.Commands;
import com.cloud.deploy.DeployDestination;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.vm.VirtualMachine.Type;

public abstract class AbstractVirtualMachineGuru implements VirtualMachineGuru {

    @Inject
    VirtualMachineManager virtualMachineManager;
    
    @Override
    public boolean finalizeVirtualMachineProfile(VirtualMachineProfile profile, DeployDestination dest,
            ReservationContext context) {
        return true;
    }

    @Override
    public boolean finalizeDeployment(Commands cmds, VirtualMachineProfile profile, DeployDestination dest,
            ReservationContext context) throws ResourceUnavailableException {
        return true;
    }

    @Override
    public boolean finalizeStart(VirtualMachineProfile profile, long hostId, Commands cmds, ReservationContext context) {
        return true;
    }

    @Override
    public boolean finalizeCommandsOnStart(Commands cmds, VirtualMachineProfile profile) {
        return true;
    }

    @Override
    public void finalizeStop(VirtualMachineProfile profile, Answer answer) {
    }

    @Override
    public void finalizeExpunge(VirtualMachine vm) {
    }

    @Override
    public void prepareStop(VirtualMachineProfile profile) {
    }

    @PostConstruct
    public void initGuru() {
        virtualMachineManager.registerGuru(getVmType(), this);
    }

    protected abstract Type getVmType();
}