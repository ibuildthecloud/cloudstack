/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.pojos;

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
public class SyncQueue implements java.io.Serializable {

	private static final long serialVersionUID = -804045983;

	private java.lang.Long     id;
	private java.lang.String   syncObjtype;
	private java.lang.Long     syncObjid;
	private java.lang.Long     queueProcNumber;
	private java.sql.Timestamp created;
	private java.sql.Timestamp lastUpdated;
	private java.lang.Short    queueSize;
	private java.lang.Short    queueSizeLimit;

	public SyncQueue() {}

	public SyncQueue(
		java.lang.Long     id,
		java.lang.String   syncObjtype,
		java.lang.Long     syncObjid,
		java.lang.Long     queueProcNumber,
		java.sql.Timestamp created,
		java.sql.Timestamp lastUpdated,
		java.lang.Short    queueSize,
		java.lang.Short    queueSizeLimit
	) {
		this.id = id;
		this.syncObjtype = syncObjtype;
		this.syncObjid = syncObjid;
		this.queueProcNumber = queueProcNumber;
		this.created = created;
		this.lastUpdated = lastUpdated;
		this.queueSize = queueSize;
		this.queueSizeLimit = queueSizeLimit;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "sync_objtype", nullable = false, length = 64)
	public java.lang.String getSyncObjtype() {
		return this.syncObjtype;
	}

	public void setSyncObjtype(java.lang.String syncObjtype) {
		this.syncObjtype = syncObjtype;
	}

	@javax.persistence.Column(name = "sync_objid", nullable = false, precision = 20)
	public java.lang.Long getSyncObjid() {
		return this.syncObjid;
	}

	public void setSyncObjid(java.lang.Long syncObjid) {
		this.syncObjid = syncObjid;
	}

	@javax.persistence.Column(name = "queue_proc_number", precision = 19)
	public java.lang.Long getQueueProcNumber() {
		return this.queueProcNumber;
	}

	public void setQueueProcNumber(java.lang.Long queueProcNumber) {
		this.queueProcNumber = queueProcNumber;
	}

	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "last_updated")
	public java.sql.Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(java.sql.Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@javax.persistence.Column(name = "queue_size", nullable = false, precision = 5)
	public java.lang.Short getQueueSize() {
		return this.queueSize;
	}

	public void setQueueSize(java.lang.Short queueSize) {
		this.queueSize = queueSize;
	}

	@javax.persistence.Column(name = "queue_size_limit", nullable = false, precision = 5)
	public java.lang.Short getQueueSizeLimit() {
		return this.queueSizeLimit;
	}

	public void setQueueSizeLimit(java.lang.Short queueSizeLimit) {
		this.queueSizeLimit = queueSizeLimit;
	}
}
