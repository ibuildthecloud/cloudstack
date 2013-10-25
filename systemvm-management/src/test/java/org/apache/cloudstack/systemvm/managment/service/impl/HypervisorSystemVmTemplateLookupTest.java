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

import static org.junit.Assert.*;

import java.util.HashSet;

import org.apache.cloudstack.framework.config.ConfigKey;
import org.junit.Test;

import com.cloud.hypervisor.Hypervisor.HypervisorType;

public class HypervisorSystemVmTemplateLookupTest {

    @Test
    public void test_config_key_for_backwards_compat() {
        HypervisorSystemVmTemplateLookup mapping = new HypervisorSystemVmTemplateLookup();

        ConfigKey<?>[] keys = mapping.getConfigKeys(new HashSet<HypervisorType>());

        assertEquals(HypervisorType.values().length, keys.length);

        assertEquals("router.template.xen", mapping.templateConfigKeys.get(HypervisorType.XenServer).key()); 
        assertEquals("router.template.kvm", mapping.templateConfigKeys.get(HypervisorType.KVM).key());
        assertEquals("router.template.vmware", mapping.templateConfigKeys.get(HypervisorType.VMware).key());
        assertEquals("router.template.hyperv", mapping.templateConfigKeys.get(HypervisorType.Hyperv).key());
        assertEquals("router.template.lxc", mapping.templateConfigKeys.get(HypervisorType.LXC).key());

        assertEquals("SystemVM Template (XenServer)", mapping.templateConfigKeys.get(HypervisorType.XenServer).defaultValue());
        assertEquals("SystemVM Template (KVM)", mapping.templateConfigKeys.get(HypervisorType.KVM).defaultValue());
        assertEquals("SystemVM Template (vSphere)", mapping.templateConfigKeys.get(HypervisorType.VMware).defaultValue());
        assertEquals("SystemVM Template (HyperV)", mapping.templateConfigKeys.get(HypervisorType.Hyperv).defaultValue());
        assertEquals("SystemVM Template (LXC)", mapping.templateConfigKeys.get(HypervisorType.LXC).defaultValue());

    }

}
