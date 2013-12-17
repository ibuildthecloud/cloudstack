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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.cloudstack.configitem.server.model.Request;
import org.apache.cloudstack.configitem.server.resource.ResourceRoot;
import org.apache.cloudstack.configitem.version.ConfigItemStatusManager;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;

public abstract class AbstractArchiveBasedConfigItem extends AbstractResourceRootConfigItem {

    public AbstractArchiveBasedConfigItem(String name, ConfigItemStatusManager versionManager, ResourceRoot resourceRoot) {
        super(name, versionManager, resourceRoot);
    }

    @Override
    public void handleRequest(Request req) throws IOException {
        req.setContentType("application/octet-stream");

        OutputStream os = req.getOutputStream();
        GZIPOutputStream gzos = new GZIPOutputStream(os);
        TarArchiveOutputStream taos = null;
        
        try {
            taos = new TarArchiveOutputStream(gzos);
            taos.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);

            writeContent(new ArchiveContext(req, taos, getVersion(req)));
        } finally {
            IOUtils.closeQuietly(taos);
        }
    }

    protected void writeContent(final ArchiveContext context) throws IOException {
        final byte[] content = (context.getVersion() + "\n").getBytes("UTF-8"); 
        withEntry(context, "version", content.length, new WithEntry() {
            @Override
            public void with(OutputStream os) throws IOException {
                os.write(content);
            }
        });
    }

    protected void withEntry(ArchiveContext context, String entryName, long size, WithEntry with) throws IOException {
        if ( size < 0 ) {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            with.with(baos);
            size = baos.size();
            with = new WithEntry() {
                @Override
                public void with(OutputStream os) throws IOException {
                    os.write(baos.toByteArray());
                }
            }; 
        }

        withEntry(context, getDefaultEntry(context, entryName, size), with);
    };

    protected void withEntry(ArchiveContext context, TarArchiveEntry entry, WithEntry with) throws IOException {
        TarArchiveOutputStream taos = context.getOutputStream();
        taos.putArchiveEntry(entry);
        with.with(taos);
        taos.closeArchiveEntry();
    };
    
    protected TarArchiveEntry getDefaultEntry(ArchiveContext context, String name, long size) {
        StringBuilder entryName = new StringBuilder(context.getRequest().getItemName());
        entryName.append("-").append(context.getVersion());
        if ( ! name.startsWith(File.separator) ) {
            entryName.append(File.separator);
        }
        entryName.append(name);

        TarArchiveEntry entry = new TarArchiveEntry(entryName.toString());
        entry.setUserName("root");
        entry.setGroupName("root");
        entry.setMode(0644);
        entry.setSize(size);
        return entry;
    }

    protected interface WithEntry {
        public void with(OutputStream os) throws IOException;
    }
}
