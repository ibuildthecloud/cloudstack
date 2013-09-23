// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.serializer;



import org.apache.cloudstack.framework.json.GsonStyleMapper;
import org.apache.cloudstack.framework.json.JsonMapper;
import org.apache.log4j.Logger;

import com.cloud.agent.api.Answer;
import com.cloud.agent.api.Command;
import com.cloud.agent.api.to.DataStoreTO;
import com.cloud.agent.api.to.DataTO;
import com.cloud.agent.transport.ArrayInterfaceDeserializer;
import com.cloud.agent.transport.ArrayInterfaceSerializer;
import com.cloud.agent.transport.InterfaceSerializer;
import com.cloud.agent.transport.LoggingExclusionFilter;
import com.cloud.agent.transport.NwGroupsCommandSerializer;
import com.cloud.agent.transport.PairDeserializer;
import com.cloud.utils.Pair;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JsonHelper {
    protected static final Logger s_logger = Logger.getLogger(JsonHelper.class);

    protected static final JsonMapper s_json;
    protected static final JsonMapper s_jogger;

    static {
        s_json = createMapper(false);
        s_jogger = createMapper(true);
    }

    static JsonMapper createMapper(boolean logger) {
        GsonStyleMapper innerJsonMapper = new GsonStyleMapper();
        ObjectMapper innerJsonObjectMapper = innerJsonMapper.getObjectMapper();

        GsonStyleMapper jsonMapper = new GsonStyleMapper();
        ObjectMapper jsonObjectMapper = jsonMapper.getObjectMapper();

        SimpleModule module = new SimpleModule();
        JavaType pairType = jsonObjectMapper.getTypeFactory().constructType(new TypeReference<Pair<Long, Long>>() {
        });

        LoggingExclusionFilter loggingFilter = logger ? new LoggingExclusionFilter(s_logger) : null;
        
        module.addSerializer(new NwGroupsCommandSerializer(pairType));
        module.addSerializer(new InterfaceSerializer<DataTO>(DataTO.class, innerJsonObjectMapper));
        module.addSerializer(new InterfaceSerializer<DataStoreTO>(DataStoreTO.class, innerJsonObjectMapper));
        module.addSerializer(new InterfaceSerializer<DataStoreTO>(DataStoreTO.class, innerJsonObjectMapper));
        module.addSerializer(new ArrayInterfaceSerializer<Command>(Command[].class, loggingFilter));
        module.addSerializer(new ArrayInterfaceSerializer<Answer>(Answer[].class, loggingFilter));
        module.addDeserializer(Command.class, new ArrayInterfaceDeserializer<Command>(Command.class));
        module.addDeserializer(Answer.class, new ArrayInterfaceDeserializer<Answer>(Answer.class));
        module.addDeserializer(DataTO.class, new ArrayInterfaceDeserializer<DataTO>(DataTO.class));
        module.addDeserializer(DataStoreTO.class, new ArrayInterfaceDeserializer<DataStoreTO>(DataStoreTO.class));
        module.addDeserializer(Pair.class, new PairDeserializer(pairType));

        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("noLog", loggingFilter);

        if (logger) {
            module.setMixInAnnotation(Command.class, CommandFilterMix.class);
            jsonObjectMapper.setFilters(filterProvider);
            innerJsonObjectMapper.setFilters(filterProvider);
        }

        jsonObjectMapper.registerModule(module);

        return jsonMapper;
    }

    public final static JsonMapper getJson() {
        return s_json;
    }

    public final static JsonMapper getJsonLogger() {
        return s_jogger;
    }

    public final static Logger getLogger() {
        return s_logger;
    }

    @JsonFilter("noLog")
    public static class CommandFilterMix {

    }
}
