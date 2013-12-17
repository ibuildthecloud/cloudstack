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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.cloudstack.configitem.server.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTemplate implements org.apache.cloudstack.configitem.server.template.Template {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerTemplate.class);

    String outputName;
    Template template;
    Resource resource;

    public FreemarkerTemplate(String outputName, Template template, Resource resource) {
        super();
        this.outputName = outputName;
        this.template = template;
        this.resource = resource;
    }

    @Override
    public String getOutputName() {
        return outputName;
    }

    @Override
    public void execute(Map<String, Object> context, OutputStream os) throws IOException {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(os);
            template.process(context, writer);
        } catch (TemplateException e) {
            log.error("Failed to run template for [{}]", resource.getName(), e);
            throw new IOException(e);
        } finally {
            writer.flush();
        }
    }

    @Override
    public long getSize() {
        return -1;
    }

}
