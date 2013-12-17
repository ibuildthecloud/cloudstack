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
package org.apache.cloudstack.configitem.server.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.apache.cloudstack.configitem.model.DefaultItemVersion;
import org.apache.cloudstack.configitem.model.ItemVersion;
import org.apache.cloudstack.configitem.registry.impl.ConfigItemRegistryImpl;
import org.apache.cloudstack.configitem.server.impl.ConfigItemServerImpl;
import org.apache.cloudstack.configitem.server.model.impl.TestRequest;
import org.apache.cloudstack.configitem.server.model.impl.WriteStringConfigItem;
import org.apache.cloudstack.configitem.version.ConfigItemStatusManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConfigItemServerImplTest {

    ConfigItemServerImpl server;
    ConfigItemRegistryImpl registry;
    TestRequest req;

    @Mock
    ConfigItemStatusManager versionManager = null;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        registry = new ConfigItemRegistryImpl();

        server = new ConfigItemServerImpl();
        server.setVersionManager(versionManager);
        server.setItemRegistry(registry);
        req = new TestRequest();
    }

    @Test
    public void test_not_found() throws Exception {
        req.setItemName("missing");
        server.handleRequest(req);

        assertEquals(404, req.getResponseCode());
        assertEquals("", req.getResponseContent());
    }

    @Test
    public void test_write_string() throws Exception {
        registry.register(new WriteStringConfigItem("string", "content"));
        req.setItemName("string");
        server.handleRequest(req);

        assertEquals(200, req.getResponseCode());
        assertEquals("content", req.getResponseContent());
    }
    
    @Test
    public void test_applied() throws Exception {
        ArgumentCaptor<ItemVersion> itemVersion = ArgumentCaptor.forClass(ItemVersion.class);
        DefaultItemVersion version = DefaultItemVersion.fromString("000000042-ok");

        req.setAppliedVersion(version);
        server.handleRequest(req);

        verify(versionManager).setApplied(eq(req.getClient()), eq("testitem"), itemVersion.capture());

        assertEquals(42, itemVersion.getValue().getRevision());
        assertEquals("ok", itemVersion.getValue().getSourceRevision());
        assertEquals(200, req.getResponseCode());
    }

    @Test
    public void test_applied_latest() throws Exception {
        DefaultItemVersion version = DefaultItemVersion.fromString("latest");

        req.setAppliedVersion(version);
        req.setItemName("name1");
        registry.register(new WriteStringConfigItem("name1", "content1"));
        server.handleRequest(req);

        assertTrue(version.isLatest());
        verify(versionManager).setLatest(eq(req.getClient()), eq("name1"), eq("name1/content1"));
        assertEquals(200, req.getResponseCode());
    }

    @Test
    public void test_applied_latest_not_found() throws Exception {
        DefaultItemVersion version = DefaultItemVersion.fromString("latest");

        req.setAppliedVersion(version);
        req.setItemName("name1");
        server.handleRequest(req);

        assertEquals(404, req.getResponseCode());
    }

}
