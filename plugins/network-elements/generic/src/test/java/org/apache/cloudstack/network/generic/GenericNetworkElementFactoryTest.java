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

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cloud.network.Network.Capability;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;

public class GenericNetworkElementFactoryTest {

    @Test
    public void testDetectNetworkElements() throws Exception {
        GenericNetworkElementFactory gnef = new GenericNetworkElementFactory();
        gnef.setProviderName("providerName");
        gnef.buildNetworkElement();

        assertTrue(gnef.networkElementMethods.contains("isReady"));
        assertTrue(gnef.networkElementMethods.contains("implement"));
        assertTrue(gnef.networkElementMethods.contains("prepare"));
        assertTrue(gnef.networkElementMethods.contains("getCapabilities"));
        
        /* Object.class methods */
        assertTrue(gnef.networkElementMethods.contains("hashCode"));
        assertTrue(gnef.networkElementMethods.contains("toString"));
        assertTrue(gnef.networkElementMethods.contains("equals"));
        assertTrue(gnef.networkElementMethods.contains("wait"));
        assertTrue(gnef.networkElementMethods.contains("notify"));
        assertTrue(gnef.networkElementMethods.contains("notifyAll"));
        assertTrue(gnef.networkElementMethods.contains("getClass"));
    }

    @Test
    public void testDontHandle() throws Exception {
        GenericNetworkElementFactory gnef = new GenericNetworkElementFactory();
        gnef.setProviderName("providerName");
        gnef.setHandleIsReady(true);
        gnef.setHandlePrepare(true);
        gnef.buildNetworkElement();

        assertTrue(!gnef.networkElementMethods.contains("isReady"));
        assertTrue(gnef.networkElementMethods.contains("implement"));
        assertTrue(!gnef.networkElementMethods.contains("prepare"));
        assertTrue(gnef.networkElementMethods.contains("getCapabilities"));
    }

    @Test
    public void testCreateGenericNetworkElement() throws Exception {
        GenericNetworkElementFactory gnef = new GenericNetworkElementFactory();
        gnef.setProviderName("providerName");
        gnef.buildNetworkElement();

        assertEquals("providerName", gnef.getNetworkElementDelegate().getName());
        assertEquals("providerName", gnef.getNetworkElementDelegate().getProvider().getName());
        assertNotNull(Provider.getProvider("providerName"));
    }

    @Test
    public void testServices() throws Exception {
        GenericNetworkElementFactory gnef = new GenericNetworkElementFactory();
        Map<String, Map<String, String>> services = new HashMap<String, Map<String, String>>();
        services.put("Vpn", new HashMap<String, String>());
        services.get("Vpn").put("SupportedVpnProtocols", "blah");

        gnef.setServices(services);

        Map<Service, Map<Capability, String>> caps = gnef.determineCapabilites();
        
        assertEquals(1, caps.size());
        assertEquals(Service.Vpn, caps.keySet().iterator().next());
        assertEquals("blah", caps.get(Service.Vpn).get(Capability.SupportedVpnProtocols));
    }

    @Test
    public void testBadServices() throws Exception {
        GenericNetworkElementFactory gnef = new GenericNetworkElementFactory();
        Map<String, Map<String, String>> services = new HashMap<String, Map<String, String>>();
        services.put("Vpn1", new HashMap<String, String>());
        services.get("Vpn1").put("SupportedVpnProtocols", "blah");

        gnef.setServices(services);

        try {
            gnef.determineCapabilites();
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("not a valid service name"));
        }

        services.clear();
        services.put("Vpn", new HashMap<String, String>());
        services.get("Vpn").put("1SupportedVpnProtocols", "blah");

        gnef.setServices(services);

        try {
            gnef.determineCapabilites();
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().endsWith("not a valid capability"));
        }

        services.clear();
        services.put("Vpn", new HashMap<String, String>());
        services.get("Vpn").put("AssociatePublicIP", "blah");

        gnef.setServices(services);

        try {
            gnef.determineCapabilites();
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("not a valid capability for service"));
        }

        services.clear();
    }
}
