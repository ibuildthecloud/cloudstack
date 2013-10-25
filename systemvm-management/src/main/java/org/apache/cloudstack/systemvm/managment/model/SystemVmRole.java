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
package org.apache.cloudstack.systemvm.managment.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SystemVmRole {
    private static List<SystemVmRole> roles = new ArrayList<SystemVmRole>();
    private static Map<String, SystemVmRole> rolesByName = new HashMap<String, SystemVmRole>();

    public static final SystemVmRole VirtualRouter = new SystemVmRole("VirtualRouter", "r");
    public static final SystemVmRole ConsoleProxy = new SystemVmRole("ConsoleProxy", "v");
    public static final SystemVmRole SecondaryStorage = new SystemVmRole("SecondaryStorage", "s");
    public static final SystemVmRole ElasticLbVm = new SystemVmRole("ElasticLbVm", "l");
    public static final SystemVmRole InternalLbVm = new SystemVmRole("InternalLbVm", "b");

    private final String name;
    private final String shortName;

    public SystemVmRole(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
        roles.add(this);
        rolesByName.put(name, this);
    }

    public static SystemVmRole getRole(String name) {
        return rolesByName.get(name);
    }
    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String toString() {
        return name.toString();
    }

    public static Set<SystemVmRole> getRoleSet(SystemVmRole... roles) {
        Set<SystemVmRole> result = new HashSet<SystemVmRole>();

        for ( SystemVmRole role : roles ) {
            result.add(role);
        }

        return result;
    }

}