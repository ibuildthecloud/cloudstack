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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.cloud.network.Network;
import com.cloud.network.Network.Capability;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;
import com.cloud.network.element.NetworkElement;
import com.cloud.network.element.VpcProvider;

public class GenericNetworkElementFactory {

    String providerName;
    boolean external;
    boolean inBuild;
    Provider provider;
    Map<String, Map<String, String>> services;
    Set<String> networkElementMethods = new HashSet<String>();
    NetworkElement networkElementDelegate = null;
    NetworkElement networkElement = null;
    Set<Class<?>> interfaces = new HashSet<Class<?>>();
    GenericNetworkElementDelegate genericNetworkElementDelete;

    boolean handleShutdown, handleDestroy, handleRelease, handleImplement, handlePrepare, handleIsReady,
            handleShutdownProviderInstances, handleCanEnableIndividualServices, handleVerifyServicesCombination;

    boolean canEnableIndividualServices = true;

    public String getProviderName() {
        return providerName;
    }

    @Inject
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public Map<String, Map<String, String>> getServices() {
        return services;
    }

    public void setServices(Map<String, Map<String, String>> services) {
        this.services = services;
    }

    public NetworkElement buildNetworkElement() throws Exception {
        if ( networkElement != null )
            return networkElement;

        findNetworkElementMethods();
        determineHandles();
        constructNetworkElementDelegate();
        determineInterfaces();

        GenericNetworkElementInvocationHandler handler =
                new GenericNetworkElementInvocationHandler(networkElementDelegate, networkElementMethods);
        Class<?>[] types = interfaces.toArray(new Class<?>[interfaces.size()]);
        handler.setDelegate(genericNetworkElementDelete);

        networkElement = (NetworkElement)Proxy.newProxyInstance(networkElementDelegate.getClass().getClassLoader(), types, handler);

        return networkElement;
    }

    protected void constructNetworkElementDelegate() {
        if (networkElementDelegate != null)
            return;

        GenericNetworkElement gne = new GenericNetworkElement(providerName, external);
        gne.setCapabilities(determineCapabilites());
        gne.setCanEnableIndividualServices(canEnableIndividualServices);

        networkElementDelegate = gne;
    }

    protected void determineInterfaces() {
        interfaces.add(NetworkElement.class);

        for ( Service service : networkElementDelegate.getCapabilities().keySet() ) {
            Class<?> type = service.getServiceProviderInterface();

            if ( type != null )
                interfaces.add(type);
        }
    }

    protected Map<Service, Map<Capability, String>> determineCapabilites() {
        Map<Service, Map<Capability, String>> capabilities = new HashMap<Network.Service, Map<Capability, String>>();

        if (services == null)
            return capabilities;

        for (Map.Entry<String, Map<String, String>> entry : services.entrySet()) {
            String serviceName = entry.getKey();

            if ("Vpc".equals(serviceName)) {
                addVpc();
                continue;
            }

            Service service = Service.getService(serviceName);

            if (service == null) {
                throw new IllegalArgumentException("[" + serviceName + "] is not a valid service name");
            }

            Map<Capability, String> serviceCapabilities = new HashMap<Capability, String>();
            capabilities.put(service, serviceCapabilities);

            for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                String capabilityName = entry2.getKey();
                String capabilityValue = entry2.getValue();

                Capability capability = Capability.getCapability(capabilityName);
                if (capability == null) {
                    throw new IllegalArgumentException("[" + capabilityName + "] is not a valid capability");
                }

                if (!ArrayUtils.contains(service.getCapabilities(), capability)) {
                    throw new IllegalArgumentException("[" + capabilityName
                            + "] is not a valid capability for service [" + serviceName + "]");
                }

                serviceCapabilities.put(capability, capabilityValue);
            }
        }

        return capabilities;
    }

    protected void addVpc() {
        interfaces.add(VpcProvider.class);
    }

    protected void findNetworkElementMethods() {
        for ( Class<?> clz : new Class[] { NetworkElement.class, Object.class } ) {
            for (Method m : clz.getMethods()) {
                networkElementMethods.add(m.getName());
            }
        }
    }


    protected void determineHandles() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        /*
         * Temp variable is to work around compilation issue, not sure why it
         * happens...
         */
        @SuppressWarnings("unchecked")
        Set<Map.Entry<?, ?>> entrySet = BeanUtils.describe(this).entrySet();
        for (Map.Entry<?, ?> entry : entrySet) {
            String key = entry.getKey().toString();
            Object value = entry.getValue();

            if (key.startsWith("handle")) {
                String delegateMethod = StringUtils.uncapitalize(key.substring("handle".length()));

                if ("true".equals(value)) {
                    networkElementMethods.remove(delegateMethod);
                }
            }
        }
    }

    public boolean isHandleShutdown() {
        return handleShutdown;
    }

    public void setHandleShutdown(boolean handleShutdown) {
        this.handleShutdown = handleShutdown;
    }

    public boolean isHandleDestroy() {
        return handleDestroy;
    }

    public void setHandleDestroy(boolean handleDestroy) {
        this.handleDestroy = handleDestroy;
    }

    public boolean isHandleRelease() {
        return handleRelease;
    }

    public void setHandleRelease(boolean handleRelease) {
        this.handleRelease = handleRelease;
    }

    public boolean isHandleImplement() {
        return handleImplement;
    }

    public void setHandleImplement(boolean handleImplement) {
        this.handleImplement = handleImplement;
    }

    public boolean isHandlePrepare() {
        return handlePrepare;
    }

    public void setHandlePrepare(boolean handlePrepare) {
        this.handlePrepare = handlePrepare;
    }

    public boolean isHandleIsReady() {
        return handleIsReady;
    }

    public void setHandleIsReady(boolean handleIsReady) {
        this.handleIsReady = handleIsReady;
    }

    public boolean isHandleShutdownProviderInstances() {
        return handleShutdownProviderInstances;
    }

    public void setHandleShutdownProviderInstances(boolean handleShutdownProviderInstances) {
        this.handleShutdownProviderInstances = handleShutdownProviderInstances;
    }

    public boolean isHandleCanEnableIndividualServices() {
        return handleCanEnableIndividualServices;
    }

    public void setHandleCanEnableIndividualServices(boolean handleCanEnableIndividualServices) {
        this.handleCanEnableIndividualServices = handleCanEnableIndividualServices;
    }

    public boolean isHandleVerifyServicesCombination() {
        return handleVerifyServicesCombination;
    }

    public void setHandleVerifyServicesCombination(boolean handleVerifyServicesCombination) {
        this.handleVerifyServicesCombination = handleVerifyServicesCombination;
    }

    public boolean isCanEnableIndividualServices() {
        return canEnableIndividualServices;
    }

    public void setCanEnableIndividualServices(boolean canEnableIndividualServices) {
        this.canEnableIndividualServices = canEnableIndividualServices;
    }

    public NetworkElement getNetworkElementDelegate() {
        return networkElementDelegate;
    }

    public void setNetworkElementDelegate(NetworkElement networkElementDelegate) {
        this.networkElementDelegate = networkElementDelegate;
    }

    public boolean isInBuild() {
        return inBuild;
    }

    public GenericNetworkElementDelegate getGenericNetworkElementDelete() {
        return genericNetworkElementDelete;
    }

    @Inject
    public void setGenericNetworkElementDelete(GenericNetworkElementDelegate genericNetworkElementDelete) {
        this.genericNetworkElementDelete = genericNetworkElementDelete;
    }

}
