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
package org.apache.cloudstack.configitem.version.dao.impl;

import static org.apache.cloudstack.db.jooq.generated.tables.ConfigItem.*;
import static org.apache.cloudstack.db.jooq.generated.tables.ConfigItemStatus.*;

import java.util.List;

import org.apache.cloudstack.configitem.model.Client;
import org.apache.cloudstack.configitem.model.ItemVersion;
import org.apache.cloudstack.configitem.version.dao.ConfigItemStatusDao;
import org.apache.cloudstack.db.jooq.generated.tables.records.ConfigItemRecord;
import org.apache.cloudstack.jooq.dao.impl.AbstractJooqDao;
import org.apache.commons.lang.ObjectUtils;
import org.jooq.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.host.Host;
import com.cloud.vm.VirtualMachine;

public class ConfigItemStatusDaoImpl extends AbstractJooqDao implements ConfigItemStatusDao {

    private static final Logger log = LoggerFactory.getLogger(ConfigItemStatusDaoImpl.class);

    @Override
    public boolean setApplied(Client client, String itemName, ItemVersion version) {
        int updated = update(CONFIG_ITEM_STATUS)
            .set(CONFIG_ITEM_STATUS.APPLIED_VERSION, version.getRevision())
            .set(CONFIG_ITEM_STATUS.SOURCE_VERSION, version.getSourceRevision())
            .where(
                    CONFIG_ITEM_STATUS.SOURCE_VERSION.eq(version.getSourceRevision()).or(CONFIG_ITEM_STATUS.SOURCE_VERSION.isNull())
                    .and(CONFIG_ITEM_STATUS.NAME.eq(itemName))
                    .and(targetObjectCondition(client))
            )
            .execute();

        if ( updated > 1 ) {
            log.error("Updated too many rows [{}] for client [{}] itemName [{}] itemVersion [{}]",
                    updated, client, itemName, version);
        }

        return updated == 1;
    }


    @Override
    public void setLatest(Client client, String itemName, String sourceRevision) {
        update(CONFIG_ITEM_STATUS)
                .set(CONFIG_ITEM_STATUS.APPLIED_VERSION, CONFIG_ITEM_STATUS.REQUESTED_VERSION)
                .set(CONFIG_ITEM_STATUS.SOURCE_VERSION, sourceRevision)
                .where(
                        CONFIG_ITEM_STATUS.NAME.eq(itemName)
                        .and(targetObjectCondition(client))
                )
                .execute();
    }

    protected Condition targetObjectCondition(Client client) {
        if ( VirtualMachine.class.isAssignableFrom(client.getResourceType()) ) {
            return CONFIG_ITEM_STATUS.VM_INSTANCE_ID.eq(client.getResourceId());
        } else if ( Host.class.isAssignableFrom(client.getResourceType()) ) {
            return CONFIG_ITEM_STATUS.HOST_ID.eq(client.getResourceId());
        }
        throw new IllegalStateException("Failed to map client [" + client + "] to a DB field");
    }


    @Override
    public void setItemSourceVersion(String name, String sourceRevision) {
        List<ConfigItemRecord> records = select().from(CONFIG_ITEM).
            where(CONFIG_ITEM.NAME.eq(name)).fetchInto(ConfigItemRecord.class);

        ConfigItemRecord first = null;
        for ( ConfigItemRecord record : records ) {
            record.attach(getConfiguration());
            if ( first == null ) {
                first = record;
                if ( ! ObjectUtils.equals(sourceRevision, record.getSourceVersion()) ) {
                    record.setSourceVersion(sourceRevision);
                    record.update();
                }
            } else {
                record.delete();
            }
        }

        if ( first == null ) {
            first = create().newRecord(CONFIG_ITEM);
            first.setName(name);
            first.setSourceVersion(sourceRevision);
            first.insert();
        }
    }

}
