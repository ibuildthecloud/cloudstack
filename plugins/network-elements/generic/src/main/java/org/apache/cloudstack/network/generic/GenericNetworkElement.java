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
package org.apache.cloudstack.network.generic;

import java.util.HashMap;
import java.util.Map;

import com.cloud.network.Network;
import com.cloud.network.Network.Capability;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;

public class GenericNetworkElement extends AbstractNetworkElement {

    Provider provider;
    boolean canEnableIndividualServices = true;
    Map<Service, Map<Capability, String>> capabilities = new HashMap<Network.Service, Map<Capability, String>>();

    public GenericNetworkElement(String name, boolean external) {
        if (name == null)
            throw new IllegalArgumentException("name can not be null");

        this.provider = Provider.getProvider(name);

        if (provider == null) {
            provider = new Provider(name, external);
        }

        setName(name);
    }

    @Override
    public Map<Service, Map<Capability, String>> getCapabilities() {
        return capabilities;
    }

    @Override
    public boolean canEnableIndividualServices() {
        return canEnableIndividualServices;
    }

    @Override
    public Provider getProvider() {
        return provider;
    }

    public boolean isCanEnableIndividualServices() {
        return canEnableIndividualServices;
    }

    public void setCanEnableIndividualServices(boolean canEnableIndividualServices) {
        this.canEnableIndividualServices = canEnableIndividualServices;
    }

    public void setCapabilities(Map<Service, Map<Capability, String>> capabilities) {
        this.capabilities = capabilities;
    }

    public String toString() {
        return "Network Element: " + provider;
    }
}
