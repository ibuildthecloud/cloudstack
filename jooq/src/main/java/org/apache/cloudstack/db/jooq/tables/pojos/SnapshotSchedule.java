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
@javax.persistence.Table(name = "snapshot_schedule", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"volume_id", "policy_id"})
})
public class SnapshotSchedule implements java.io.Serializable {

	private static final long serialVersionUID = 232253284;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.Long     volumeId;
	private java.lang.Long     policyId;
	private java.sql.Timestamp scheduledTimestamp;
	private java.lang.Long     asyncJobId;
	private java.lang.Long     snapshotId;

	public SnapshotSchedule() {}

	public SnapshotSchedule(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.Long     volumeId,
		java.lang.Long     policyId,
		java.sql.Timestamp scheduledTimestamp,
		java.lang.Long     asyncJobId,
		java.lang.Long     snapshotId
	) {
		this.id = id;
		this.uuid = uuid;
		this.volumeId = volumeId;
		this.policyId = policyId;
		this.scheduledTimestamp = scheduledTimestamp;
		this.asyncJobId = asyncJobId;
		this.snapshotId = snapshotId;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "volume_id", nullable = false, precision = 20)
	public java.lang.Long getVolumeId() {
		return this.volumeId;
	}

	public void setVolumeId(java.lang.Long volumeId) {
		this.volumeId = volumeId;
	}

	@javax.persistence.Column(name = "policy_id", nullable = false, precision = 20)
	public java.lang.Long getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(java.lang.Long policyId) {
		this.policyId = policyId;
	}

	@javax.persistence.Column(name = "scheduled_timestamp", nullable = false)
	public java.sql.Timestamp getScheduledTimestamp() {
		return this.scheduledTimestamp;
	}

	public void setScheduledTimestamp(java.sql.Timestamp scheduledTimestamp) {
		this.scheduledTimestamp = scheduledTimestamp;
	}

	@javax.persistence.Column(name = "async_job_id", precision = 20)
	public java.lang.Long getAsyncJobId() {
		return this.asyncJobId;
	}

	public void setAsyncJobId(java.lang.Long asyncJobId) {
		this.asyncJobId = asyncJobId;
	}

	@javax.persistence.Column(name = "snapshot_id", precision = 20)
	public java.lang.Long getSnapshotId() {
		return this.snapshotId;
	}

	public void setSnapshotId(java.lang.Long snapshotId) {
		this.snapshotId = snapshotId;
	}
}
