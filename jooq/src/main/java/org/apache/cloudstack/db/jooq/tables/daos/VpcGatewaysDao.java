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
public class VpcGatewaysDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.VpcGatewaysRecord, org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways, java.lang.Long> {

	/**
	 * Create a new VpcGatewaysDao without any configuration
	 */
	public VpcGatewaysDao() {
		super(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS, org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways.class);
	}

	/**
	 * Create a new VpcGatewaysDao with an attached configuration
	 */
	public VpcGatewaysDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS, org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.UUID, value);
	}

	/**
	 * Fetch records that have <code>ip4_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByIp4Address(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.IP4_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>netmask IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByNetmask(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.NETMASK, values);
	}

	/**
	 * Fetch records that have <code>gateway IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByGateway(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.GATEWAY, values);
	}

	/**
	 * Fetch records that have <code>vlan_tag IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByVlanTag(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.VLAN_TAG, values);
	}

	/**
	 * Fetch records that have <code>type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.TYPE, values);
	}

	/**
	 * Fetch records that have <code>network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>vpc_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByVpcId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.VPC_ID, values);
	}

	/**
	 * Fetch records that have <code>zone_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByZoneId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.ZONE_ID, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.CREATED, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.STATE, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.REMOVED, values);
	}

	/**
	 * Fetch records that have <code>source_nat IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchBySourceNat(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.SOURCE_NAT, values);
	}

	/**
	 * Fetch records that have <code>network_acl_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.VpcGateways> fetchByNetworkAclId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.VpcGateways.VPC_GATEWAYS.NETWORK_ACL_ID, values);
	}
}
