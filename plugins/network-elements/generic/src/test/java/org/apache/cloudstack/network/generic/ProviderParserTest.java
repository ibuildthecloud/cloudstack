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

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.network.Network.Capability;
import com.cloud.network.Network.Service;
import com.cloud.network.element.NetworkElement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testApplicationContext.xml")
public class ProviderParserTest {


    @Inject
    GenericNetworkElementFactory factory;
    
    @Inject
    NetworkElement networkElement;

    @Test
    public void testConstruct() {
        assertTrue(factory.isHandleShutdown());
        assertTrue(factory.isHandleIsReady());
        assertTrue(!factory.isHandleDestroy());

        assertEquals("roundrobin,leastconn,source", factory.getServices().get("Lb").get("SupportedLBAlgorithms"));
        assertEquals("roundrobin,leastconn,source", networkElement.getCapabilities().get(Service.Lb).get(Capability.SupportedLBAlgorithms));
    }
}
