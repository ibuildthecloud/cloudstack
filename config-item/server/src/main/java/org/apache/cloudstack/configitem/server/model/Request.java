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
package org.apache.cloudstack.configitem.server.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.apache.cloudstack.configitem.model.Client;
import org.apache.cloudstack.configitem.model.ItemVersion;

public interface Request {

    public static final int OK = 200;
    public static final int NOT_FOUND = 404;

    ItemVersion getAppliedVersion();

    String getItemName();

    Client getClient();

    void setResponseCode(int code);

    void setContentType(String contentType);

    OutputStream getOutputStream() throws IOException;

    Map<String, String[]> getParams();

}
