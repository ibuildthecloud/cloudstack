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
@javax.persistence.Table(name = "template_spool_ref", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"template_id", "pool_id"})
})
public class TemplateSpoolRefRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.TemplateSpoolRefRecord> implements org.jooq.Record16<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Byte, java.lang.String, java.lang.Long, java.sql.Timestamp> {

	private static final long serialVersionUID = 171554958;

	/**
	 * Setter for <code>cloud.template_spool_ref.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.pool_id</code>. 
	 */
	public void setPoolId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.pool_id</code>. 
	 */
	@javax.persistence.Column(name = "pool_id", nullable = false, precision = 20)
	public java.lang.Long getPoolId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.template_id</code>. 
	 */
	public void setTemplateId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.template_id</code>. 
	 */
	@javax.persistence.Column(name = "template_id", nullable = false, precision = 20)
	public java.lang.Long getTemplateId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.created</code>. 
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.created</code>. 
	 */
	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.last_updated</code>. 
	 */
	public void setLastUpdated(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.last_updated</code>. 
	 */
	@javax.persistence.Column(name = "last_updated")
	public java.sql.Timestamp getLastUpdated() {
		return (java.sql.Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.job_id</code>. 
	 */
	public void setJobId(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.job_id</code>. 
	 */
	@javax.persistence.Column(name = "job_id", length = 255)
	public java.lang.String getJobId() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.download_pct</code>. 
	 */
	public void setDownloadPct(java.lang.Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.download_pct</code>. 
	 */
	@javax.persistence.Column(name = "download_pct", precision = 10)
	public java.lang.Integer getDownloadPct() {
		return (java.lang.Integer) getValue(6);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.download_state</code>. 
	 */
	public void setDownloadState(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.download_state</code>. 
	 */
	@javax.persistence.Column(name = "download_state", length = 255)
	public java.lang.String getDownloadState() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.error_str</code>. 
	 */
	public void setErrorStr(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.error_str</code>. 
	 */
	@javax.persistence.Column(name = "error_str", length = 255)
	public java.lang.String getErrorStr() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.local_path</code>. 
	 */
	public void setLocalPath(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.local_path</code>. 
	 */
	@javax.persistence.Column(name = "local_path", length = 255)
	public java.lang.String getLocalPath() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.install_path</code>. 
	 */
	public void setInstallPath(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.install_path</code>. 
	 */
	@javax.persistence.Column(name = "install_path", length = 255)
	public java.lang.String getInstallPath() {
		return (java.lang.String) getValue(10);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.template_size</code>. the size of the template on the pool
	 */
	public void setTemplateSize(java.lang.Long value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.template_size</code>. the size of the template on the pool
	 */
	@javax.persistence.Column(name = "template_size", nullable = false, precision = 20)
	public java.lang.Long getTemplateSize() {
		return (java.lang.Long) getValue(11);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.marked_for_gc</code>. if true, the garbage collector will evict the template from this pool.
	 */
	public void setMarkedForGc(java.lang.Byte value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.marked_for_gc</code>. if true, the garbage collector will evict the template from this pool.
	 */
	@javax.persistence.Column(name = "marked_for_gc", nullable = false, precision = 3)
	public java.lang.Byte getMarkedForGc() {
		return (java.lang.Byte) getValue(12);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.state</code>. 
	 */
	public void setState(java.lang.String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.state</code>. 
	 */
	@javax.persistence.Column(name = "state", length = 255)
	public java.lang.String getState() {
		return (java.lang.String) getValue(13);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.update_count</code>. 
	 */
	public void setUpdateCount(java.lang.Long value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.update_count</code>. 
	 */
	@javax.persistence.Column(name = "update_count", precision = 20)
	public java.lang.Long getUpdateCount() {
		return (java.lang.Long) getValue(14);
	}

	/**
	 * Setter for <code>cloud.template_spool_ref.updated</code>. 
	 */
	public void setUpdated(java.sql.Timestamp value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.template_spool_ref.updated</code>. 
	 */
	@javax.persistence.Column(name = "updated")
	public java.sql.Timestamp getUpdated() {
		return (java.sql.Timestamp) getValue(15);
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
	// Record16 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row16<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Byte, java.lang.String, java.lang.Long, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row16) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row16<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Byte, java.lang.String, java.lang.Long, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row16) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.POOL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.TEMPLATE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.LAST_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.JOB_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.DOWNLOAD_PCT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field8() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.DOWNLOAD_STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.ERROR_STR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field10() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.LOCAL_PATH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field11() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.INSTALL_PATH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field12() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.TEMPLATE_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field13() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.MARKED_FOR_GC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field14() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field15() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.UPDATE_COUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field16() {
		return org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF.UPDATED;
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
	public java.lang.Long value3() {
		return getTemplateId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value4() {
		return getCreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value5() {
		return getLastUpdated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getJobId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value7() {
		return getDownloadPct();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value8() {
		return getDownloadState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value9() {
		return getErrorStr();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value10() {
		return getLocalPath();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value11() {
		return getInstallPath();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value12() {
		return getTemplateSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value13() {
		return getMarkedForGc();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value14() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value15() {
		return getUpdateCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value16() {
		return getUpdated();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TemplateSpoolRefRecord
	 */
	public TemplateSpoolRefRecord() {
		super(org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF);
	}

	/**
	 * Create a detached, initialised TemplateSpoolRefRecord
	 */
	public TemplateSpoolRefRecord(java.lang.Long id, java.lang.Long poolId, java.lang.Long templateId, java.sql.Timestamp created, java.sql.Timestamp lastUpdated, java.lang.String jobId, java.lang.Integer downloadPct, java.lang.String downloadState, java.lang.String errorStr, java.lang.String localPath, java.lang.String installPath, java.lang.Long templateSize, java.lang.Byte markedForGc, java.lang.String state, java.lang.Long updateCount, java.sql.Timestamp updated) {
		super(org.apache.cloudstack.db.jooq.tables.TemplateSpoolRef.TEMPLATE_SPOOL_REF);

		setValue(0, id);
		setValue(1, poolId);
		setValue(2, templateId);
		setValue(3, created);
		setValue(4, lastUpdated);
		setValue(5, jobId);
		setValue(6, downloadPct);
		setValue(7, downloadState);
		setValue(8, errorStr);
		setValue(9, localPath);
		setValue(10, installPath);
		setValue(11, templateSize);
		setValue(12, markedForGc);
		setValue(13, state);
		setValue(14, updateCount);
		setValue(15, updated);
	}
}
