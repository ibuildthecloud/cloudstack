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
package org.apache.cloudstack.db.jooq.mapper;

import java.io.Serializable;

import javax.inject.Inject;

import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.RecordMapperProvider;
import org.jooq.RecordType;
import org.jooq.impl.DefaultRecordMapper;

import com.cloud.utils.db.CloudStackJooqMapper;
import com.cloud.utils.db.EntityManager;
import com.cloud.utils.db.GenericDaoBase;

public class CloudStackRecordMapperProvider implements RecordMapperProvider {

    @Inject
    EntityManager entityManager;

    @Override
    public <R extends Record, E> RecordMapper<R, E> provide(RecordType<R> recordType, Class<? extends E> type) {
        GenericDaoBase<E, Serializable> dao = (GenericDaoBase<E, Serializable>) GenericDaoBase.getDao(type);
        if ( dao == null ) {
            return new DefaultRecordMapper<R, E>(recordType, type);
        } else {
            return new CloudStackJooqMapper<R, E>(recordType, dao);
        }
    }

}
