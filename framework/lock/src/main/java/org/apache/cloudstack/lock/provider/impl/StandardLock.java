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
package org.apache.cloudstack.lock.provider.impl;

import java.util.concurrent.TimeUnit;

import org.apache.cloudstack.lock.Lock;
import org.apache.cloudstack.lock.definition.BlockingLockDefinition;
import org.apache.cloudstack.lock.definition.LockDefinition;
import org.apache.cloudstack.lock.exception.FailedToAcquireLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardLock implements Lock {

    private static final Logger log = LoggerFactory.getLogger(StandardLock.class);

    LockDefinition lockDefinition;
    java.util.concurrent.locks.Lock lock;
    long timeout;
    long referenceCount = 0;

    public StandardLock(LockDefinition lockDefinition, java.util.concurrent.locks.Lock lock) {
        super();
        this.lockDefinition = lockDefinition;
        this.lock = lock;
        if ( lockDefinition instanceof BlockingLockDefinition ) {
            this.timeout = ((BlockingLockDefinition)lockDefinition).getWait();
        }
    }


    @Override
    public boolean tryLock() {
        return lock.tryLock();
    }

    @Override
    public void lock() throws FailedToAcquireLockException {
        try {
            if ( ! lock.tryLock(timeout, TimeUnit.MILLISECONDS) )
                throw new FailedToAcquireLockException(lockDefinition);
        } catch (InterruptedException e) {
            log.error("Failed to lock [{}], interrupted", lockDefinition, e);
            throw new FailedToAcquireLockException(lockDefinition);
        }
    }

    @Override
    public void unlock() {
        try {
            lock.unlock();
        } catch ( Throwable t ) {
            log.warn("Failed to unlock [{}]", lockDefinition, t);
        }
    }

    @Override
    public LockDefinition getLockDefinition() {
        return lockDefinition;
    }

    public long getReference() {
        return referenceCount;
    }
    
    public long incrementReference() {
        return ++referenceCount;
    }
    
    public long decrementReference() {
        return --referenceCount;
    }
}
