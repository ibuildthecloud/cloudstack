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
public class ExternalNiciraNvpDevicesDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ExternalNiciraNvpDevicesRecord, org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices, java.lang.Long> {

	/**
	 * Create a new ExternalNiciraNvpDevicesDao without any configuration
	 */
	public ExternalNiciraNvpDevicesDao() {
		super(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES, org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices.class);
	}

	/**
	 * Create a new ExternalNiciraNvpDevicesDao with an attached configuration
	 */
	public ExternalNiciraNvpDevicesDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES, org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.UUID, value);
	}

	/**
	 * Fetch records that have <code>physical_network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchByPhysicalNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.PHYSICAL_NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>provider_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchByProviderName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.PROVIDER_NAME, values);
	}

	/**
	 * Fetch records that have <code>device_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchByDeviceName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.DEVICE_NAME, values);
	}

	/**
	 * Fetch records that have <code>host_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ExternalNiciraNvpDevices> fetchByHostId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ExternalNiciraNvpDevices.EXTERNAL_NICIRA_NVP_DEVICES.HOST_ID, values);
	}
}
