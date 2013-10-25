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
@javax.persistence.Table(name = "sync_queue", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"sync_objtype", "sync_objid"})
})
public class SyncQueueRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.SyncQueueRecord> implements org.jooq.Record8<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.Short, java.lang.Short> {

	private static final long serialVersionUID = -1744852208;

	/**
	 * Setter for <code>cloud.sync_queue.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.sync_queue.sync_objtype</code>. 
	 */
	public void setSyncObjtype(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.sync_objtype</code>. 
	 */
	@javax.persistence.Column(name = "sync_objtype", nullable = false, length = 64)
	public java.lang.String getSyncObjtype() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.sync_queue.sync_objid</code>. 
	 */
	public void setSyncObjid(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.sync_objid</code>. 
	 */
	@javax.persistence.Column(name = "sync_objid", nullable = false, precision = 20)
	public java.lang.Long getSyncObjid() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.sync_queue.queue_proc_number</code>. process number, increase 1 for each iteration
	 */
	public void setQueueProcNumber(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.queue_proc_number</code>. process number, increase 1 for each iteration
	 */
	@javax.persistence.Column(name = "queue_proc_number", precision = 19)
	public java.lang.Long getQueueProcNumber() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>cloud.sync_queue.created</code>. date created
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.created</code>. date created
	 */
	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>cloud.sync_queue.last_updated</code>. date created
	 */
	public void setLastUpdated(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.last_updated</code>. date created
	 */
	@javax.persistence.Column(name = "last_updated")
	public java.sql.Timestamp getLastUpdated() {
		return (java.sql.Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>cloud.sync_queue.queue_size</code>. number of items being processed by the queue
	 */
	public void setQueueSize(java.lang.Short value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.queue_size</code>. number of items being processed by the queue
	 */
	@javax.persistence.Column(name = "queue_size", nullable = false, precision = 5)
	public java.lang.Short getQueueSize() {
		return (java.lang.Short) getValue(6);
	}

	/**
	 * Setter for <code>cloud.sync_queue.queue_size_limit</code>. max number of items the queue can process concurrently
	 */
	public void setQueueSizeLimit(java.lang.Short value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.sync_queue.queue_size_limit</code>. max number of items the queue can process concurrently
	 */
	@javax.persistence.Column(name = "queue_size_limit", nullable = false, precision = 5)
	public java.lang.Short getQueueSizeLimit() {
		return (java.lang.Short) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.Short, java.lang.Short> fieldsRow() {
		return (org.jooq.Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row8<java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.Short, java.lang.Short> valuesRow() {
		return (org.jooq.Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.SYNC_OBJTYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.SYNC_OBJID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.QUEUE_PROC_NUMBER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.LAST_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Short> field7() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.QUEUE_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Short> field8() {
		return org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE.QUEUE_SIZE_LIMIT;
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
		return getSyncObjtype();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getSyncObjid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getQueueProcNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value5() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getLastUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Short value7() {
		return getQueueSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Short value8() {
		return getQueueSizeLimit();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SyncQueueRecord
	 */
	public SyncQueueRecord() {
		super(org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE);
	}

	/**
	 * Create a detached, initialised SyncQueueRecord
	 */
	public SyncQueueRecord(java.lang.Long id, java.lang.String syncObjtype, java.lang.Long syncObjid, java.lang.Long queueProcNumber, java.sql.Timestamp created, java.sql.Timestamp lastUpdated, java.lang.Short queueSize, java.lang.Short queueSizeLimit) {
		super(org.apache.cloudstack.db.jooq.tables.SyncQueue.SYNC_QUEUE);

		setValue(0, id);
		setValue(1, syncObjtype);
		setValue(2, syncObjid);
		setValue(3, queueProcNumber);
		setValue(4, created);
		setValue(5, lastUpdated);
		setValue(6, queueSize);
		setValue(7, queueSizeLimit);
	}
}
