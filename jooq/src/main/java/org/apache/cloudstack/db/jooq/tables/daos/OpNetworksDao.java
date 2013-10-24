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
public class OpNetworksDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.OpNetworksRecord, org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks, java.lang.Long> {

	/**
	 * Create a new OpNetworksDao without any configuration
	 */
	public OpNetworksDao() {
		super(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS, org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks.class);
	}

	/**
	 * Create a new OpNetworksDao with an attached configuration
	 */
	public OpNetworksDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS, org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.ID, value);
	}

	/**
	 * Fetch records that have <code>mac_address_seq IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks> fetchByMacAddressSeq(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.MAC_ADDRESS_SEQ, values);
	}

	/**
	 * Fetch records that have <code>nics_count IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks> fetchByNicsCount(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.NICS_COUNT, values);
	}

	/**
	 * Fetch records that have <code>gc IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks> fetchByGc(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.GC, values);
	}

	/**
	 * Fetch records that have <code>check_for_gc IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.OpNetworks> fetchByCheckForGc(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.OpNetworks.OP_NETWORKS.CHECK_FOR_GC, values);
	}
}
