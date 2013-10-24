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
package org.apache.cloudstack.lock.definition;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractMultiLockDefinition implements MultiLockDefinition {

    LockDefinition[] lockDefinitions;
    String[] ids;

    public AbstractMultiLockDefinition(LockDefinition... lockDefinitions) {
        super();
        this.lockDefinitions = lockDefinitions;
        this.ids = new String[lockDefinitions.length];
        for ( int i = 0 ; i < lockDefinitions.length ; i++ ) {
            this.ids[i] = lockDefinitions[i].getLockId();
        }
    }

    public AbstractMultiLockDefinition(String... ids) {
        this(getLockDefinitions(ids));
    }

    @Override
    public String getLockId() {
        return StringUtils.join(ids, ",");
    }

    @Override
    public LockDefinition[] getLockDefinitions() {
        return lockDefinitions;
    }

    private static final LockDefinition[] getLockDefinitions(String... ids) {
        LockDefinition[] result = new LockDefinition[ids.length];
        for ( int i = 0 ; i < ids.length ; i++ ) {
            result[i] = new AbstractLockDefinition.DefaultLockDefinition(ids[i]);
        }

        return result;
    }
    
    protected static class DefaultMultiLockDefinition extends AbstractMultiLockDefinition {
        public DefaultMultiLockDefinition(LockDefinition... lockDefinitions) {
            super(lockDefinitions);
        }

        public DefaultMultiLockDefinition(String... ids) {
            super(ids);
        }
    }
}
