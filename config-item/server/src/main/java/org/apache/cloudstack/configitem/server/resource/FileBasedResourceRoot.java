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

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class FileBasedResourceRoot extends AbstractCachingResourceRoot implements ResourceRoot {

    File base;
    boolean useCache;

    public FileBasedResourceRoot(File base, boolean useCache) {
        super();
        this.base = base;
        this.useCache = useCache;
    }

    @Override
    public synchronized Collection<Resource> getResources() throws IOException {
        if ( ! useCache ) {
            scan();
        }
        return super.getResources();
    }

    @Override
    protected Collection<Resource> scanResources() throws IOException {
        Map<String, Resource> result = new TreeMap<String, Resource>();
        scan("", base, result);
        return result.values();
    }

    protected void scan(String path, File current, Map<String, Resource> result) {
        String[] children = current.list();
        if ( children == null )
            return;

        for ( String child : children ) {
            if ( child.startsWith(".") )
                continue;

            File childFile = new File(current,child);
            String childName = new File(path, child).getPath();

            if ( childFile.isDirectory() ) {
                scan(childName, childFile, result);
            } else {
                result.put(childName, new FileResource(childName, childFile));
            }
        }
    }
}
