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
package org.apache.cloudstack.configitem.server.impl;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.cloudstack.configitem.model.ItemVersion;
import org.apache.cloudstack.configitem.server.model.ConfigItem;
import org.apache.cloudstack.configitem.server.model.Request;
import org.apache.cloudstack.configitem.server.service.ConfigItemServer;
import org.apache.cloudstack.configitem.version.ConfigItemVersionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigItemServerImpl extends AbstractRegistryConfigItemServer implements ConfigItemServer {

    private static final Logger log = LoggerFactory.getLogger(ConfigItemServerImpl.class);

    ConfigItemVersionManager versionManager;

    @Override
    public void handleRequest(Request req) throws IOException {
        ItemVersion version = req.getAppliedVersion();

        if (version == null) {
            handleDownload(req);
        } else {
            handleApplied(req);
        }
    }

    protected void handleApplied(Request req) {
        ItemVersion version = req.getAppliedVersion();

        if (version.isLatest()) {
            ConfigItem item = getConfigItem(req.getItemName());
            if (item == null) {
                req.setResponseCode(Request.NOT_FOUND);
                return;
            }
            log.info("Setting item [{}] to latest for [{}]", req.getItemName(), req.getClient());
            versionManager.setLatest(req.getClient(), req.getItemName(), item.getSourceRevision());
        } else {
            log.info("Setting item [{}] to version [{}] for [{}]", req.getItemName(), req.getAppliedVersion(),
                    req.getClient());
            versionManager.setApplied(req.getClient(), req.getItemName(), req.getAppliedVersion());
        }
    }

    protected void handleDownload(Request req) throws IOException {
        ConfigItem item = getConfigItem(req.getItemName());

        if (item == null) {
            log.info("Client [{}] requested unknown item [{}]", req.getClient(), req.getItemName());
            req.setResponseCode(Request.NOT_FOUND);
            return;
        }

        log.info("Processing [{}] for client [{}]", req.getItemName(), req.getClient());
        item.handleRequest(req);
    }

    public ConfigItemVersionManager getVersionManager() {
        return versionManager;
    }

    @Inject
    public void setVersionManager(ConfigItemVersionManager versionManager) {
        this.versionManager = versionManager;
    }
}
