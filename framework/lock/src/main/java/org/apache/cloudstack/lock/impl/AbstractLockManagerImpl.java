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
import org.apache.cloudstack.lock.LockCallback;
import org.apache.cloudstack.lock.LockCallbackWithException;
import org.apache.cloudstack.lock.LockManager;
import org.apache.cloudstack.lock.definition.LockDefinition;

import com.cloud.utils.component.ComponentLifecycleBase;

public abstract class AbstractLockManagerImpl extends ComponentLifecycleBase implements LockManager {

    @Override
    public <T,E extends Throwable> T lock(LockDefinition lockDef, LockCallbackWithException<T,E> callback, Class<E> clz) throws E {
        return doLock(lockDef, callback, new WithLock() {
            @Override
            public boolean withLock(Lock lock) {
                lock.lock();
                return true;
            }
        });
    }

    @Override
    public <T,E extends Throwable> T tryLock(LockDefinition lockDef, LockCallbackWithException<T,E> callback, Class<E> clz) throws E {
        return doLock(lockDef, callback, new WithLock() {
            @Override
            public boolean withLock(Lock lock) {
                return lock.tryLock();
            }
        });
    }

    @Override
    public <T> T lock(LockDefinition lockDef, final LockCallback<T> callback) {
        return lock(lockDef, new LockCallbackWithException<T, RuntimeException>() {
            @Override
            public T doWithLock() throws RuntimeException {
                return callback.doWithLock();
            }
        }, RuntimeException.class);
    }

    @Override
    public <T> T tryLock(LockDefinition lockDef, final LockCallback<T> callback) {
        return tryLock(lockDef, new LockCallbackWithException<T, RuntimeException>() {
            @Override
            public T doWithLock() throws RuntimeException {
                return callback.doWithLock();
            }
        }, RuntimeException.class);
    }

    protected abstract <T,E extends Throwable> T doLock(LockDefinition lockDef, 
            LockCallbackWithException<T,E> callback, WithLock with) throws E;

    protected static interface WithLock {
        boolean withLock(Lock lock);
    }

}
