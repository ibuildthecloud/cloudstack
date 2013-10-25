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
@javax.persistence.Table(name = "physical_network_tags", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"physical_network_id", "tag"})
})
public class PhysicalNetworkTagsRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.PhysicalNetworkTagsRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.String> {

	private static final long serialVersionUID = -758351814;

	/**
	 * Setter for <code>cloud.physical_network_tags.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.physical_network_tags.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.physical_network_tags.physical_network_id</code>. id of the physical network
	 */
	public void setPhysicalNetworkId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.physical_network_tags.physical_network_id</code>. id of the physical network
	 */
	@javax.persistence.Column(name = "physical_network_id", nullable = false, precision = 20)
	public java.lang.Long getPhysicalNetworkId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.physical_network_tags.tag</code>. tag
	 */
	public void setTag(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.physical_network_tags.tag</code>. tag
	 */
	@javax.persistence.Column(name = "tag", nullable = false, length = 255)
	public java.lang.String getTag() {
		return (java.lang.String) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.PhysicalNetworkTags.PHYSICAL_NETWORK_TAGS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.PhysicalNetworkTags.PHYSICAL_NETWORK_TAGS.PHYSICAL_NETWORK_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.apache.cloudstack.db.jooq.tables.PhysicalNetworkTags.PHYSICAL_NETWORK_TAGS.TAG;
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
	public java.lang.Long value2() {
		return getPhysicalNetworkId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getTag();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PhysicalNetworkTagsRecord
	 */
	public PhysicalNetworkTagsRecord() {
		super(org.apache.cloudstack.db.jooq.tables.PhysicalNetworkTags.PHYSICAL_NETWORK_TAGS);
	}

	/**
	 * Create a detached, initialised PhysicalNetworkTagsRecord
	 */
	public PhysicalNetworkTagsRecord(java.lang.Long id, java.lang.Long physicalNetworkId, java.lang.String tag) {
		super(org.apache.cloudstack.db.jooq.tables.PhysicalNetworkTags.PHYSICAL_NETWORK_TAGS);

		setValue(0, id);
		setValue(1, physicalNetworkId);
		setValue(2, tag);
	}
}
