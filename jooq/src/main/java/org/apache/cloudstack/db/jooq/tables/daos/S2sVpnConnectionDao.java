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
public class S2sVpnConnectionDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection, java.lang.Long> {

	/**
	 * Create a new S2sVpnConnectionDao without any configuration
	 */
	public S2sVpnConnectionDao() {
		super(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION, org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection.class);
	}

	/**
	 * Create a new S2sVpnConnectionDao with an attached configuration
	 */
	public S2sVpnConnectionDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION, org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.UUID, value);
	}

	/**
	 * Fetch records that have <code>vpn_gateway_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByVpnGatewayId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.VPN_GATEWAY_ID, values);
	}

	/**
	 * Fetch records that have <code>customer_gateway_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByCustomerGatewayId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.CUSTOMER_GATEWAY_ID, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.STATE, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.CREATED, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.S2sVpnConnection> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.REMOVED, values);
	}
}
