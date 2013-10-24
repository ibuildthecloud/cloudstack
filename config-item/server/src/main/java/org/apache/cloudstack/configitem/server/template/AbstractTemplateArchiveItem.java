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
import java.util.List;

import org.apache.cloudstack.configitem.server.model.impl.AbstractArchiveBasedConfigItem;
import org.apache.cloudstack.configitem.server.model.impl.ArchiveContext;

public abstract class AbstractTemplateArchiveItem extends AbstractArchiveBasedConfigItem {

    List<Template> templates;

    @Override
    protected void writeContent(final ArchiveContext context) throws IOException {
        super.writeContent(context);

        populateContext(context);

        for (final Template template : getTemplates()) {
            withEntry(context, template.getName(), new WithEntry() {
                @Override
                public void with(OutputStream os) throws IOException {
                    template.execute(context.getData(), os);
                }
            });
        }
    }

    private void populateContext(ArchiveContext context) {
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    public List<Template> getTemplates() {
        return templates;
    }

}