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
@javax.persistence.Table(name = "vm_network_map", schema = "cloud")
public class VmNetworkMapRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.VmNetworkMapRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = 1737627071;

	/**
	 * Setter for <code>cloud.vm_network_map.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.vm_network_map.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.vm_network_map.vm_id</code>. vm id
	 */
	public void setVmId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.vm_network_map.vm_id</code>. vm id
	 */
	@javax.persistence.Column(name = "vm_id", nullable = false, precision = 20)
	public java.lang.Long getVmId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.vm_network_map.network_id</code>. network id
	 */
	public void setNetworkId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.vm_network_map.network_id</code>. network id
	 */
	@javax.persistence.Column(name = "network_id", nullable = false, precision = 20)
	public java.lang.Long getNetworkId() {
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
		return org.apache.cloudstack.db.jooq.tables.VmNetworkMap.VM_NETWORK_MAP.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.VmNetworkMap.VM_NETWORK_MAP.VM_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.VmNetworkMap.VM_NETWORK_MAP.NETWORK_ID;
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
	public java.lang.Long value3() {
		return getNetworkId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached VmNetworkMapRecord
	 */
	public VmNetworkMapRecord() {
		super(org.apache.cloudstack.db.jooq.tables.VmNetworkMap.VM_NETWORK_MAP);
	}

	/**
	 * Create a detached, initialised VmNetworkMapRecord
	 */
	public VmNetworkMapRecord(java.lang.Long id, java.lang.Long vmId, java.lang.Long networkId) {
		super(org.apache.cloudstack.db.jooq.tables.VmNetworkMap.VM_NETWORK_MAP);

		setValue(0, id);
		setValue(1, vmId);
		setValue(2, networkId);
	}
}
