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
package org.apache.cloudstack.configitem.model;

import org.apache.cloudstack.configitem.model.ItemVersion;

public class DefaultItemVersion implements ItemVersion {

    public static final String LATEST = "latest";

    long revision;
    String sourceRevision;
    boolean latest;

    @Override
    public long getRevision() {
        return revision;
    }

    public void setRevision(long revision) {
        this.revision = revision;
    }

    @Override
    public boolean isLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    @Override
    public String getSourceRevision() {
        return sourceRevision;
    }

    public void setSourceRevision(String sourceRevision) {
        this.sourceRevision = sourceRevision;
    }

    public static DefaultItemVersion fromString(String str) {
        DefaultItemVersion result = new DefaultItemVersion();

        if ( str == null )
            return null;

        if (LATEST.equals(str)) {
            result.setLatest(true);
            return result;
        }

        String[] parts = str.split("-");

        if ( parts.length != 2 )
            return null;

        try {
            long version = Long.parseLong(parts[0]);
            result.setRevision(version);
            result.setSourceRevision(parts[1]);
            return result;
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

}
