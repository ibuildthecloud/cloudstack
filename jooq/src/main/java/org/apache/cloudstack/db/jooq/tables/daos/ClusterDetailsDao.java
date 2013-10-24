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
public class ClusterDetailsDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ClusterDetailsRecord, org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails, java.lang.Long> {

	/**
	 * Create a new ClusterDetailsDao without any configuration
	 */
	public ClusterDetailsDao() {
		super(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS, org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails.class);
	}

	/**
	 * Create a new ClusterDetailsDao with an attached configuration
	 */
	public ClusterDetailsDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS, org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS.ID, value);
	}

	/**
	 * Fetch records that have <code>cluster_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails> fetchByClusterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS.CLUSTER_ID, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS.NAME, values);
	}

	/**
	 * Fetch records that have <code>value IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ClusterDetails> fetchByValue(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ClusterDetails.CLUSTER_DETAILS.VALUE, values);
	}
}
