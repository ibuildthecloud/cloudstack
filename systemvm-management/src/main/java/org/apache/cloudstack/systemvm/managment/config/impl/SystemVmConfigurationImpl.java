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
package org.apache.cloudstack.systemvm.managment.config.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import org.apache.cloudstack.engine.orchestration.service.NetworkOrchestrationService;
import org.apache.cloudstack.framework.config.ConfigDepot;
import org.apache.cloudstack.systemvm.managment.config.SystemVmConfiguration;
import org.apache.cloudstack.systemvm.managment.model.SystemVmDefinition;
import org.apache.cloudstack.systemvm.managment.model.SystemVmNetworkAssociation;
import org.apache.cloudstack.systemvm.managment.model.SystemVmRole;
import org.apache.cloudstack.systemvm.managment.service.GlobalSettings;
import org.apache.cloudstack.systemvm.managment.service.impl.HypervisorSystemVmTemplateLookup;
import org.apache.commons.lang3.StringUtils;

import com.cloud.dc.Pod;
import com.cloud.deploy.DataCenterDeployment;
import com.cloud.deploy.DeploymentPlan;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.network.Network;
import com.cloud.network.NetworkModel;
import com.cloud.network.Networks.TrafficType;
import com.cloud.network.vpc.VpcOffering;
import com.cloud.offering.NetworkOffering;
import com.cloud.offering.ServiceOffering;
import com.cloud.resource.ResourceManager;
import com.cloud.service.dao.ServiceOfferingDao;
import com.cloud.template.VirtualMachineTemplate;
import com.cloud.user.Account;
import com.cloud.user.AccountManager;
import com.cloud.utils.db.EntityManager;
import com.cloud.vm.NicProfile;
import com.cloud.vm.SystemVm;
import com.cloud.vm.VirtualMachine;
import com.cloud.vm.VirtualMachineName;
import com.cloud.vm.dao.DomainRouterDao;

import static org.apache.cloudstack.systemvm.managment.model.SystemVmRole.*;

public class SystemVmConfigurationImpl implements SystemVmConfiguration {

    private static final Map<SystemVmRole, String> ROLE_TO_SERVICE_OFFERING = new HashMap<SystemVmRole, String>();
    private static final String SERVICE_OFFERING_UNIQUE_NAME = "CloudStack-%s";
    
    static {
        ROLE_TO_SERVICE_OFFERING.put(VirtualRouter, ServiceOffering.routerDefaultOffUniqueName);
        ROLE_TO_SERVICE_OFFERING.put(ConsoleProxy, ServiceOffering.consoleProxyDefaultOffUniqueName);
        ROLE_TO_SERVICE_OFFERING.put(SecondaryStorage, ServiceOffering.routerDefaultOffUniqueName);
        ROLE_TO_SERVICE_OFFERING.put(ElasticLbVm, ServiceOffering.routerDefaultOffUniqueName);
        ROLE_TO_SERVICE_OFFERING.put(InternalLbVm, ServiceOffering.routerDefaultOffUniqueName);
    }


    HypervisorSystemVmTemplateLookup templateLookup;
    ResourceManager resourceManager;
    EntityManager entityManager;
    ServiceOfferingDao serviceOfferingDao;
    DomainRouterDao domainRouterDao;
    ConfigDepot configDepot;
    NetworkModel networkModel;
    NetworkOrchestrationService networkService;
    AccountManager accountManager;


    @Override
    public List<HypervisorType> getSupportedHypervisors(long zoneId, Long podId) {
        List<HypervisorType> hypervisors = new ArrayList<HypervisorType>();

        HypervisorType defaultHvType = resourceManager.getDefaultHypervisor(zoneId);

        if (defaultHvType != HypervisorType.None) {
            hypervisors.add(defaultHvType);
        }

        for ( HypervisorType type : resourceManager.getSupportedHypervisorTypes(zoneId, true, podId) ) {
            if ( type != defaultHvType )
                hypervisors.add(type);
        }
        return hypervisors;
    }

    @Override
    public VirtualMachineTemplate getVirtualMachineTemplate(HypervisorType type, long zoneId) {
        return templateLookup.getVirtualMachineTemplate(type, zoneId);
    }

    @Override
    public VirtualMachine getSystemVmVO(SystemVmDefinition def) {
        VirtualMachine vm = null;

        if ( def.getSystemVmId() != null ) {
            //TODO: including removed?  ....ugh
            vm = entityManager.findById(SystemVm.class, def.getSystemVmId());
        }

        return vm;
    }

    protected Network getGuestNetwork(SystemVmDefinition def) {
        for ( long networkId : def.getSystemVmNetworkAssociation().keySet() ) {
            Network network = entityManager.findById(Network.class, networkId);

            if ( network == null ) {
                continue;
            }

            if ( network.getTrafficType() == TrafficType.Guest ) {
                return network;
            }
        }

        return null;
    }

    @Override
    public ServiceOffering getServiceOffering(SystemVmDefinition def) {

        ServiceOffering serviceOffering = null;

        Network network = getGuestNetwork(def);
        if ( network != null ) {
            Long serviceOfferingId = null;
            Long vpcId = network.getVpcId();

            if ( vpcId != null ) {
                VpcOffering offering = entityManager.findById(VpcOffering.class, vpcId);
                serviceOfferingId = offering == null ? null : offering.getServiceOfferingId();
            }

            if ( serviceOfferingId == null ) {
                NetworkOffering offering = entityManager.findById(NetworkOffering.class, network.getNetworkOfferingId());
                serviceOfferingId = offering == null ? null : offering.getServiceOfferingId();
            }

            if ( serviceOfferingId != null ) {
                serviceOffering = entityManager.findById(ServiceOffering.class, serviceOfferingId);
            }
        }

        if ( serviceOffering == null ) {
            String combinedRole = StringUtils.join(new TreeSet<SystemVmRole>(def.getRoles()), "/");

            serviceOffering = getServiceOffering(serviceOffering, combinedRole, true);
            for ( SystemVmRole role : def.getRoles() ) {
                serviceOffering = getServiceOffering(serviceOffering, role.getName(), true);
                serviceOffering = getServiceOffering(serviceOffering, ROLE_TO_SERVICE_OFFERING.get(role), false);
            }
        }

        if ( serviceOffering == null ) {
            throw new IllegalStateException("Failed to find service offering for system vm [" + def + "]");
        }

        return serviceOffering;
    }

