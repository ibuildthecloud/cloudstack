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
import java.io.OutputStream;

import org.apache.cloudstack.configitem.server.model.impl.AbstractArchiveBasedConfigItem;
import org.apache.cloudstack.configitem.server.model.impl.ArchiveContext;
import org.apache.cloudstack.configitem.server.resource.Resource;
import org.apache.cloudstack.configitem.server.resource.ResourceRoot;
import org.apache.cloudstack.configitem.version.ConfigItemStatusManager;

public class TemplatesBasedArchiveItem extends AbstractArchiveBasedConfigItem {

    private static final String TEMPLATE_KEY = "template";

    TemplateFactory templateFactory;

    public TemplatesBasedArchiveItem(String name, ConfigItemStatusManager versionManager, ResourceRoot resourceRoot,
            TemplateFactory templateFactory) {
        super(name, versionManager, resourceRoot);
        this.templateFactory = templateFactory;
    }

    @Override
    protected void writeContent(final ArchiveContext context) throws IOException {
        super.writeContent(context);

        populateContext(context);

        for ( Resource resource : getResourceRoot().getResources() ) {
            Template template = null;
            Object cached = resource.getAttibute(TEMPLATE_KEY);

            if ( cached == null || ! ( cached instanceof Template )) {
                template = templateFactory.loadTemplate(resource);
                resource.setAttribute(TEMPLATE_KEY, template);
            } else {
                template = (Template)cached;
            }

            if ( template == null )
                continue;

            final Template templateFinal = template;
            withEntry(context, templateFinal.getOutputName(), template.getSize(), new WithEntry() {
                @Override
                public void with(OutputStream os) throws IOException {
                    templateFinal.execute(context.getData(), os);
                }
            });
        }
    }

    private void populateContext(ArchiveContext context) {
    }

}