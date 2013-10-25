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
package org.apache.cloudstack.systemvm.managment.provider;

import java.util.Collection;

import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinitionSet;
import org.apache.cloudstack.systemvm.managment.service.impl.SystemVmEvent;

public interface SystemVmDefinitionSetProvider {

    public static int PRIORITY_HIG = 50;
    public static int PRIORITY_NORMAL = 100;
    public static int PRIORITY_LOW = 150;
    public static int PRIORITY_NONE = -1;

    int canHandle(SystemVmEvent event);

    Collection<SystemVmDefinitionSet> getSystemVmSet(SystemVmEvent event);

}
