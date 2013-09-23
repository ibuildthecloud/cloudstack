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

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ArrayInterfaceSerializer<T> extends StdSerializer<T[]> {

    LoggingExclusionFilter filter;

    public ArrayInterfaceSerializer(Class<T[]> type, LoggingExclusionFilter filter) {
        super(type);

        this.filter = filter;
    }

    @Override
    public void serialize(T[] values, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonGenerationException {

        jgen.writeStartArray();
        for (T value : values) {
            jgen.writeStartObject();
            if (filter == null || (value != null && !filter.shouldSkipClass(value.getClass()))) {
                jgen.writeObjectField(value.getClass().getName(), value);
            }
            jgen.writeEndObject();
        }
        jgen.writeEndArray();

    }

}