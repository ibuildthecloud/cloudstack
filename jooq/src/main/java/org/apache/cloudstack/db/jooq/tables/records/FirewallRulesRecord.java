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
@javax.persistence.Table(name = "firewall_rules", schema = "cloud")
public class FirewallRulesRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord> implements org.jooq.Record19<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String> {

	private static final long serialVersionUID = 554183993;

	/**
	 * Setter for <code>cloud.firewall_rules.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.ip_address_id</code>. id of the corresponding ip address
	 */
	public void setIpAddressId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.ip_address_id</code>. id of the corresponding ip address
	 */
	@javax.persistence.Column(name = "ip_address_id", precision = 20)
	public java.lang.Long getIpAddressId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.start_port</code>. starting port of a port range
	 */
	public void setStartPort(java.lang.Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.start_port</code>. starting port of a port range
	 */
	@javax.persistence.Column(name = "start_port", precision = 10)
	public java.lang.Integer getStartPort() {
		return (java.lang.Integer) getValue(3);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.end_port</code>. end port of a port range
	 */
	public void setEndPort(java.lang.Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.end_port</code>. end port of a port range
	 */
	@javax.persistence.Column(name = "end_port", precision = 10)
	public java.lang.Integer getEndPort() {
		return (java.lang.Integer) getValue(4);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.state</code>. current state of this rule
	 */
	public void setState(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.state</code>. current state of this rule
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.protocol</code>. protocol to open these ports for
	 */
	public void setProtocol(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.protocol</code>. protocol to open these ports for
	 */
	@javax.persistence.Column(name = "protocol", nullable = false, length = 16)
	public java.lang.String getProtocol() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.purpose</code>. why are these ports opened?
	 */
	public void setPurpose(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.purpose</code>. why are these ports opened?
	 */
	@javax.persistence.Column(name = "purpose", nullable = false, length = 32)
	public java.lang.String getPurpose() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.account_id</code>. owner id
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.account_id</code>. owner id
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(8);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.domain_id</code>. domain id
	 */
	public void setDomainId(java.lang.Long value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.domain_id</code>. domain id
	 */
	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return (java.lang.Long) getValue(9);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.network_id</code>. network id
	 */
	public void setNetworkId(java.lang.Long value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.network_id</code>. network id
	 */
	@javax.persistence.Column(name = "network_id", nullable = false, precision = 20)
	public java.lang.Long getNetworkId() {
		return (java.lang.Long) getValue(10);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.xid</code>. external id
	 */
	public void setXid(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.xid</code>. external id
	 */
	@javax.persistence.Column(name = "xid", nullable = false, length = 40)
	public java.lang.String getXid() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.created</code>. Date created
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.created</code>. Date created
	 */
	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(12);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.icmp_code</code>. The ICMP code (if protocol=ICMP). A value of -1 means all codes for the given ICMP type.
	 */
	public void setIcmpCode(java.lang.Integer value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.icmp_code</code>. The ICMP code (if protocol=ICMP). A value of -1 means all codes for the given ICMP type.
	 */
	@javax.persistence.Column(name = "icmp_code", precision = 10)
	public java.lang.Integer getIcmpCode() {
		return (java.lang.Integer) getValue(13);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.icmp_type</code>. The ICMP type (if protocol=ICMP). A value of -1 means all types.
	 */
	public void setIcmpType(java.lang.Integer value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.icmp_type</code>. The ICMP type (if protocol=ICMP). A value of -1 means all types.
	 */
	@javax.persistence.Column(name = "icmp_type", precision = 10)
	public java.lang.Integer getIcmpType() {
		return (java.lang.Integer) getValue(14);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.related</code>. related to what other firewall rule
	 */
	public void setRelated(java.lang.Long value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.related</code>. related to what other firewall rule
	 */
	@javax.persistence.Column(name = "related", precision = 20)
	public java.lang.Long getRelated() {
		return (java.lang.Long) getValue(15);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.type</code>. 
	 */
	public void setType(java.lang.String value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.type</code>. 
	 */
	@javax.persistence.Column(name = "type", nullable = false, length = 10)
	public java.lang.String getType() {
		return (java.lang.String) getValue(16);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.vpc_id</code>. vpc the firewall rule is associated with
	 */
	public void setVpcId(java.lang.Long value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.vpc_id</code>. vpc the firewall rule is associated with
	 */
	@javax.persistence.Column(name = "vpc_id", precision = 20)
	public java.lang.Long getVpcId() {
		return (java.lang.Long) getValue(17);
	}

	/**
	 * Setter for <code>cloud.firewall_rules.traffic_type</code>. the traffic type of the rule, can be Ingress or Egress
	 */
	public void setTrafficType(java.lang.String value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cloud.firewall_rules.traffic_type</code>. the traffic type of the rule, can be Ingress or Egress
	 */
	@javax.persistence.Column(name = "traffic_type", length = 32)
	public java.lang.String getTrafficType() {
		return (java.lang.String) getValue(18);
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
	// Record19 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row19<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String> fieldsRow() {
		return (org.jooq.Row19) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row19<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.lang.Integer, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String> valuesRow() {
		return (org.jooq.Row19) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.IP_ADDRESS_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field4() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.START_PORT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field5() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.END_PORT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.PROTOCOL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.PURPOSE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field9() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field10() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field11() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.NETWORK_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field12() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.XID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field13() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field14() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.ICMP_CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field15() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.ICMP_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field16() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.RELATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field17() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field18() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.VPC_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field19() {
		return org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES.TRAFFIC_TYPE;
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
		return getIpAddressId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value4() {
		return getStartPort();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value5() {
		return getEndPort();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getProtocol();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getPurpose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value9() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value10() {
		return getDomainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value11() {
		return getNetworkId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value12() {
		return getXid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value13() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value14() {
		return getIcmpCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value15() {
		return getIcmpType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value16() {
		return getRelated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value17() {
		return getType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value18() {
		return getVpcId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value19() {
		return getTrafficType();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached FirewallRulesRecord
	 */
	public FirewallRulesRecord() {
		super(org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES);
	}

	/**
	 * Create a detached, initialised FirewallRulesRecord
	 */
	public FirewallRulesRecord(java.lang.Long id, java.lang.String uuid, java.lang.Long ipAddressId, java.lang.Integer startPort, java.lang.Integer endPort, java.lang.String state, java.lang.String protocol, java.lang.String purpose, java.lang.Long accountId, java.lang.Long domainId, java.lang.Long networkId, java.lang.String xid, java.sql.Timestamp created, java.lang.Integer icmpCode, java.lang.Integer icmpType, java.lang.Long related, java.lang.String type, java.lang.Long vpcId, java.lang.String trafficType) {
		super(org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES);

		setValue(0, id);
		setValue(1, uuid);
		setValue(2, ipAddressId);
		setValue(3, startPort);
		setValue(4, endPort);
		setValue(5, state);
		setValue(6, protocol);
		setValue(7, purpose);
		setValue(8, accountId);
		setValue(9, domainId);
		setValue(10, networkId);
		setValue(11, xid);
		setValue(12, created);
		setValue(13, icmpCode);
		setValue(14, icmpType);
		setValue(15, related);
		setValue(16, type);
		setValue(17, vpcId);
		setValue(18, trafficType);
	}
}
