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
public class NiciraNvpRouterMapDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.NiciraNvpRouterMapRecord, org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap, java.lang.Long> {

	/**
	 * Create a new NiciraNvpRouterMapDao without any configuration
	 */
	public NiciraNvpRouterMapDao() {
		super(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP, org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap.class);
	}

	/**
	 * Create a new NiciraNvpRouterMapDao with an attached configuration
	 */
	public NiciraNvpRouterMapDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP, org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.ID, value);
	}

	/**
	 * Fetch records that have <code>logicalrouter_uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap> fetchByLogicalrouterUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.LOGICALROUTER_UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>logicalrouter_uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap fetchOneByLogicalrouterUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.LOGICALROUTER_UUID, value);
	}

	/**
	 * Fetch records that have <code>network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap> fetchByNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.NETWORK_ID, values);
	}

	/**
	 * Fetch a unique record that has <code>network_id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.NiciraNvpRouterMap fetchOneByNetworkId(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.NiciraNvpRouterMap.NICIRA_NVP_ROUTER_MAP.NETWORK_ID, value);
	}
}
