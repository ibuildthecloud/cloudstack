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
@javax.persistence.Table(name = "user_vm_details", schema = "cloud")
public class UserVmDetailsRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.UserVmDetailsRecord> implements org.jooq.Record5<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Byte> {

	private static final long serialVersionUID = -50894227;

	/**
	 * Setter for <code>cloud.user_vm_details.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.user_vm_details.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.user_vm_details.vm_id</code>. vm id
	 */
	public void setVmId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.user_vm_details.vm_id</code>. vm id
	 */
	@javax.persistence.Column(name = "vm_id", nullable = false, precision = 20)
	public java.lang.Long getVmId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.user_vm_details.name</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.user_vm_details.name</code>. 
	 */
	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.user_vm_details.value</code>. 
	 */
	public void setValue(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.user_vm_details.value</code>. 
	 */
	@javax.persistence.Column(name = "value", nullable = false, length = 1024)
	public java.lang.String getValue() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cloud.user_vm_details.display_detail</code>. Should vm detail instance be displayed to the end user
	 */
	public void setDisplayDetail(java.lang.Byte value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.user_vm_details.display_detail</code>. Should vm detail instance be displayed to the end user
	 */
	@javax.persistence.Column(name = "display_detail", nullable = false, precision = 3)
	public java.lang.Byte getDisplayDetail() {
		return (java.lang.Byte) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Byte> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.Byte> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.VM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field5() {
		return org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.DISPLAY_DETAIL;
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
		return getVmId();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value5() {
		return getDisplayDetail();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserVmDetailsRecord
	 */
	public UserVmDetailsRecord() {
		super(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS);
	}

	/**
	 * Create a detached, initialised UserVmDetailsRecord
	 */
	public UserVmDetailsRecord(java.lang.Long id, java.lang.Long vmId, java.lang.String name, java.lang.String value, java.lang.Byte displayDetail) {
		super(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS);

		setValue(0, id);
		setValue(1, vmId);
		setValue(2, name);
		setValue(3, value);
		setValue(4, displayDetail);
	}
}
