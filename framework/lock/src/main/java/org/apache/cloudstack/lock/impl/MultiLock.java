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
package org.apache.cloudstack.lock.impl;

import org.apache.cloudstack.lock.Lock;
import org.apache.cloudstack.lock.definition.LockDefinition;
import org.apache.cloudstack.lock.definition.MultiLockDefinition;
import org.apache.cloudstack.lock.exception.FailedToAcquireLockException;
import org.apache.cloudstack.lock.provider.LockProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiLock implements Lock {

    private static final Logger log = LoggerFactory.getLogger(MultiLock.class);
    
    Lock[] locks;
    MultiLockDefinition definition;

    public MultiLock(MultiLockDefinition def, Lock... locks) {
        this.locks = locks;
        this.definition = def;
    }
    
    public MultiLock(MultiLockDefinition def, LockProvider provider) {
        this.definition = def;

        LockDefinition[] defs = def.getLockDefinitions();
        locks = new Lock[defs.length];

        for ( int i = 0 ; i < defs.length ; i++ ) {
            locks[i] = provider.getLock(defs[i]);
        }
    }

    public Lock[] getLocks() {
        return locks;
    }

    @Override
    public boolean tryLock() {
        for ( Lock lock : locks ) {
            if ( ! lock.tryLock() )
                return false;
        }
        return true;
    }

    @Override
    public void lock() throws FailedToAcquireLockException {
        for ( Lock lock : locks ) {
            lock.lock();
        }
    }

    @Override
    public void unlock() {
        for ( Lock lock : locks ) {
            try {
                lock.unlock();
            } catch ( Throwable t ) {
                /* This is never supposed to happen, but hey sometime people don't program the right thing */
                log.error("Failed to unlock [{}], unlock() should never throw an exception", lock.getLockDefinition().getLockId(), t);
            }
        }
    }

    @Override
    public LockDefinition getLockDefinition() {
        return definition;
    }

}