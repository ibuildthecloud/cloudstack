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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.cloudstack.archaius.util.ArchaiusUtil;
import org.apache.cloudstack.configitem.server.model.ConfigItem;
import org.apache.cloudstack.configitem.server.model.ConfigItemFactory;
import org.apache.cloudstack.configitem.server.resource.FileBasedResourceRoot;
import org.apache.cloudstack.configitem.server.template.TemplateFactory;
import org.apache.cloudstack.configitem.server.template.TemplatesBasedArchiveItem;
import org.apache.cloudstack.configitem.version.ConfigItemStatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.config.DynamicStringProperty;

public class GenericConfigItemFactory implements ConfigItemFactory  {

    private static final Logger log = LoggerFactory.getLogger(GenericConfigItemFactory.class);

    private static final DynamicStringProperty LOCATIONS = ArchaiusUtil.getStringProperty("config.item.locations");

    ConfigItemStatusManager versionManager;
    List<ConfigItem> items = new ArrayList<ConfigItem>();
    TemplateFactory templateFactory;

    protected File findDevRoot() {
        URL url = GenericConfigItemFactory.class.getResource("/systemvm/.systemvmscripts");
        if ( url != null && "file".equals(url.getProtocol()) ) {
            File scriptsRoot = new File(new File(url.getPath()).getParentFile(), "../../../src/main/resources/systemvm");
            if ( scriptsRoot.exists() ) {
                try {
                    return new File(scriptsRoot.getCanonicalPath());
                } catch (IOException e) {
                    log.error("Failed to get canonical path of [{}]", scriptsRoot, e);
                }
            }
        }

        return null;
    }

    protected void locateResourceRoot() throws IOException {
//        try {
            File f = findDevRoot();
            processFileRoot(f, false);
            System.err.println("File: " + f);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

    protected void processFileRoot(File root, boolean useCache) throws IOException {
        String[] children = root.list();

        if ( children == null )
            return;

        for ( String child : children ) {
            File childFile = new File(root, child);
            if ( ! child.startsWith(".") && childFile.isDirectory() ) {
                FileBasedResourceRoot itemResource = new FileBasedResourceRoot(childFile, useCache);
                itemResource.scan();
                items.add(new TemplatesBasedArchiveItem(child, versionManager, itemResource, templateFactory));
            }
        }
    }

    @Override
    public Collection<ConfigItem> getConfigItems() throws IOException {
        locateResourceRoot();
        return items;
    }

    public ConfigItemStatusManager getVersionManager() {
        return versionManager;
    }

    @Inject
    public void setVersionManager(ConfigItemStatusManager versionManager) {
        this.versionManager = versionManager;
    }

    public TemplateFactory getTemplateFactory() {
        return templateFactory;
    }

    @Inject
    public void setTemplateFactory(TemplateFactory templateFactory) {
        this.templateFactory = templateFactory;
    }

}