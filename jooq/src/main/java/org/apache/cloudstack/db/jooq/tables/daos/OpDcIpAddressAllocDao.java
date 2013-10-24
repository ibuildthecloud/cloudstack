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
public class OpDcIpAddressAllocDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.OpDcIpAddressAllocRecord, org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc, java.lang.Long> {

	/**
	 * Create a new OpDcIpAddressAllocDao without any configuration
	 */
	public OpDcIpAddressAllocDao() {
		super(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC, org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc.class);
	}

	/**
	 * Create a new OpDcIpAddressAllocDao with an attached configuration
	 */
	public OpDcIpAddressAllocDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC, org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.ID, value);
	}

	/**
	 * Fetch records that have <code>ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>data_center_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByDataCenterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.DATA_CENTER_ID, values);
	}

	/**
	 * Fetch records that have <code>pod_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByPodId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.POD_ID, values);
	}

	/**
	 * Fetch records that have <code>nic_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByNicId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.NIC_ID, values);
	}

	/**
	 * Fetch records that have <code>reservation_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByReservationId(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.RESERVATION_ID, values);
	}

	/**
	 * Fetch records that have <code>taken IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByTaken(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.TAKEN, values);
	}

	/**
	 * Fetch records that have <code>mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpDcIpAddressAlloc> fetchByMacAddress(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpDcIpAddressAlloc.OP_DC_IP_ADDRESS_ALLOC.MAC_ADDRESS, values);
	}
}
