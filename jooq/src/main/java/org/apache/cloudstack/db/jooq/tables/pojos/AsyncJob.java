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
@javax.persistence.Table(name = "async_job", schema = "cloud")
public class AsyncJob implements java.io.Serializable {

	private static final long serialVersionUID = -1630095469;

	private java.lang.Long     id;
	private java.lang.Long     userId;
	private java.lang.Long     accountId;
	private java.lang.String   instanceType;
	private java.lang.Long     instanceId;
	private java.lang.String   jobCmd;
	private java.lang.String   jobCmdInfo;
	private java.lang.Integer  jobCmdVer;
	private java.lang.Integer  jobStatus;
	private java.lang.Integer  jobProcessStatus;
	private java.lang.Integer  jobResultCode;
	private java.lang.String   jobResult;
	private java.lang.Long     jobInitMsid;
	private java.lang.Long     jobCompleteMsid;
	private java.sql.Timestamp created;
	private java.sql.Timestamp lastUpdated;
	private java.sql.Timestamp lastPolled;
	private java.sql.Timestamp removed;
	private java.lang.String   uuid;
	private java.lang.String   related;
	private java.lang.String   jobType;
	private java.lang.String   jobDispatcher;
	private java.lang.Long     jobExecutingMsid;
	private java.lang.Integer  jobPendingSignals;

	public AsyncJob() {}

