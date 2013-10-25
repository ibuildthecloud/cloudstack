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
@javax.persistence.Table(name = "instance_group_vm_map", schema = "cloud")
public class InstanceGroupVmMapRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.InstanceGroupVmMapRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = 1090695694;

	/**
	 * Setter for <code>cloud.instance_group_vm_map.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.instance_group_vm_map.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.instance_group_vm_map.group_id</code>. 
	 */
	public void setGroupId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.instance_group_vm_map.group_id</code>. 
	 */
	@javax.persistence.Column(name = "group_id", nullable = false, precision = 20)
	public java.lang.Long getGroupId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.instance_group_vm_map.instance_id</code>. 
	 */
	public void setInstanceId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.instance_group_vm_map.instance_id</code>. 
	 */
	@javax.persistence.Column(name = "instance_id", nullable = false, precision = 20)
	public java.lang.Long getInstanceId() {
		return (java.lang.Long) getValue(2);
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
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.InstanceGroupVmMap.INSTANCE_GROUP_VM_MAP.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.InstanceGroupVmMap.INSTANCE_GROUP_VM_MAP.GROUP_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.InstanceGroupVmMap.INSTANCE_GROUP_VM_MAP.INSTANCE_ID;
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
		return getGroupId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getInstanceId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached InstanceGroupVmMapRecord
	 */
	public InstanceGroupVmMapRecord() {
		super(org.apache.cloudstack.db.jooq.tables.InstanceGroupVmMap.INSTANCE_GROUP_VM_MAP);
	}

	/**
	 * Create a detached, initialised InstanceGroupVmMapRecord
	 */
	public InstanceGroupVmMapRecord(java.lang.Long id, java.lang.Long groupId, java.lang.Long instanceId) {
		super(org.apache.cloudstack.db.jooq.tables.InstanceGroupVmMap.INSTANCE_GROUP_VM_MAP);

		setValue(0, id);
		setValue(1, groupId);
		setValue(2, instanceId);
	}
}
