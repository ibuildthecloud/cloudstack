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
package org.apache.cloudstack.systemvm.managment.dao.impl;

import static org.apache.cloudstack.db.jooq.tables.Cluster.*;
import static org.apache.cloudstack.db.jooq.tables.Host.*;
import static org.apache.cloudstack.db.jooq.tables.HostPodRef.*;
import static org.apache.cloudstack.db.jooq.tables.Networks.*;
import static org.apache.cloudstack.db.jooq.tables.Nics.*;
import static org.apache.cloudstack.db.jooq.tables.SystemVm.*;
import static org.apache.cloudstack.db.jooq.tables.VmInstance.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cloudstack.systemvm.managment.dao.SystemVmManagementDao;
import org.apache.cloudstack.systemvm.managment.model.SystemVmRole;
import org.apache.commons.lang3.ArrayUtils;

import com.cloud.vm.SystemVm;
import com.cloud.vm.SystemVmVO;
import com.cloud.vm.VirtualMachine;

public class SystemVmManagementDaoImpl extends AbstractJooqDao implements SystemVmManagementDao  {

    @Override
    public Map<Long, List<SystemVm>> getSystemVmForNetworkByRole(long networkId, SystemVmRole role) {

        List<SystemVmVO> vms = create()
                .select(ArrayUtils.addAll(VM_INSTANCE.fields(), SYSTEM_VM.fields()))
                    .from(VM_INSTANCE)
                .join(SYSTEM_VM)
                    .on(SYSTEM_VM.ID.eq(VM_INSTANCE.ID))
                .join(NICS)
                    .on(NICS.INSTANCE_ID.eq(VM_INSTANCE.ID))
                .join(NETWORKS)
                    .on(NETWORKS.ID.eq(NICS.NETWORK_ID))
                .where(NETWORKS.ID.eq(networkId)
                    .and(VM_INSTANCE.TYPE.eq(VirtualMachine.Type.SystemVm.toString()))
                    .and(SYSTEM_VM.ROLE.like("%" + role + "%"))
                    .and(VM_INSTANCE.REMOVED.isNull()))
                .fetchInto(SystemVmVO.class);

        Map<Long, List<SystemVm>> result = new HashMap<Long, List<SystemVm>>();

        for ( SystemVmVO vm : vms ) {
            Long podId = getPodIdForVirtualMachine(vm);
            if ( podId == null ) {
                podId = 0L;
            }

            List<SystemVm> list = result.get(podId);
            if ( list == null ) {
                list = new ArrayList<SystemVm>();
                result.put(podId, list);
            }

            list.add(vm);
        }

        return result;
    }

    protected Long getPodIdForVirtualMachine(VirtualMachine vm) {
        Long hostId = vm.getHostId();
        if ( hostId == null ) {
            hostId = vm.getLastHostId();
        }

        if ( hostId == null )
            return null;

       return create()
               .select()
                   .from(HOST_POD_REF)
               .join(CLUSTER)
                   .on(CLUSTER.POD_ID.eq(HOST_POD_REF.ID))
               .join(HOST)
                    .on(HOST.CLUSTER_ID.eq(CLUSTER.ID))
               .where(HOST.ID.eq(hostId))
               .fetchOne(HOST_POD_REF.ID);
    }

}
