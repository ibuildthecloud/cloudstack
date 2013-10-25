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

import java.util.List;

import javax.inject.Inject;

import org.apache.cloudstack.lock.Lock;
import org.apache.cloudstack.lock.LockCallbackWithException;
import org.apache.cloudstack.lock.LockManager;
import org.apache.cloudstack.lock.definition.LockDefinition;
import org.apache.cloudstack.lock.definition.MultiLockDefinition;
import org.apache.cloudstack.lock.provider.LockProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LockManagerImpl extends AbstractLockManagerImpl implements LockManager {

    private static final Logger log = LoggerFactory.getLogger(LockManagerImpl.class);

    List<LockProvider> lockProviders;
    LockProvider lockProvider;

    @Override
    protected <T, E extends Throwable> T doLock(LockDefinition lockDef, LockCallbackWithException<T, E> callback,
            WithLock with) throws E {
        Lock lock = null;
        try {
            lock = getLock(lockDef);

            /* Important to lock in the try because the Lock may be a multi-lock
             * and if a multi-lock fails to lock it can be in a half locked state
             * so it must be unlocked
             */
            if ( ! with.withLock(lock) )
                return null;

            return callback.doWithLock();
        } finally {
            if ( lock != null ) {
                try {
                    lock.unlock();
                } catch (Throwable t) {
                    /* Should never happen, but I don't trust people */
                    log.error("Failed to unlock [{}], unlock() should never throw an exception", lock.getLockDefinition(), t); 
                }
                releaseLock(lock);
            }
        }
    }

    protected void releaseLock(Lock lock) {
        if ( lock instanceof MultiLock ) {
            for ( Lock lockPart : ((MultiLock)lock).getLocks() ) {
                try {
                    lockProvider.releaseLock(lockPart);
                } catch ( Throwable t ) {
                    /* Should never happen, but I don't trust people */
                    log.error("Failed to release lock [{}], releaseLock() should never throw an exception", lockPart.getLockDefinition(), t); 
                }
            }
        } else {
            lockProvider.releaseLock(lock);
        }
    }

    protected Lock getLock(LockDefinition def) {
        if ( def instanceof MultiLockDefinition ) {
            return new MultiLock((MultiLockDefinition)def, lockProvider);
        } else {
            return lockProvider.getLock(def);
        }
    }

    @Override
    public LockProvider getLockProvider() {
        return lockProvider;
    }

    @Override
    public boolean start() {
        if ( lockProviders.size() == 0 )
            throw new IllegalStateException("Failed to find lock provider");

        lockProvider = lockProviders.get(0);
        lockProvider.activate();

        return super.start();
    }

    public List<LockProvider> getLockProviders() {
        return lockProviders;
    }

    @Inject
    public void setLockProviders(List<LockProvider> lockProviders) {
        this.lockProviders = lockProviders;
    }

}
