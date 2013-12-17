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

import javax.inject.Inject;

import org.apache.cloudstack.configitem.server.resource.Resource;
import org.apache.cloudstack.configitem.server.template.Template;

import freemarker.template.Configuration;

public class FreemarkerTemplateLoader extends AbstractExtBasedTemplateLoader {

    Configuration configuration;

    @Override
    protected Template loadTemplate(String outputName, Resource resource) throws IOException {
        freemarker.template.Template template = configuration.getTemplate(resource.getURL().toExternalForm());
        return new FreemarkerTemplate(outputName, template, resource);
    }

    @Override
    public int getPriority() {
        return MID_PRIORITY;
    }

    @Override
    public String getExt() {
        return ".ftl";
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    @Inject
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
