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
package org.apache.cloudstack.configitem.registry.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.cloudstack.configitem.registry.ConfigItemRegistry;
import org.apache.cloudstack.configitem.server.model.ConfigItem;
import org.apache.cloudstack.configitem.server.model.ConfigItemFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.utils.component.Registry;

public class ConfigItemRegistryImpl implements Registry<ConfigItemFactory>, ConfigItemRegistry {

    private static final Logger log = LoggerFactory.getLogger(ConfigItemRegistryImpl.class);

    Map<String, ConfigItem> items = new ConcurrentHashMap<String, ConfigItem>();
    List<ConfigItemFactory> factories = new ArrayList<ConfigItemFactory>();

    @Override
    public String getName() {
        return "Config Item Registry";
    }

    @Override
    public boolean register(ConfigItemFactory type) {
        if ( factories.contains(type) )
            return false;

        try {
            for ( ConfigItem item : ((ConfigItemFactory)type).getConfigItems() ) {
                if ( items.containsKey(item.getName()) )
                    continue;

                log.info("Registering Config Item [{}]", item.getName());
                items.put(item.getName(), item);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to get config items from factory [" + type + "]");
        }

        return true;
    }

    @Override
    public void unregister(ConfigItemFactory type) {
        try {
            for ( ConfigItem item : ((ConfigItemFactory)type).getConfigItems() ) {
                items.remove(item.getName());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to get config items from factory [" + type + "]");
        } finally {
            factories.remove(type);
        }
    }

    @Override
    public List<ConfigItemFactory> getRegistered() {
        return factories;
    }

    @Override
    public ConfigItem getConfigItem(String name) {
        return items.get(name);
    }
    
    @Override
    public Collection<ConfigItem> getConfigItems() {
        return items.values();
    }

}