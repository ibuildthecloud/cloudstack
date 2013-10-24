/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "s2s_vpn_connection", schema = "cloud")
public class S2sVpnConnectionRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord> implements org.jooq.Record9<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> {

	private static final long serialVersionUID = -53519664;

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.vpn_gateway_id</code>. 
	 */
	public void setVpnGatewayId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.vpn_gateway_id</code>. 
	 */
	@javax.persistence.Column(name = "vpn_gateway_id", precision = 20)
	public java.lang.Long getVpnGatewayId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.customer_gateway_id</code>. 
	 */
	public void setCustomerGatewayId(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.customer_gateway_id</code>. 
	 */
	@javax.persistence.Column(name = "customer_gateway_id", precision = 20)
	public java.lang.Long getCustomerGatewayId() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.state</code>. 
	 */
	public void setState(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.state</code>. 
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.domain_id</code>. 
	 */
	public void setDomainId(java.lang.Long value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.domain_id</code>. 
	 */
	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return (java.lang.Long) getValue(5);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.account_id</code>. 
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.account_id</code>. 
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(6);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.created</code>. date created
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.created</code>. date created
	 */
	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(7);
	}

	/**
	 * Setter for <code>cloud.s2s_vpn_connection.removed</code>. date removed if not null
	 */
	public void setRemoved(java.sql.Timestamp value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.s2s_vpn_connection.removed</code>. date removed if not null
	 */
	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return (java.sql.Timestamp) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row9<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.VPN_GATEWAY_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.CUSTOMER_GATEWAY_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field6() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field7() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field8() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field9() {
		return org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION.REMOVED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getUuid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getVpnGatewayId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getCustomerGatewayId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value6() {
		return getDomainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value7() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value8() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value9() {
		return getRemoved();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached S2sVpnConnectionRecord
	 */
	public S2sVpnConnectionRecord() {
		super(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION);
	}

	/**
	 * Create a detached, initialised S2sVpnConnectionRecord
	 */
	public S2sVpnConnectionRecord(java.lang.Long id, java.lang.String uuid, java.lang.Long vpnGatewayId, java.lang.Long customerGatewayId, java.lang.String state, java.lang.Long domainId, java.lang.Long accountId, java.sql.Timestamp created, java.sql.Timestamp removed) {
		super(org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION);

		setValue(0, id);
		setValue(1, uuid);
		setValue(2, vpnGatewayId);
		setValue(3, customerGatewayId);
		setValue(4, state);
		setValue(5, domainId);
		setValue(6, accountId);
		setValue(7, created);
		setValue(8, removed);
	}
}
