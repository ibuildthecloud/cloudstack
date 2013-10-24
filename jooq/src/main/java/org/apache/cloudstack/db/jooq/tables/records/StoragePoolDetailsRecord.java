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
@javax.persistence.Table(name = "storage_pool_details", schema = "cloud")
public class StoragePoolDetailsRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.StoragePoolDetailsRecord> implements org.jooq.Record4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -393455986;

	/**
	 * Setter for <code>cloud.storage_pool_details.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.storage_pool_details.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.storage_pool_details.pool_id</code>. pool the detail is related to
	 */
	public void setPoolId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.storage_pool_details.pool_id</code>. pool the detail is related to
	 */
	@javax.persistence.Column(name = "pool_id", nullable = false, precision = 20)
	public java.lang.Long getPoolId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.storage_pool_details.name</code>. name of the detail
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.storage_pool_details.name</code>. name of the detail
	 */
	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.storage_pool_details.value</code>. 
	 */
	public void setValue(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.storage_pool_details.value</code>. 
	 */
	@javax.persistence.Column(name = "value", length = 255)
	public java.lang.String getValue() {
		return (java.lang.String) getValue(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS.POOL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS.VALUE;
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
		return getPoolId();
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
		return getValue();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached StoragePoolDetailsRecord
	 */
	public StoragePoolDetailsRecord() {
		super(org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS);
	}

	/**
	 * Create a detached, initialised StoragePoolDetailsRecord
	 */
	public StoragePoolDetailsRecord(java.lang.Long id, java.lang.Long poolId, java.lang.String name, java.lang.String value) {
		super(org.apache.cloudstack.db.jooq.tables.StoragePoolDetails.STORAGE_POOL_DETAILS);

		setValue(0, id);
		setValue(1, poolId);
		setValue(2, name);
		setValue(3, value);
	}
}
