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

import org.apache.cloudstack.lock.Lock;
import org.apache.cloudstack.lock.exception.FailedToAcquireLockException;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MultiLockTest {

    @Test
    public void test_good_lock() {
        Lock good = LockTestUtils.goodLock(null);
        Lock good2 = LockTestUtils.goodLock(null);

        MultiLock multiLock = new MultiLock(null, good, good2);
        multiLock.lock();

        verify(good, times(0)).tryLock();
        verify(good, times(1)).lock();
        verify(good2, times(0)).tryLock();
        verify(good2, times(1)).lock();
    }
    
    @Test
    public void test_good_tryLock() {
        Lock good = LockTestUtils.goodLock(null);
        Lock good2 = LockTestUtils.goodLock(null);

        MultiLock multiLock = new MultiLock(null, good, good2);
        multiLock.tryLock();

        verify(good, times(1)).tryLock();
        verify(good, times(0)).lock();
        verify(good2, times(1)).tryLock();
        verify(good2, times(0)).lock();
    }

    @Test
    public void test_good_unlock() {
        Lock good = LockTestUtils.goodLock(null);
        Lock good2 = LockTestUtils.goodLock(null);

        MultiLock multiLock = new MultiLock(null, good, good2);
        multiLock.unlock();

        verify(good, times(1)).unlock();
        verify(good2, times(1)).unlock();
    }

    @Test
    public void test_bad_lock() {
        Lock good = LockTestUtils.goodLock(null);
        Lock bad = LockTestUtils.badLock(null);
        Lock good2 = LockTestUtils.goodLock(null);

        try {
            MultiLock multiLock = new MultiLock(null, good, bad, good2);
            multiLock.lock();
            fail();
        } catch ( FailedToAcquireLockException e ) {
        }

        verify(good, times(1)).lock();
        verify(bad, times(1)).lock();
        verify(good2, times(0)).lock();
    }
    
    @Test
    public void test_bad_trylock() {
        Lock good = LockTestUtils.goodLock(null);
        Lock bad = LockTestUtils.badLock(null);
        Lock good2 = LockTestUtils.goodLock(null);

        MultiLock multiLock = new MultiLock(null, good, bad, good2);
        assertTrue(!multiLock.tryLock());

        verify(good, times(1)).tryLock();
        verify(bad, times(1)).tryLock();
        verify(good2, times(0)).tryLock();
    }

}