    protected ServiceOffering getServiceOffering(ServiceOffering existing, String role, boolean format) {
        if ( existing != null || role == null )
            return existing;

        return serviceOfferingDao.findByName(format ? String.format(SERVICE_OFFERING_UNIQUE_NAME, role) : role);
    }

    @Override
    public long getNextId() {
        return domainRouterDao.getNextInSequence(Long.class, "id");
    }

    @Override
    public String getVmInstanceName(SystemVmDefinition def, long id) {
        String suffix = GlobalSettings.getString("instance.name");

        Set<String> sorted = new TreeSet<String>();

        for ( SystemVmRole role : def.getRoles() ) {
            sorted.add(role.getShortName());
        }

        String prefix = StringUtils.join(sorted, "");

        return VirtualMachineName.getSystemVmName(id, suffix, prefix);
    }
    
    @Override
    public Account getOwner(SystemVmDefinition def) {
        Network guestNetwork = getGuestNetwork(def);

        if ( guestNetwork == null ) {
            throw new IllegalStateException("Can not get the owner of a system vm that is not associated to"
                    + " a guest network");
        }

        long accountId = guestNetwork.getAccountId();
        
        if ( networkModel.isNetworkSystem(guestNetwork) || guestNetwork.getGuestType() == Network.GuestType.Shared) {
            accountId = Account.ACCOUNT_ID_SYSTEM;
        }

        return entityManager.findById(Account.class, accountId);
    }
    
    @Override
    public String getRoleString(SystemVmDefinition def) {
        Set<String> roles = new TreeSet<String>();
        
        for ( SystemVmRole role : def.getRoles() ) {
            roles.add(role.getName());
        }
        
        return StringUtils.join(roles,"|");
    }
    
    @Override
    public DeploymentPlan getDeploymentPlan(SystemVmDefinition def) {
        Pod pod = def.getPod();
        if ( pod == null ) {
            return new DataCenterDeployment(def.getZone().getId());
        } else {
            return new DataCenterDeployment(def.getZone().getId(), pod.getId(), null, null, null, null);
        }
    }

    @Override
    public LinkedHashMap<Network, NicProfile> getNicProfiles(SystemVmDefinition def) {
        LinkedHashMap<Network, NicProfile> result = new LinkedHashMap<Network, NicProfile>();
        for ( Map.Entry<Long,SystemVmNetworkAssociation> entry : def.getSystemVmNetworkAssociation().entrySet() ) {
            long networkId = entry.getKey();
            SystemVmNetworkAssociation association = entry.getValue();

            NicProfile nicProfile = new NicProfile();
            nicProfile.setDefaultNic(association.isDefault());

            Network network = entityManager.findById(Network.class, networkId);
            if ( network == null )
                throw new IllegalStateException("Failed to find a network for [" + networkId + "]");

            /* I don't particularly like this, ControlGuru should accept a NicProfile and validate that
             * its blank
             */
            if ( network.getTrafficType() == TrafficType.Control ) {
                result.put(network, null);
            } else {
                result.put(network, nicProfile);
            }
        }

        return result;
    }

    @Override
    public Network getControlNetwork(SystemVmDefinition def) {
        List<? extends NetworkOffering> offerings = networkModel.getSystemAccountNetworkOfferings(NetworkOffering.SystemControlNetwork);
        if ( offerings.size() == 0 )
            throw new IllegalStateException("Failed to find network offering for [" + NetworkOffering.SystemControlNetwork + "]");
        NetworkOffering controlOffering = offerings.get(0);

        return networkService.setupNetwork(accountManager.getSystemAccount(), controlOffering, 
                getDeploymentPlan(def), null, null, false).get(0);
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    @Inject
    public void setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    public HypervisorSystemVmTemplateLookup getTemplateLookup() {
        return templateLookup;
    }

    @Inject
    public void setTemplateLookup(HypervisorSystemVmTemplateLookup templateLookup) {
        this.templateLookup = templateLookup;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ServiceOfferingDao getServiceOfferingDao() {
        return serviceOfferingDao;
    }

    @Inject
    public void setServiceOfferingDao(ServiceOfferingDao serviceOfferingDao) {
        this.serviceOfferingDao = serviceOfferingDao;
    }

    public DomainRouterDao getDomainRouterDao() {
        return domainRouterDao;
    }

    @Inject
    public void setDomainRouterDao(DomainRouterDao domainRouterDao) {
        this.domainRouterDao = domainRouterDao;
    }

    public ConfigDepot getConfigDepot() {
        return configDepot;
    }

    @Inject
    public void setConfigDepot(ConfigDepot configDepot) {
        this.configDepot = configDepot;
    }

    public NetworkModel getNetworkModel() {
        return networkModel;
    }

    @Inject
    public void setNetworkModel(NetworkModel networkModel) {
        this.networkModel = networkModel;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    @Inject
    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public NetworkOrchestrationService getNetworkService() {
        return networkService;
    }

    @Inject
    public void setNetworkService(NetworkOrchestrationService networkService) {
        this.networkService = networkService;
    }

}