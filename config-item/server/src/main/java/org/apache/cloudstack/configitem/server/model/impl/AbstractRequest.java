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

import java.util.Map;

import javax.inject.Inject;

import org.apache.cloudstack.configitem.model.Client;
import org.apache.cloudstack.configitem.model.ItemVersion;
import org.apache.cloudstack.configitem.server.model.Request;

public abstract class AbstractRequest implements Request {

    String itemName;
    int responseCode = Request.OK;
    Client client;
    ItemVersion appliedVersion;
    Map<String, String[]> params;

    public AbstractRequest() {
    }

    public AbstractRequest(String itemName, Client client, ItemVersion appliedVersion, Map<String,String[]> params) {
        this.itemName = itemName;
        this.client = client;
        this.appliedVersion = appliedVersion;
        this.params = params;
    }

    @Override
    public ItemVersion getAppliedVersion() {
        return appliedVersion;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setResponseCode(int code) {
        this.responseCode = code;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAppliedVersion(ItemVersion appliedVersion) {
        this.appliedVersion = appliedVersion;
    }

    public Map<String, String[]> getParams() {
        return params;
    }

    @Inject
    public void setParams(Map<String, String[]> params) {
        this.params = params;
    }

    @Override
    public void setContentType(String contentType) {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [itemName=" + itemName + ", client=" + client + ", appliedVersion=" + appliedVersion
                + ", params=" + params + "]";
    }

}