	public AsyncJob(
		java.lang.Long     id,
		java.lang.Long     userId,
		java.lang.Long     accountId,
		java.lang.String   instanceType,
		java.lang.Long     instanceId,
		java.lang.String   jobCmd,
		java.lang.String   jobCmdInfo,
		java.lang.Integer  jobCmdVer,
		java.lang.Integer  jobStatus,
		java.lang.Integer  jobProcessStatus,
		java.lang.Integer  jobResultCode,
		java.lang.String   jobResult,
		java.lang.Long     jobInitMsid,
		java.lang.Long     jobCompleteMsid,
		java.sql.Timestamp created,
		java.sql.Timestamp lastUpdated,
		java.sql.Timestamp lastPolled,
		java.sql.Timestamp removed,
		java.lang.String   uuid,
		java.lang.String   related,
		java.lang.String   jobType,
		java.lang.String   jobDispatcher,
		java.lang.Long     jobExecutingMsid,
		java.lang.Integer  jobPendingSignals
	) {
		this.id = id;
		this.userId = userId;
		this.accountId = accountId;
		this.instanceType = instanceType;
		this.instanceId = instanceId;
		this.jobCmd = jobCmd;
		this.jobCmdInfo = jobCmdInfo;
		this.jobCmdVer = jobCmdVer;
		this.jobStatus = jobStatus;
		this.jobProcessStatus = jobProcessStatus;
		this.jobResultCode = jobResultCode;
		this.jobResult = jobResult;
		this.jobInitMsid = jobInitMsid;
		this.jobCompleteMsid = jobCompleteMsid;
		this.created = created;
		this.lastUpdated = lastUpdated;
		this.lastPolled = lastPolled;
		this.removed = removed;
		this.uuid = uuid;
		this.related = related;
		this.jobType = jobType;
		this.jobDispatcher = jobDispatcher;
		this.jobExecutingMsid = jobExecutingMsid;
		this.jobPendingSignals = jobPendingSignals;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "user_id", nullable = false, precision = 20)
	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}

	@javax.persistence.Column(name = "instance_type", length = 64)
	public java.lang.String getInstanceType() {
		return this.instanceType;
	}

	public void setInstanceType(java.lang.String instanceType) {
		this.instanceType = instanceType;
	}

	@javax.persistence.Column(name = "instance_id", precision = 20)
	public java.lang.Long getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(java.lang.Long instanceId) {
		this.instanceId = instanceId;
	}

	@javax.persistence.Column(name = "job_cmd", length = 255)
	public java.lang.String getJobCmd() {
		return this.jobCmd;
	}

	public void setJobCmd(java.lang.String jobCmd) {
		this.jobCmd = jobCmd;
	}

	@javax.persistence.Column(name = "job_cmd_info", length = 65535)
	public java.lang.String getJobCmdInfo() {
		return this.jobCmdInfo;
	}

	public void setJobCmdInfo(java.lang.String jobCmdInfo) {
		this.jobCmdInfo = jobCmdInfo;
	}

	@javax.persistence.Column(name = "job_cmd_ver", precision = 10)
	public java.lang.Integer getJobCmdVer() {
		return this.jobCmdVer;
	}

	public void setJobCmdVer(java.lang.Integer jobCmdVer) {
		this.jobCmdVer = jobCmdVer;
	}

	@javax.persistence.Column(name = "job_status", precision = 10)
	public java.lang.Integer getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(java.lang.Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	@javax.persistence.Column(name = "job_process_status", precision = 10)
	public java.lang.Integer getJobProcessStatus() {
		return this.jobProcessStatus;
	}

	public void setJobProcessStatus(java.lang.Integer jobProcessStatus) {
		this.jobProcessStatus = jobProcessStatus;
	}

	@javax.persistence.Column(name = "job_result_code", precision = 10)
	public java.lang.Integer getJobResultCode() {
		return this.jobResultCode;
	}

	public void setJobResultCode(java.lang.Integer jobResultCode) {
		this.jobResultCode = jobResultCode;
	}

	@javax.persistence.Column(name = "job_result", length = 65535)
	public java.lang.String getJobResult() {
		return this.jobResult;
	}

	public void setJobResult(java.lang.String jobResult) {
		this.jobResult = jobResult;
	}

	@javax.persistence.Column(name = "job_init_msid", precision = 19)
	public java.lang.Long getJobInitMsid() {
		return this.jobInitMsid;
	}

	public void setJobInitMsid(java.lang.Long jobInitMsid) {
		this.jobInitMsid = jobInitMsid;
	}

	@javax.persistence.Column(name = "job_complete_msid", precision = 19)
	public java.lang.Long getJobCompleteMsid() {
		return this.jobCompleteMsid;
	}

	public void setJobCompleteMsid(java.lang.Long jobCompleteMsid) {
		this.jobCompleteMsid = jobCompleteMsid;
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

	@javax.persistence.Column(name = "last_polled")
	public java.sql.Timestamp getLastPolled() {
		return this.lastPolled;
	}

	public void setLastPolled(java.sql.Timestamp lastPolled) {
		this.lastPolled = lastPolled;
	}

	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return this.removed;
	}

	public void setRemoved(java.sql.Timestamp removed) {
		this.removed = removed;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "related", nullable = false, length = 40)
	public java.lang.String getRelated() {
		return this.related;
	}

	public void setRelated(java.lang.String related) {
		this.related = related;
	}

	@javax.persistence.Column(name = "job_type", length = 32)
	public java.lang.String getJobType() {
		return this.jobType;
	}

	public void setJobType(java.lang.String jobType) {
		this.jobType = jobType;
	}

	@javax.persistence.Column(name = "job_dispatcher", length = 64)
	public java.lang.String getJobDispatcher() {
		return this.jobDispatcher;
	}

	public void setJobDispatcher(java.lang.String jobDispatcher) {
		this.jobDispatcher = jobDispatcher;
	}

	@javax.persistence.Column(name = "job_executing_msid", precision = 19)
	public java.lang.Long getJobExecutingMsid() {
		return this.jobExecutingMsid;
	}

	public void setJobExecutingMsid(java.lang.Long jobExecutingMsid) {
		this.jobExecutingMsid = jobExecutingMsid;
	}

	@javax.persistence.Column(name = "job_pending_signals", nullable = false, precision = 10)
	public java.lang.Integer getJobPendingSignals() {
		return this.jobPendingSignals;
	}

	public void setJobPendingSignals(java.lang.Integer jobPendingSignals) {
		this.jobPendingSignals = jobPendingSignals;
	}
}
