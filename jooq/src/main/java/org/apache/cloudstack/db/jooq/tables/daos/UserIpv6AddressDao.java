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
public class UserIpv6AddressDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.UserIpv6AddressRecord, org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address, java.lang.Long> {

	/**
	 * Create a new UserIpv6AddressDao without any configuration
	 */
	public UserIpv6AddressDao() {
		super(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS, org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address.class);
	}

	/**
	 * Create a new UserIpv6AddressDao with an attached configuration
	 */
	public UserIpv6AddressDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS, org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.UUID, value);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>data_center_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByDataCenterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.DATA_CENTER_ID, values);
	}

	/**
	 * Fetch records that have <code>vlan_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByVlanId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.VLAN_ID, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.STATE, values);
	}

	/**
	 * Fetch records that have <code>mac_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByMacAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.MAC_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>source_network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchBySourceNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.SOURCE_NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>physical_network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByPhysicalNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.PHYSICAL_NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserIpv6Address> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserIpv6Address.USER_IPV6_ADDRESS.CREATED, values);
	}
}
