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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.cloudstack.lock.Lock;
import org.apache.cloudstack.lock.LockCallback;
import org.apache.cloudstack.lock.LockCallbackNoReturn;
import org.apache.cloudstack.lock.LockCallbackWithException;
import org.apache.cloudstack.lock.definition.LockDefinition;
import org.apache.cloudstack.lock.definition.MultiLockDefinition;
import org.apache.cloudstack.lock.exception.FailedToAcquireLockException;
import org.apache.cloudstack.lock.provider.LockProvider;
import org.junit.Before;
import org.junit.Test;

public class LockManagerImplTest {

    LockProvider lockProvider;
    LockManagerImpl lockManager;
    LockDefinition goodLockDef = new TestLockDefinition("good");
    LockDefinition good2LockDef = new TestLockDefinition("good2");
    LockDefinition badLockDef = new TestLockDefinition("bad");

    Lock goodLock = LockTestUtils.goodLock(goodLockDef);
    Lock good2Lock = LockTestUtils.goodLock(good2LockDef);
    Lock badLock = LockTestUtils.badLock(badLockDef);

    @Before
    public void setUp() {
        lockProvider = mock(LockProvider.class);
        when(lockProvider.getLock(goodLockDef)).thenReturn(goodLock);
        when(lockProvider.getLock(good2LockDef)).thenReturn(good2Lock);
        when(lockProvider.getLock(badLockDef)).thenReturn(badLock);

        lockManager = new LockManagerImpl();
        lockManager.setLockProviders(Arrays.asList(lockProvider));
        lockManager.start();

        verify(lockProvider, times(1)).activate();
    }
    
    @Test
    public void test_bad_multilock() {
        MultiLockDefinition def = new TestMultiLockDefinition(goodLockDef, badLockDef, good2LockDef);

        try {
            lockManager.lock(def, new LockCallbackNoReturn() {
                @Override
                public void doWithLockNoResult() {
                    fail();
                }
            });
        } catch ( FailedToAcquireLockException e ) {
            assertEquals(badLockDef, e.getLockDefition());
        }

        verify(goodLock, times(1)).lock();
        verify(badLock, times(1)).lock();
        verify(good2Lock, times(0)).lock();

        verify(goodLock, times(1)).unlock();
        verify(badLock, times(1)).unlock();
        verify(good2Lock, times(1)).unlock();

        verify(lockProvider, times(1)).getLock(goodLockDef);
        verify(lockProvider, times(1)).getLock(badLockDef);
        verify(lockProvider, times(1)).getLock(good2LockDef);

        verify(lockProvider, times(1)).releaseLock(goodLock);
        verify(lockProvider, times(1)).releaseLock(badLock);
        verify(lockProvider, times(1)).releaseLock(good2Lock);
    }

    @Test
    public void test_good_multilock() {
        MultiLockDefinition def = new TestMultiLockDefinition(goodLockDef, goodLockDef, good2LockDef);

        final AtomicInteger i = new AtomicInteger();
        lockManager.lock(def, new LockCallbackNoReturn() {
            @Override
            public void doWithLockNoResult() {
                i.incrementAndGet();
            }
        });

        assertEquals(1, i.intValue());

        verify(goodLock, times(2)).lock();
        verify(good2Lock, times(1)).lock();

        verify(goodLock, times(2)).unlock();
        verify(good2Lock, times(1)).unlock();

        verify(lockProvider, times(2)).getLock(goodLockDef);
        verify(lockProvider, times(1)).getLock(good2LockDef);

        verify(lockProvider, times(2)).releaseLock(goodLock);
        verify(lockProvider, times(1)).releaseLock(good2Lock);
    }
    
    @Test
    public void test_exceptions() {
        try {
            lockManager.lock(goodLockDef, new LockCallbackNoReturn() {
                @Override
                public void doWithLockNoResult() {
                    throw new RuntimeException("42");
                }
            });
        } catch ( RuntimeException e ) {
            assertEquals("42", e.getMessage());
        }

        verify(goodLock, times(1)).lock();
        verify(goodLock, times(1)).unlock();
        verify(lockProvider, times(1)).getLock(goodLockDef);
        verify(lockProvider, times(1)).releaseLock(goodLock);
    }

    @Test
    public void test_checked_exceptions() {
        try {
            lockManager.lock(goodLockDef, new LockCallbackWithException<Object, FileNotFoundException>() {
                @Override
                public Object doWithLock() throws FileNotFoundException {
                    throw new FileNotFoundException("42");
                }
            }, FileNotFoundException.class);
        } catch ( FileNotFoundException e ) {
            assertEquals("42", e.getMessage());
        }

        verify(goodLock, times(1)).lock();
        verify(goodLock, times(1)).unlock();
        verify(lockProvider, times(1)).getLock(goodLockDef);
        verify(lockProvider, times(1)).releaseLock(goodLock);
    }
    
    @Test
    public void test_return() {
        assertEquals(new Long(42), lockManager.lock(goodLockDef, new LockCallback<Long>() {
            @Override
            public Long doWithLock() {
                return 42L;
            }
        }));

        verify(goodLock, times(1)).lock();
        verify(goodLock, times(1)).unlock();
        verify(lockProvider, times(1)).getLock(goodLockDef);
        verify(lockProvider, times(1)).releaseLock(goodLock);
    }

}
