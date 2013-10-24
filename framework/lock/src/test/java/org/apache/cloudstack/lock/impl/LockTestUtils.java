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
import org.apache.cloudstack.lock.exception.FailedToAcquireLockException;
import org.mockito.Mockito;

public class LockTestUtils {

    public static Lock goodLock(LockDefinition def) {
        return getLock(true, def);
    }
    
    public static Lock badLock(LockDefinition def) {
        return getLock(false, def);
    }
    
    public static Lock getLock(boolean good, LockDefinition def) {
        Lock lock = Mockito.mock(Lock.class);

        if ( def != null ) {
            Mockito.when(lock.getLockDefinition()).thenReturn(def);
        }

        Mockito.when(lock.tryLock()).thenReturn(good);
        if ( ! good ) {
            Mockito.doThrow(new FailedToAcquireLockException(def)).when(lock).lock();
        }


        return lock;
    }
}
