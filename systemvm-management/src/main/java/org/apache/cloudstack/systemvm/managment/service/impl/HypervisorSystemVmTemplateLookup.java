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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.apache.cloudstack.framework.config.ConfigDepot;
import org.apache.cloudstack.framework.config.ConfigKey;
import org.apache.cloudstack.framework.config.Configurable;

import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.storage.dao.VMTemplateDao;
import com.cloud.template.VirtualMachineTemplate;

/**
 * Maintains a mapping of Hypervisor Type to the specific VM template for that Zone.
 * This code goes to great length to attempt to be generic and not have hard coded Hypervisor
 * types.  As new hypervisors are added, nothing should need to change in the class.
 */
public class HypervisorSystemVmTemplateLookup implements Configurable {
    
    private static final String KEY = "router.template.";
    private static final String DEFAULT = "SystemVM Template (%s)";
    private static final String DESC = "Name of the default router template on %s.";
    
    /* This will go away when we delete the keys from VirtualNetworkApplianceManager */
    private static final Set<HypervisorType> BLACKLIST_CONFIG_KEYS = new HashSet<HypervisorType>(
            Arrays.asList(
                    HypervisorType.XenServer, 
                    HypervisorType.KVM,
                    HypervisorType.VMware,
                    HypervisorType.Hyperv,
                    HypervisorType.LXC)
    );
    private static final Map<String, String> HYPERVISOR_TO_KEY_MAP = new HashMap<String, String>();
    private static final Map<String, String> HYPERVISOR_TO_DEFAULT_MAP = new HashMap<String, String>();

    static {
        HYPERVISOR_TO_KEY_MAP.put("xenserver", "xen");
        HYPERVISOR_TO_DEFAULT_MAP.put("VMware", "vSphere");
        HYPERVISOR_TO_DEFAULT_MAP.put("Hyperv", "HyperV");
    };

    Map<HypervisorType, ConfigKey<String>> templateConfigKeys = new ConcurrentHashMap<HypervisorType, ConfigKey<String>>();
    ConfigDepot configDepot;
    VMTemplateDao vmTemplateDao;

    public VirtualMachineTemplate getVirtualMachineTemplate(HypervisorType type, long zoneId) {
        ConfigKey<?> key = getConfigKey(type);

        if ( key == null )
            throw new IllegalStateException("Template name configuration key for [" + type + "] is not found");

        Object name = key.valueIn(zoneId);
        return vmTemplateDao.findRoutingTemplate(type, name == null ? null : name.toString());
    }

    protected ConfigKey<?> getConfigKey(HypervisorType type) {
        if ( BLACKLIST_CONFIG_KEYS.contains(type) ) {
            return configDepot.get(getConfigKeyName(type));
        } else {
            return templateConfigKeys.get(type);
        }
    }
    
    @Override
    public ConfigKey<?>[] getConfigKeys() {
        return getConfigKeys(BLACKLIST_CONFIG_KEYS);
    }
    
    protected ConfigKey<?>[] getConfigKeys(Set<HypervisorType> blacklist) {
        List<ConfigKey<?>> keys = new ArrayList<ConfigKey<?>>();
        
        for ( HypervisorType type : HypervisorType.values() ) {
            if ( blacklist.contains(type) ) {
                continue;
            }

            ConfigKey<String> configKey =  new ConfigKey<String>(String.class, getConfigKeyName(type), "Advanced", 
                    getConfigDefaultValue(type), getConfigDefaultValue(type), true, ConfigKey.Scope.Zone, null);
            templateConfigKeys.put(type, configKey);
            keys.add(configKey);
        }

        return keys.toArray(new ConfigKey<?>[keys.size()]);
    }
    
    protected String getConfigKeyName(HypervisorType type) {
        String name = type.toString().toLowerCase();
        
        name = HYPERVISOR_TO_KEY_MAP.containsKey(name) ? HYPERVISOR_TO_KEY_MAP.get(name) : name;
        
        return KEY + name;
    }
    
    protected String getConfigDefaultValue(HypervisorType type) {
        String name = type.toString();
        name = HYPERVISOR_TO_DEFAULT_MAP.containsKey(name) ? HYPERVISOR_TO_DEFAULT_MAP.get(name) : name;

        return String.format(DEFAULT, name);
    }
    
    protected String getConfigDesc(HypervisorType type) {
        return String.format(DESC, type.toString());
    }

    @Override
    public String getConfigComponentName() {
        return getClass().getSimpleName();
    }

    public ConfigDepot getConfigDepot() {
        return configDepot;
    }

    @Inject
    public void setConfigDepot(ConfigDepot configDepot) {
        this.configDepot = configDepot;
    }

    public VMTemplateDao getVmTemplateDao() {
        return vmTemplateDao;
    }

    @Inject
    public void setVmTemplateDao(VMTemplateDao vmTemplateDao) {
        this.vmTemplateDao = vmTemplateDao;
    }

}
