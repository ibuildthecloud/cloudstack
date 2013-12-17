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
package org.apache.cloudstack.transport.resource;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.naming.ConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.agent.api.StartupCommand;
import com.cloud.dc.dao.ClusterDao;
import com.cloud.exception.DiscoveryException;
import com.cloud.host.Host.Type;
import com.cloud.host.HostVO;
import com.cloud.host.dao.HostDao;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.resource.Discoverer;
import com.cloud.resource.ResourceManager;
import com.cloud.resource.ResourceStateAdapter;
import com.cloud.resource.ServerResource;
import com.cloud.resource.UnableDeleteHostException;
import com.cloud.utils.component.ManagerBase;

public class TransportResourceDiscoverer extends ManagerBase implements Discoverer, ResourceStateAdapter {

    private static final Logger log = LoggerFactory.getLogger(TransportResourceDiscoverer.class);

    TransportFactory transportFactory;
    HostDao hostDao;
    ClusterDao clusterDao;
    ResourceManager resourceManager;


    @Override
    public boolean configure(String name, Map<String, Object> params) throws ConfigurationException {
        resourceManager.registerResourceStateAdapter(name, this);
        return super.configure(name, params);
    }

    @Override
    public Map<? extends ServerResource, Map<String, String>> find(long dcId, Long podId, Long clusterId, URI uri,
            String username, String password, List<String> hostTags) throws DiscoveryException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void postDiscovery(List<HostVO> hosts, long msId) throws DiscoveryException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean matchHypervisor(String hypervisor) {
        return false;
    }

    @Override
    public HypervisorType getHypervisorType() {
        return HypervisorType.Generic;
    }

    @Override
    public void putParam(Map<String, String> params) {
    }

    @Override
    public ServerResource reloadResource(HostVO host) {
        hostDao.loadDetails(host);;
        Transport transport = transportFactory.getTransport(host);
        TransportResource resource = new TransportResource(transport);

        try {
            resource.configure(resource.getName(), getParams(host));
        } catch (ConfigurationException e) {
            log.error("Failed to find configure TransportResport [{}]", resource, e);
            throw new IllegalStateException(e);
        }

        return resource;
    }

    protected Map<String,Object> getParams(HostVO host) {
        Map<String, Object> params = new HashMap<String, Object>(host.getDetails().size() + 5);
        params.putAll(host.getDetails());

        StartupCommand startupCommand = new StartupCommand(Type.Routing);
        startupCommand.setGuid(host.getGuid());
        startupCommand.setDataCenter(Long.toString(host.getDataCenterId())); 
        startupCommand.setPod(Long.toString(host.getPodId()));

        if (host.getClusterId() != null) {
            startupCommand.setCluster(Long.toString(host.getClusterId()));
        }

        startupCommand.setPrivateIpAddress(host.getPrivateIpAddress());
        startupCommand.setName(host.getName());

        params.put("startupCommand", startupCommand);
        return params;
    }

    @Override
    public HostVO createHostVOForDirectConnectAgent(HostVO host, StartupCommand[] startup, ServerResource resource,
            Map<String, String> details, List<String> hostTags) {
        if ( TransportResource.class.isAssignableFrom(resource.getClass()) )
            return host;

        return null;
    }

    @Override
    public DeleteHostAnswer deleteHost(HostVO host, boolean isForced, boolean isForceDeleteStorage)
            throws UnableDeleteHostException {
        return null;
    }
    public TransportFactory getTransportFactory() {
        return transportFactory;
    }

    @Inject
    public void setTransportFactory(TransportFactory transportFactory) {
        this.transportFactory = transportFactory;
    }

    public HostDao getHostDao() {
        return hostDao;
    }

    @Inject
    public void setHostDao(HostDao hostDao) {
        this.hostDao = hostDao;
    }

    public ClusterDao getClusterDao() {
        return clusterDao;
    }

    @Inject
    public void setClusterDao(ClusterDao clusterDao) {
        this.clusterDao = clusterDao;
    }

    @Override
    public HostVO createHostVOForConnectedAgent(HostVO host, StartupCommand[] cmd) {
        if ( host.getResource().equals(TransportResource.class.getName()) )
            return host;

        return null;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    @Inject
    public void setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

}
