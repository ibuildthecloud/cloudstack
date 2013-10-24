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
@javax.persistence.Table(name = "vpc", schema = "cloud")
public class VpcRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.VpcRecord> implements org.jooq.Record14<java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Integer> {

	private static final long serialVersionUID = 595665457;

	/**
	 * Setter for <code>cloud.vpc.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.vpc.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.vpc.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.vpc.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", nullable = false, length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.vpc.name</code>. vpc name
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.vpc.name</code>. vpc name
	 */
	@javax.persistence.Column(name = "name", length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.vpc.display_text</code>. vpc display text
	 */
	public void setDisplayText(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.vpc.display_text</code>. vpc display text
	 */
	@javax.persistence.Column(name = "display_text", length = 255)
	public java.lang.String getDisplayText() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cloud.vpc.cidr</code>. vpc cidr
	 */
	public void setCidr(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.vpc.cidr</code>. vpc cidr
	 */
	@javax.persistence.Column(name = "cidr", length = 18)
	public java.lang.String getCidr() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>cloud.vpc.vpc_offering_id</code>. vpc offering id that this vpc is created from
	 */
	public void setVpcOfferingId(java.lang.Long value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.vpc.vpc_offering_id</code>. vpc offering id that this vpc is created from
	 */
	@javax.persistence.Column(name = "vpc_offering_id", nullable = false, precision = 20)
	public java.lang.Long getVpcOfferingId() {
		return (java.lang.Long) getValue(5);
	}

	/**
	 * Setter for <code>cloud.vpc.zone_id</code>. the id of the zone this Vpc belongs to
	 */
	public void setZoneId(java.lang.Long value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.vpc.zone_id</code>. the id of the zone this Vpc belongs to
	 */
	@javax.persistence.Column(name = "zone_id", nullable = false, precision = 20)
	public java.lang.Long getZoneId() {
		return (java.lang.Long) getValue(6);
	}

	/**
	 * Setter for <code>cloud.vpc.state</code>. state of the VP (can be Enabled and Disabled)
	 */
	public void setState(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.vpc.state</code>. state of the VP (can be Enabled and Disabled)
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>cloud.vpc.domain_id</code>. domain the vpc belongs to
	 */
	public void setDomainId(java.lang.Long value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.vpc.domain_id</code>. domain the vpc belongs to
	 */
	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return (java.lang.Long) getValue(8);
	}

	/**
	 * Setter for <code>cloud.vpc.account_id</code>. owner of this vpc
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.vpc.account_id</code>. owner of this vpc
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(9);
	}

	/**
	 * Setter for <code>cloud.vpc.network_domain</code>. network domain
	 */
	public void setNetworkDomain(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.vpc.network_domain</code>. network domain
	 */
	@javax.persistence.Column(name = "network_domain", length = 255)
	public java.lang.String getNetworkDomain() {
		return (java.lang.String) getValue(10);
	}

	/**
	 * Setter for <code>cloud.vpc.removed</code>. date removed if not null
	 */
	public void setRemoved(java.sql.Timestamp value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.vpc.removed</code>. date removed if not null
	 */
	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return (java.sql.Timestamp) getValue(11);
	}

	/**
	 * Setter for <code>cloud.vpc.created</code>. date created
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.vpc.created</code>. date created
	 */
	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(12);
	}

	/**
	 * Setter for <code>cloud.vpc.restart_required</code>. 1 if restart is required for the VPC
	 */
	public void setRestartRequired(java.lang.Integer value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.vpc.restart_required</code>. 1 if restart is required for the VPC
	 */
	@javax.persistence.Column(name = "restart_required", nullable = false, precision = 10)
	public java.lang.Integer getRestartRequired() {
		return (java.lang.Integer) getValue(13);
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
	// Record14 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row14<java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row14) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row14<java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp, java.sql.Timestamp, java.lang.Integer> valuesRow() {
		return (org.jooq.Row14) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.DISPLAY_TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.CIDR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field6() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.VPC_OFFERING_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field7() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.ZONE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field9() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.DOMAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field10() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field11() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.NETWORK_DOMAIN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field12() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.REMOVED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field13() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field14() {
		return org.apache.cloudstack.db.jooq.tables.Vpc.VPC.RESTART_REQUIRED;
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
	public java.lang.String value3() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getDisplayText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getCidr();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value6() {
		return getVpcOfferingId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value7() {
		return getZoneId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value9() {
		return getDomainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value10() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value11() {
		return getNetworkDomain();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value12() {
		return getRemoved();
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
		return getRestartRequired();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached VpcRecord
	 */
	public VpcRecord() {
		super(org.apache.cloudstack.db.jooq.tables.Vpc.VPC);
	}

	/**
	 * Create a detached, initialised VpcRecord
	 */
	public VpcRecord(java.lang.Long id, java.lang.String uuid, java.lang.String name, java.lang.String displayText, java.lang.String cidr, java.lang.Long vpcOfferingId, java.lang.Long zoneId, java.lang.String state, java.lang.Long domainId, java.lang.Long accountId, java.lang.String networkDomain, java.sql.Timestamp removed, java.sql.Timestamp created, java.lang.Integer restartRequired) {
		super(org.apache.cloudstack.db.jooq.tables.Vpc.VPC);

		setValue(0, id);
		setValue(1, uuid);
		setValue(2, name);
		setValue(3, displayText);
		setValue(4, cidr);
		setValue(5, vpcOfferingId);
		setValue(6, zoneId);
		setValue(7, state);
		setValue(8, domainId);
		setValue(9, accountId);
		setValue(10, networkDomain);
		setValue(11, removed);
		setValue(12, created);
		setValue(13, restartRequired);
	}
}
