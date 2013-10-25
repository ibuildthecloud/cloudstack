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

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.cloudstack.network.generic.GenericNetworkElementDelegate;
import org.apache.cloudstack.systemvm.managment.service.SystemVmManager;

import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.vm.Nic;
import com.cloud.vm.NicProfile;

public class InvocationDelegate implements GenericNetworkElementDelegate {

    SystemVmManager systemVmManager;

    @Override
    public void invoke(String name, Object... args) throws ResourceUnavailableException, InsufficientCapacityException {
        System.err.println("*THANG*");
        System.err.println("*THANG* I got called for " + name + " : " + Arrays.toString(args));
        System.err.println("*THANG*");

        if ( "prepare".equals(name) ) {
            systemVmManager.process("prepare", Nic.class, ((NicProfile)args[1]).getId());
        }
    }

    public SystemVmManager getSystemVmManager() {
        return systemVmManager;
    }

    @Inject
    public void setSystemVmManager(SystemVmManager systemVmManager) {
        this.systemVmManager = systemVmManager;
    }

}
