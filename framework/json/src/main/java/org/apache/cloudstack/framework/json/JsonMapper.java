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
package org.apache.cloudstack.framework.json;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Collection;

public interface JsonMapper {

    <T> T readValue(byte[] bytes, Class<T> type) throws IOException;

    <T> T readValue(String text, Class<T> type) throws IOException;

    String writeValueAsString(Object object) throws IOException;

    byte[] writeValueAsBytes(Object data) throws IOException;

    void writeValue(OutputStream baos, Object object) throws IOException;

    @SuppressWarnings("rawtypes")
    <T> T readCollectionValue(String content, Class<? extends Collection> collectionClass, Class<?> elementsClass)
            throws IOException;

    <T> T convertValue(Object fromValue, Class<T> toValueType);

    /**
     * This method provides a toJson() method to match Gson. It is preferable to
     * use writeValueAsString() as that method throws an IOException.
     * 
     * @param object
     * @return
     */
    String toJson(Object object);
    
    /**
     * This method provides a toJson() method to match Gson.
     * 
     * @param object
     * @param os
     */
    void toJson(Object object, Writer os);

    /**
     * This method provides a fromJson() method to match Gson. It is preferable
     * to use readValue() as that method throws an IOException.
     * 
     * @param text
     * @param type
     * @return
     */
    <T> T fromJson(String text, Class<T> type);

}
