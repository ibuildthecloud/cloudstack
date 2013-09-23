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
package com.cloud.agent.transport;

import org.apache.log4j.Logger;

import com.cloud.agent.api.Command;
import com.cloud.agent.api.LogLevel;
import com.cloud.agent.api.LogLevel.Log4jLevel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class LoggingExclusionFilter extends SimpleBeanPropertyFilter {

    Logger logger = null;

    public LoggingExclusionFilter(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider provider, BeanPropertyWriter writer)
            throws Exception {
        if (shouldSkipClass(bean.getClass()))
            return;

        super.serializeAsField(bean, jgen, provider, writer);
    }

    protected boolean shouldSkipClass(Class<?> clazz) {
        if (clazz.isArray() || !Command.class.isAssignableFrom(clazz)) {
            return false;
        }
        Log4jLevel log4jLevel = null;
        LogLevel level = clazz.getAnnotation(LogLevel.class);
        if (level == null) {
            log4jLevel = LogLevel.Log4jLevel.Debug;
        } else {
            log4jLevel = level.value();
        }

        return !log4jLevel.enabled(logger);
    }

    protected boolean shouldSkipField(BeanPropertyWriter writer) {
        LogLevel level = writer.getAnnotation(LogLevel.class);
        return level != null && !level.value().enabled(logger);
    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return !shouldSkipField(writer);
    }

}
