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
package org.apache.cloudstack.archaius.util;

import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicDoubleProperty;
import com.netflix.config.DynamicFloatProperty;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class ArchaiusUtil {

    public static DynamicLongProperty getLongProperty(String key) {
        return DynamicPropertyFactory.getInstance().getLongProperty(key, 0);
    }

    public static DynamicIntProperty getIntProperty(String key) {
        return DynamicPropertyFactory.getInstance().getIntProperty(key, 0);
    }

    public static DynamicBooleanProperty getBooleanProperty(String key) {
        return DynamicPropertyFactory.getInstance().getBooleanProperty(key, false);
    }

    public static DynamicDoubleProperty getDoubleProperty(String key) {
        return DynamicPropertyFactory.getInstance().getDoubleProperty(key, 0);
    }

    public static DynamicFloatProperty getFloatProperty(String key) {
        return DynamicPropertyFactory.getInstance().getFloatProperty(key, 0);
    }

    public static DynamicStringProperty getStringProperty(String key) {
        return DynamicPropertyFactory.getInstance().getStringProperty(key, null);
    }

}
