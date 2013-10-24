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
public class VmInstanceDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.VmInstanceRecord, org.apache.cloudstack.db.jooq.tables.pojos.VmInstance, java.lang.Long> {

	/**
	 * Create a new VmInstanceDao without any configuration
	 */
	public VmInstanceDao() {
		super(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE, org.apache.cloudstack.db.jooq.tables.pojos.VmInstance.class);
	}

	/**
	 * Create a new VmInstanceDao with an attached configuration
	 */
	public VmInstanceDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE, org.apache.cloudstack.db.jooq.tables.pojos.VmInstance.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.VmInstance object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.VmInstance fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.ID, value);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.NAME, values);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.VmInstance fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.UUID, value);
	}

	/**
	 * Fetch records that have <code>instance_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByInstanceName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.INSTANCE_NAME, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.STATE, values);
	}

	/**
	 * Fetch records that have <code>vm_template_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByVmTemplateId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.VM_TEMPLATE_ID, values);
	}

	/**
	 * Fetch records that have <code>guest_os_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByGuestOsId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.GUEST_OS_ID, values);
	}

	/**
	 * Fetch records that have <code>private_mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPrivateMacAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.PRIVATE_MAC_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>private_ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPrivateIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.PRIVATE_IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>pod_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPodId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.POD_ID, values);
	}

	/**
	 * Fetch records that have <code>data_center_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDataCenterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DATA_CENTER_ID, values);
	}

	/**
	 * Fetch records that have <code>host_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByHostId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.HOST_ID, values);
	}

	/**
	 * Fetch records that have <code>last_host_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByLastHostId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.LAST_HOST_ID, values);
	}

	/**
	 * Fetch records that have <code>proxy_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByProxyId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.PROXY_ID, values);
	}

	/**
	 * Fetch records that have <code>proxy_assign_time IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByProxyAssignTime(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.PROXY_ASSIGN_TIME, values);
	}

	/**
	 * Fetch records that have <code>vnc_password IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByVncPassword(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.VNC_PASSWORD, values);
	}

	/**
	 * Fetch records that have <code>ha_enabled IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByHaEnabled(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.HA_ENABLED, values);
	}

	/**
	 * Fetch records that have <code>limit_cpu_use IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByLimitCpuUse(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.LIMIT_CPU_USE, values);
	}

	/**
	 * Fetch records that have <code>update_count IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByUpdateCount(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.UPDATE_COUNT, values);
	}

	/**
	 * Fetch records that have <code>update_time IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByUpdateTime(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.UPDATE_TIME, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.CREATED, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.REMOVED, values);
	}

	/**
	 * Fetch records that have <code>type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.TYPE, values);
	}

	/**
	 * Fetch records that have <code>vm_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByVmType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.VM_TYPE, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>service_offering_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByServiceOfferingId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.SERVICE_OFFERING_ID, values);
	}

	/**
	 * Fetch records that have <code>reservation_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByReservationId(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.RESERVATION_ID, values);
	}

	/**
	 * Fetch records that have <code>hypervisor_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByHypervisorType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.HYPERVISOR_TYPE, values);
	}

	/**
	 * Fetch records that have <code>disk_offering_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDiskOfferingId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DISK_OFFERING_ID, values);
	}

	/**
	 * Fetch records that have <code>cpu IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByCpu(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.CPU, values);
	}

	/**
	 * Fetch records that have <code>ram IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByRam(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.RAM, values);
	}

	/**
	 * Fetch records that have <code>owner IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByOwner(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.OWNER, values);
	}

	/**
	 * Fetch records that have <code>speed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchBySpeed(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.SPEED, values);
	}

	/**
	 * Fetch records that have <code>host_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByHostName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.HOST_NAME, values);
	}

	/**
	 * Fetch records that have <code>display_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDisplayName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DISPLAY_NAME, values);
	}

	/**
	 * Fetch records that have <code>desired_state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDesiredState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DESIRED_STATE, values);
	}

	/**
	 * Fetch records that have <code>dynamically_scalable IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDynamicallyScalable(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DYNAMICALLY_SCALABLE, values);
	}

	/**
	 * Fetch records that have <code>display_vm IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByDisplayVm(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.DISPLAY_VM, values);
	}

	/**
	 * Fetch records that have <code>power_state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPowerState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.POWER_STATE, values);
	}

	/**
	 * Fetch records that have <code>power_state_update_time IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPowerStateUpdateTime(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.POWER_STATE_UPDATE_TIME, values);
	}

	/**
	 * Fetch records that have <code>power_state_update_count IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPowerStateUpdateCount(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.POWER_STATE_UPDATE_COUNT, values);
	}

	/**
	 * Fetch records that have <code>power_host IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VmInstance> fetchByPowerHost(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VmInstance.VM_INSTANCE.POWER_HOST, values);
	}
}
