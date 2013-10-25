/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HostDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.HostRecord, org.apache.cloudstack.db.jooq.tables.pojos.Host, java.lang.Long> {

	/**
	 * Create a new HostDao without any configuration
	 */
	public HostDao() {
		super(org.apache.cloudstack.db.jooq.tables.Host.HOST, org.apache.cloudstack.db.jooq.tables.pojos.Host.class);
	}

	/**
	 * Create a new HostDao with an attached configuration
	 */
	public HostDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.Host.HOST, org.apache.cloudstack.db.jooq.tables.pojos.Host.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.Host object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.Host fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.Host.HOST.ID, value);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.NAME, values);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.Host fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.Host.HOST.UUID, value);
	}

	/**
	 * Fetch records that have <code>status IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStatus(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STATUS, values);
	}

	/**
	 * Fetch records that have <code>type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.TYPE, values);
	}

	/**
	 * Fetch records that have <code>private_ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPrivateIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PRIVATE_IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>private_netmask IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPrivateNetmask(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PRIVATE_NETMASK, values);
	}

	/**
	 * Fetch records that have <code>private_mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPrivateMacAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PRIVATE_MAC_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>storage_ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>storage_netmask IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageNetmask(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_NETMASK, values);
	}

	/**
	 * Fetch records that have <code>storage_mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageMacAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_MAC_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>storage_ip_address_2 IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageIpAddress_2(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_IP_ADDRESS_2, values);
	}

	/**
	 * Fetch records that have <code>storage_mac_address_2 IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageMacAddress_2(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_MAC_ADDRESS_2, values);
	}

	/**
	 * Fetch records that have <code>storage_netmask_2 IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByStorageNetmask_2(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.STORAGE_NETMASK_2, values);
	}

	/**
	 * Fetch records that have <code>cluster_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByClusterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.CLUSTER_ID, values);
	}

	/**
	 * Fetch records that have <code>public_ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPublicIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PUBLIC_IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>public_netmask IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPublicNetmask(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PUBLIC_NETMASK, values);
	}

	/**
	 * Fetch records that have <code>public_mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPublicMacAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PUBLIC_MAC_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>proxy_port IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByProxyPort(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PROXY_PORT, values);
	}

	/**
	 * Fetch records that have <code>data_center_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByDataCenterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.DATA_CENTER_ID, values);
	}

	/**
	 * Fetch records that have <code>pod_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByPodId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.POD_ID, values);
	}

	/**
	 * Fetch records that have <code>cpus IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByCpus(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.CPUS, values);
	}

	/**
	 * Fetch records that have <code>speed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchBySpeed(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.SPEED, values);
	}

	/**
	 * Fetch records that have <code>url IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByUrl(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.URL, values);
	}

	/**
	 * Fetch records that have <code>fs_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByFsType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.FS_TYPE, values);
	}

	/**
	 * Fetch records that have <code>hypervisor_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByHypervisorType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.HYPERVISOR_TYPE, values);
	}

	/**
	 * Fetch records that have <code>hypervisor_version IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByHypervisorVersion(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.HYPERVISOR_VERSION, values);
	}

	/**
	 * Fetch records that have <code>ram IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByRam(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.RAM, values);
	}

	/**
	 * Fetch records that have <code>resource IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByResource(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.RESOURCE, values);
	}

	/**
	 * Fetch records that have <code>version IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByVersion(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.VERSION, values);
	}

	/**
	 * Fetch records that have <code>parent IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByParent(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.PARENT, values);
	}

	/**
	 * Fetch records that have <code>total_size IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByTotalSize(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.TOTAL_SIZE, values);
	}

	/**
	 * Fetch records that have <code>capabilities IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByCapabilities(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.CAPABILITIES, values);
	}

	/**
	 * Fetch records that have <code>guid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByGuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.GUID, values);
	}

	/**
	 * Fetch a unique record that has <code>guid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.Host fetchOneByGuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.Host.HOST.GUID, value);
	}

	/**
	 * Fetch records that have <code>available IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByAvailable(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.AVAILABLE, values);
	}

	/**
	 * Fetch records that have <code>setup IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchBySetup(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.SETUP, values);
	}

	/**
	 * Fetch records that have <code>dom0_memory IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByDom0Memory(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.DOM0_MEMORY, values);
	}

	/**
	 * Fetch records that have <code>last_ping IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByLastPing(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.LAST_PING, values);
	}

	/**
	 * Fetch records that have <code>mgmt_server_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByMgmtServerId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.MGMT_SERVER_ID, values);
	}

	/**
	 * Fetch records that have <code>disconnected IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByDisconnected(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.DISCONNECTED, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.CREATED, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.REMOVED, values);
	}

	/**
	 * Fetch records that have <code>update_count IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByUpdateCount(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.UPDATE_COUNT, values);
	}

	/**
	 * Fetch records that have <code>resource_state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByResourceState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.RESOURCE_STATE, values);
	}

	/**
	 * Fetch records that have <code>owner IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByOwner(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.OWNER, values);
	}

	/**
	 * Fetch records that have <code>lastUpdated IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByLastupdated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.LASTUPDATED, values);
	}

	/**
	 * Fetch records that have <code>engine_state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Host> fetchByEngineState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Host.HOST.ENGINE_STATE, values);
	}
}
