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
package org.apache.cloudstack.systemvm.managment.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.cloudstack.systemvm.managment.model.SystemVmNetworkAssociation;
import org.apache.cloudstack.systemvm.managment.model.impl.DefaultSystemVmNetworkAssociation;

import com.cloud.network.Network;

public class SystemVmDefinitionSetUtils {

    public static DefaultSystemVmNetworkAssociation createAssoc(Network network, boolean isDefault) {
        DefaultSystemVmNetworkAssociation def = new DefaultSystemVmNetworkAssociation();
        def.setDefault(isDefault);
        def.setNetworkId(network.getId());

        return def;
    }

    public static Map<Long, SystemVmNetworkAssociation> createMap(SystemVmNetworkAssociation... assocList) {
        Map<Long, SystemVmNetworkAssociation> systemVmAssoc = new HashMap<Long, SystemVmNetworkAssociation>();
        for ( SystemVmNetworkAssociation assoc : assocList ) {
            systemVmAssoc.put(assoc.getNetworkId(), assoc);
        }

        return systemVmAssoc;
    }
}
