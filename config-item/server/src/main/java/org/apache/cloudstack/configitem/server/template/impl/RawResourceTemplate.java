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
package org.apache.cloudstack.configitem.server.template.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.cloudstack.configitem.server.resource.Resource;
import org.apache.cloudstack.configitem.server.template.Template;
import org.apache.commons.io.IOUtils;

public class RawResourceTemplate implements Template {

    Resource resource;

    public RawResourceTemplate(Resource resource) {
        super();
        this.resource = resource;
    }

    @Override
    public String getOutputName() {
        return resource.getName();
    }

    @Override
    public void execute(Map<String, Object> context, OutputStream os) throws IOException {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            IOUtils.copy(is, os);
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    @Override
    public long getSize() {
        return resource.getSize();
    }

}
