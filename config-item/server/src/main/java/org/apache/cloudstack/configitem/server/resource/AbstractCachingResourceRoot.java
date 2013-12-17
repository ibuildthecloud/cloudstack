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
package org.apache.cloudstack.configitem.server.resource;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;

public abstract class AbstractCachingResourceRoot implements ResourceRoot {

    Collection<Resource> resources;
    String sourceRevision;
    byte[] additionalRevisionData;

    @Override
    public Collection<Resource> getResources() throws IOException {
        return resources;
    }

    @Override
    public synchronized final void scan() throws IOException {
        Collection<Resource> resources = scanResources();
        DigestOutputStream outputStream = null;
        String revision = null;
        try {
            outputStream = new DigestOutputStream(new NullOutputStream(), MessageDigest.getInstance("SHA-256"));

            if ( additionalRevisionData != null )
                outputStream.write(additionalRevisionData);

            for ( Resource resource : resources ) {
                InputStream is = null;
                try {
                    is = resource.getInputStream();
                    IOUtils.copy(is, outputStream);
                } finally {
                    IOUtils.closeQuietly(is);
                }
            }

            outputStream.close();
            revision = Hex.encodeHexString(outputStream.getMessageDigest().digest());
            outputStream = null;
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }

        this.resources = resources;
        this.sourceRevision = revision;
    }

    protected abstract Collection<Resource> scanResources() throws IOException;

    @Override
    public String getSourceRevision() {
        return sourceRevision;
    }

    public byte[] getAdditionalRevisionData() {
        return additionalRevisionData;
    }

    public void setAdditionalRevisionData(byte[] additionalRevisionData) {
        this.additionalRevisionData = additionalRevisionData;
    }

}
