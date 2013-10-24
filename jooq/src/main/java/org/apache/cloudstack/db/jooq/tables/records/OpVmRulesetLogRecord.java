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
@javax.persistence.Table(name = "op_vm_ruleset_log", schema = "cloud")
public class OpVmRulesetLogRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.OpVmRulesetLogRecord> implements org.jooq.Record4<java.lang.Long, java.lang.Long, java.sql.Timestamp, java.lang.Long> {

	private static final long serialVersionUID = -1177045435;

	/**
	 * Setter for <code>cloud.op_vm_ruleset_log.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.op_vm_ruleset_log.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.op_vm_ruleset_log.instance_id</code>. vm instance that needs rules to be synced.
	 */
	public void setInstanceId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.op_vm_ruleset_log.instance_id</code>. vm instance that needs rules to be synced.
	 */
	@javax.persistence.Column(name = "instance_id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getInstanceId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.op_vm_ruleset_log.created</code>. time the entry was requested
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.op_vm_ruleset_log.created</code>. time the entry was requested
	 */
	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>cloud.op_vm_ruleset_log.logsequence</code>. seq number to be sent to agent, uniquely identifies ruleset update
	 */
	public void setLogsequence(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.op_vm_ruleset_log.logsequence</code>. seq number to be sent to agent, uniquely identifies ruleset update
	 */
	@javax.persistence.Column(name = "logsequence", precision = 20)
	public java.lang.Long getLogsequence() {
		return (java.lang.Long) getValue(3);
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
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.sql.Timestamp, java.lang.Long> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.sql.Timestamp, java.lang.Long> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG.INSTANCE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field3() {
		return org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG.LOGSEQUENCE;
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
		return getInstanceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value3() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getLogsequence();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached OpVmRulesetLogRecord
	 */
	public OpVmRulesetLogRecord() {
		super(org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG);
	}

	/**
	 * Create a detached, initialised OpVmRulesetLogRecord
	 */
	public OpVmRulesetLogRecord(java.lang.Long id, java.lang.Long instanceId, java.sql.Timestamp created, java.lang.Long logsequence) {
		super(org.apache.cloudstack.db.jooq.tables.OpVmRulesetLog.OP_VM_RULESET_LOG);

		setValue(0, id);
		setValue(1, instanceId);
		setValue(2, created);
		setValue(3, logsequence);
	}
}
