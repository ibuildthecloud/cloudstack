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
package org.apache.cloudstack.configitem.server.template;

import java.io.IOException;

import org.apache.cloudstack.configitem.server.resource.Resource;

public interface TemplateLoader {

    public static final int NO_PRIORITY = Integer.MAX_VALUE;
    public static final int HIGH_PRIORITY = 100;
    public static final int MID_PRIORITY = 500;
    public static final int LOW_PRIORITY = 1000;

    int canHandle(Resource resource);

    Template loadTemplate(Resource resource) throws IOException;

}
