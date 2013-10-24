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
@javax.persistence.Table(name = "async_job", schema = "cloud")
public class AsyncJobRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.AsyncJobRecord> {

	private static final long serialVersionUID = 902684704;

	/**
	 * Setter for <code>cloud.async_job.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.async_job.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.async_job.user_id</code>. 
	 */
	public void setUserId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.async_job.user_id</code>. 
	 */
	@javax.persistence.Column(name = "user_id", nullable = false, precision = 20)
	public java.lang.Long getUserId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.async_job.account_id</code>. 
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.async_job.account_id</code>. 
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.async_job.instance_type</code>. instance_type and instance_id work together to allow attaching an instance object to a job
	 */
	public void setInstanceType(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.async_job.instance_type</code>. instance_type and instance_id work together to allow attaching an instance object to a job
	 */
	@javax.persistence.Column(name = "instance_type", length = 64)
	public java.lang.String getInstanceType() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cloud.async_job.instance_id</code>. 
	 */
	public void setInstanceId(java.lang.Long value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.async_job.instance_id</code>. 
	 */
	@javax.persistence.Column(name = "instance_id", precision = 20)
	public java.lang.Long getInstanceId() {
		return (java.lang.Long) getValue(4);
	}

	/**
	 * Setter for <code>cloud.async_job.job_cmd</code>. 
	 */
	public void setJobCmd(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_cmd</code>. 
	 */
	@javax.persistence.Column(name = "job_cmd", length = 255)
	public java.lang.String getJobCmd() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.async_job.job_cmd_info</code>. command parameter info
	 */
	public void setJobCmdInfo(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_cmd_info</code>. command parameter info
	 */
	@javax.persistence.Column(name = "job_cmd_info", length = 65535)
	public java.lang.String getJobCmdInfo() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>cloud.async_job.job_cmd_ver</code>. command version
	 */
	public void setJobCmdVer(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_cmd_ver</code>. command version
	 */
	@javax.persistence.Column(name = "job_cmd_ver", precision = 10)
	public java.lang.Integer getJobCmdVer() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>cloud.async_job.job_status</code>. general job execution status
	 */
	public void setJobStatus(java.lang.Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_status</code>. general job execution status
	 */
	@javax.persistence.Column(name = "job_status", precision = 10)
	public java.lang.Integer getJobStatus() {
		return (java.lang.Integer) getValue(8);
	}

	/**
	 * Setter for <code>cloud.async_job.job_process_status</code>. job specific process status for asynchronize progress update
	 */
	public void setJobProcessStatus(java.lang.Integer value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_process_status</code>. job specific process status for asynchronize progress update
	 */
	@javax.persistence.Column(name = "job_process_status", precision = 10)
	public java.lang.Integer getJobProcessStatus() {
		return (java.lang.Integer) getValue(9);
	}

	/**
	 * Setter for <code>cloud.async_job.job_result_code</code>. job result code, specify error code corresponding to result message
	 */
	public void setJobResultCode(java.lang.Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_result_code</code>. job result code, specify error code corresponding to result message
	 */
	@javax.persistence.Column(name = "job_result_code", precision = 10)
	public java.lang.Integer getJobResultCode() {
		return (java.lang.Integer) getValue(10);
	}

	/**
	 * Setter for <code>cloud.async_job.job_result</code>. job result info
	 */
	public void setJobResult(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_result</code>. job result info
	 */
	@javax.persistence.Column(name = "job_result", length = 65535)
	public java.lang.String getJobResult() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cloud.async_job.job_init_msid</code>. the initiating msid
	 */
	public void setJobInitMsid(java.lang.Long value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_init_msid</code>. the initiating msid
	 */
	@javax.persistence.Column(name = "job_init_msid", precision = 19)
	public java.lang.Long getJobInitMsid() {
		return (java.lang.Long) getValue(12);
	}

	/**
	 * Setter for <code>cloud.async_job.job_complete_msid</code>. completing msid
	 */
	public void setJobCompleteMsid(java.lang.Long value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_complete_msid</code>. completing msid
	 */
	@javax.persistence.Column(name = "job_complete_msid", precision = 19)
	public java.lang.Long getJobCompleteMsid() {
		return (java.lang.Long) getValue(13);
	}

	/**
	 * Setter for <code>cloud.async_job.created</code>. date created
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.async_job.created</code>. date created
	 */
	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(14);
	}

	/**
	 * Setter for <code>cloud.async_job.last_updated</code>. date created
	 */
	public void setLastUpdated(java.sql.Timestamp value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.async_job.last_updated</code>. date created
	 */
	@javax.persistence.Column(name = "last_updated")
	public java.sql.Timestamp getLastUpdated() {
		return (java.sql.Timestamp) getValue(15);
	}

	/**
	 * Setter for <code>cloud.async_job.last_polled</code>. date polled
	 */
	public void setLastPolled(java.sql.Timestamp value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cloud.async_job.last_polled</code>. date polled
	 */
	@javax.persistence.Column(name = "last_polled")
	public java.sql.Timestamp getLastPolled() {
		return (java.sql.Timestamp) getValue(16);
	}

	/**
	 * Setter for <code>cloud.async_job.removed</code>. date removed
	 */
	public void setRemoved(java.sql.Timestamp value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cloud.async_job.removed</code>. date removed
	 */
	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return (java.sql.Timestamp) getValue(17);
	}

	/**
	 * Setter for <code>cloud.async_job.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cloud.async_job.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(18);
	}

	/**
	 * Setter for <code>cloud.async_job.related</code>. 
	 */
	public void setRelated(java.lang.String value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>cloud.async_job.related</code>. 
	 */
	@javax.persistence.Column(name = "related", nullable = false, length = 40)
	public java.lang.String getRelated() {
		return (java.lang.String) getValue(19);
	}

	/**
	 * Setter for <code>cloud.async_job.job_type</code>. 
	 */
	public void setJobType(java.lang.String value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_type</code>. 
	 */
	@javax.persistence.Column(name = "job_type", length = 32)
	public java.lang.String getJobType() {
		return (java.lang.String) getValue(20);
	}

	/**
	 * Setter for <code>cloud.async_job.job_dispatcher</code>. 
	 */
	public void setJobDispatcher(java.lang.String value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_dispatcher</code>. 
	 */
	@javax.persistence.Column(name = "job_dispatcher", length = 64)
	public java.lang.String getJobDispatcher() {
		return (java.lang.String) getValue(21);
	}

	/**
	 * Setter for <code>cloud.async_job.job_executing_msid</code>. 
	 */
	public void setJobExecutingMsid(java.lang.Long value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_executing_msid</code>. 
	 */
	@javax.persistence.Column(name = "job_executing_msid", precision = 19)
	public java.lang.Long getJobExecutingMsid() {
		return (java.lang.Long) getValue(22);
	}

	/**
	 * Setter for <code>cloud.async_job.job_pending_signals</code>. 
	 */
	public void setJobPendingSignals(java.lang.Integer value) {
		setValue(23, value);
	}

	/**
	 * Getter for <code>cloud.async_job.job_pending_signals</code>. 
	 */
	@javax.persistence.Column(name = "job_pending_signals", nullable = false, precision = 10)
	public java.lang.Integer getJobPendingSignals() {
		return (java.lang.Integer) getValue(23);
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
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached AsyncJobRecord
	 */
	public AsyncJobRecord() {
		super(org.apache.cloudstack.db.jooq.tables.AsyncJob.ASYNC_JOB);
	}

	/**
	 * Create a detached, initialised AsyncJobRecord
	 */
	public AsyncJobRecord(java.lang.Long id, java.lang.Long userId, java.lang.Long accountId, java.lang.String instanceType, java.lang.Long instanceId, java.lang.String jobCmd, java.lang.String jobCmdInfo, java.lang.Integer jobCmdVer, java.lang.Integer jobStatus, java.lang.Integer jobProcessStatus, java.lang.Integer jobResultCode, java.lang.String jobResult, java.lang.Long jobInitMsid, java.lang.Long jobCompleteMsid, java.sql.Timestamp created, java.sql.Timestamp lastUpdated, java.sql.Timestamp lastPolled, java.sql.Timestamp removed, java.lang.String uuid, java.lang.String related, java.lang.String jobType, java.lang.String jobDispatcher, java.lang.Long jobExecutingMsid, java.lang.Integer jobPendingSignals) {
		super(org.apache.cloudstack.db.jooq.tables.AsyncJob.ASYNC_JOB);

		setValue(0, id);
		setValue(1, userId);
		setValue(2, accountId);
		setValue(3, instanceType);
		setValue(4, instanceId);
		setValue(5, jobCmd);
		setValue(6, jobCmdInfo);
		setValue(7, jobCmdVer);
		setValue(8, jobStatus);
		setValue(9, jobProcessStatus);
		setValue(10, jobResultCode);
		setValue(11, jobResult);
		setValue(12, jobInitMsid);
		setValue(13, jobCompleteMsid);
		setValue(14, created);
		setValue(15, lastUpdated);
		setValue(16, lastPolled);
		setValue(17, removed);
		setValue(18, uuid);
		setValue(19, related);
		setValue(20, jobType);
		setValue(21, jobDispatcher);
		setValue(22, jobExecutingMsid);
		setValue(23, jobPendingSignals);
	}
}
