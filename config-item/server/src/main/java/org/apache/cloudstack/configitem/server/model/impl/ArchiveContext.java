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
package org.apache.cloudstack.configitem.server.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.cloudstack.configitem.server.model.Request;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;


public class ArchiveContext {

    String version;
    Request request;
    TarArchiveOutputStream taos;
    Map<String, Object> data = new HashMap<String, Object>();

    public ArchiveContext(Request request, TarArchiveOutputStream taos, String version) {
        super();
        this.request = request;
        this.taos = taos;
        this.version = version;

        data.put("version", version);
    }

    public Request getRequest() {
        return request;
    }

    public TarArchiveOutputStream getOutputStream() {
        return taos;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getVersion() {
        return version;
    }

}
