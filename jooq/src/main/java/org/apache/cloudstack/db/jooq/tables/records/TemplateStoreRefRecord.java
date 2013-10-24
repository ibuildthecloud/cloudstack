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
@javax.persistence.Table(name = "template_store_ref", schema = "cloud")
public class TemplateStoreRefRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.TemplateStoreRefRecord> implements org.jooq.Record21<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Byte, java.lang.Byte, java.lang.Long, java.lang.Long, java.sql.Timestamp> {

	private static final long serialVersionUID = 948118748;

	/**
	 * Setter for <code>cloud.template_store_ref.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.store_id</code>. 
	 */
	public void setStoreId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.store_id</code>. 
	 */
	@javax.persistence.Column(name = "store_id", precision = 20)
	public java.lang.Long getStoreId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.template_id</code>. 
	 */
	public void setTemplateId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.template_id</code>. 
	 */
	@javax.persistence.Column(name = "template_id", nullable = false, precision = 20)
	public java.lang.Long getTemplateId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.created</code>. 
	 */
	public void setCreated(java.sql.Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.created</code>. 
	 */
	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return (java.sql.Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.last_updated</code>. 
	 */
	public void setLastUpdated(java.sql.Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.last_updated</code>. 
	 */
	@javax.persistence.Column(name = "last_updated")
	public java.sql.Timestamp getLastUpdated() {
		return (java.sql.Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.job_id</code>. 
	 */
	public void setJobId(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.job_id</code>. 
	 */
	@javax.persistence.Column(name = "job_id", length = 255)
	public java.lang.String getJobId() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.download_pct</code>. 
	 */
	public void setDownloadPct(java.lang.Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.download_pct</code>. 
	 */
	@javax.persistence.Column(name = "download_pct", precision = 10)
	public java.lang.Integer getDownloadPct() {
		return (java.lang.Integer) getValue(6);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.size</code>. 
	 */
	public void setSize(java.lang.Long value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.size</code>. 
	 */
	@javax.persistence.Column(name = "size", precision = 20)
	public java.lang.Long getSize() {
		return (java.lang.Long) getValue(7);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.store_role</code>. 
	 */
	public void setStoreRole(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.store_role</code>. 
	 */
	@javax.persistence.Column(name = "store_role", length = 255)
	public java.lang.String getStoreRole() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.physical_size</code>. 
	 */
	public void setPhysicalSize(java.lang.Long value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.physical_size</code>. 
	 */
	@javax.persistence.Column(name = "physical_size", precision = 20)
	public java.lang.Long getPhysicalSize() {
		return (java.lang.Long) getValue(9);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.download_state</code>. 
	 */
	public void setDownloadState(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.download_state</code>. 
	 */
	@javax.persistence.Column(name = "download_state", length = 255)
	public java.lang.String getDownloadState() {
		return (java.lang.String) getValue(10);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.error_str</code>. 
	 */
	public void setErrorStr(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.error_str</code>. 
	 */
	@javax.persistence.Column(name = "error_str", length = 255)
	public java.lang.String getErrorStr() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.local_path</code>. 
	 */
	public void setLocalPath(java.lang.String value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.local_path</code>. 
	 */
	@javax.persistence.Column(name = "local_path", length = 255)
	public java.lang.String getLocalPath() {
		return (java.lang.String) getValue(12);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.install_path</code>. 
	 */
	public void setInstallPath(java.lang.String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.install_path</code>. 
	 */
	@javax.persistence.Column(name = "install_path", length = 255)
	public java.lang.String getInstallPath() {
		return (java.lang.String) getValue(13);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.url</code>. 
	 */
	public void setUrl(java.lang.String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.url</code>. 
	 */
	@javax.persistence.Column(name = "url", length = 255)
	public java.lang.String getUrl() {
		return (java.lang.String) getValue(14);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.state</code>. 
	 */
	public void setState(java.lang.String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.state</code>. 
	 */
	@javax.persistence.Column(name = "state", nullable = false, length = 255)
	public java.lang.String getState() {
		return (java.lang.String) getValue(15);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.destroyed</code>. indicates whether the template_store entry was destroyed by the user or not
	 */
	public void setDestroyed(java.lang.Byte value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.destroyed</code>. indicates whether the template_store entry was destroyed by the user or not
	 */
	@javax.persistence.Column(name = "destroyed", precision = 3)
	public java.lang.Byte getDestroyed() {
		return (java.lang.Byte) getValue(16);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.is_copy</code>. indicates whether this was copied 
	 */
	public void setIsCopy(java.lang.Byte value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.is_copy</code>. indicates whether this was copied 
	 */
	@javax.persistence.Column(name = "is_copy", nullable = false, precision = 3)
	public java.lang.Byte getIsCopy() {
		return (java.lang.Byte) getValue(17);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.update_count</code>. 
	 */
	public void setUpdateCount(java.lang.Long value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.update_count</code>. 
	 */
	@javax.persistence.Column(name = "update_count", precision = 20)
	public java.lang.Long getUpdateCount() {
		return (java.lang.Long) getValue(18);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.ref_cnt</code>. 
	 */
	public void setRefCnt(java.lang.Long value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.ref_cnt</code>. 
	 */
	@javax.persistence.Column(name = "ref_cnt", precision = 20)
	public java.lang.Long getRefCnt() {
		return (java.lang.Long) getValue(19);
	}

	/**
	 * Setter for <code>cloud.template_store_ref.updated</code>. 
	 */
	public void setUpdated(java.sql.Timestamp value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>cloud.template_store_ref.updated</code>. 
	 */
	@javax.persistence.Column(name = "updated")
	public java.sql.Timestamp getUpdated() {
		return (java.sql.Timestamp) getValue(20);
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
	// Record21 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row21<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Byte, java.lang.Byte, java.lang.Long, java.lang.Long, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row21) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row21<java.lang.Long, java.lang.Long, java.lang.Long, java.sql.Timestamp, java.sql.Timestamp, java.lang.String, java.lang.Integer, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Byte, java.lang.Byte, java.lang.Long, java.lang.Long, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row21) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.STORE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.TEMPLATE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field4() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.CREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field5() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.LAST_UPDATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.JOB_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field7() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.DOWNLOAD_PCT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field8() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.STORE_ROLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field10() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.PHYSICAL_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field11() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.DOWNLOAD_STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field12() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.ERROR_STR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field13() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.LOCAL_PATH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field14() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.INSTALL_PATH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field15() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field16() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field17() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.DESTROYED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field18() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.IS_COPY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field19() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.UPDATE_COUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field20() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.REF_CNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field21() {
		return org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF.UPDATED;
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
		return getStoreId();
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
	public java.lang.Long value8() {
		return getSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value9() {
		return getStoreRole();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value10() {
		return getPhysicalSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value11() {
		return getDownloadState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value12() {
		return getErrorStr();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value13() {
		return getLocalPath();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value14() {
		return getInstallPath();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value15() {
		return getUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value16() {
		return getState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value17() {
		return getDestroyed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value18() {
		return getIsCopy();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value19() {
		return getUpdateCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value20() {
		return getRefCnt();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value21() {
		return getUpdated();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TemplateStoreRefRecord
	 */
	public TemplateStoreRefRecord() {
		super(org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF);
	}

	/**
	 * Create a detached, initialised TemplateStoreRefRecord
	 */
	public TemplateStoreRefRecord(java.lang.Long id, java.lang.Long storeId, java.lang.Long templateId, java.sql.Timestamp created, java.sql.Timestamp lastUpdated, java.lang.String jobId, java.lang.Integer downloadPct, java.lang.Long size, java.lang.String storeRole, java.lang.Long physicalSize, java.lang.String downloadState, java.lang.String errorStr, java.lang.String localPath, java.lang.String installPath, java.lang.String url, java.lang.String state, java.lang.Byte destroyed, java.lang.Byte isCopy, java.lang.Long updateCount, java.lang.Long refCnt, java.sql.Timestamp updated) {
		super(org.apache.cloudstack.db.jooq.tables.TemplateStoreRef.TEMPLATE_STORE_REF);

		setValue(0, id);
		setValue(1, storeId);
		setValue(2, templateId);
		setValue(3, created);
		setValue(4, lastUpdated);
		setValue(5, jobId);
		setValue(6, downloadPct);
		setValue(7, size);
		setValue(8, storeRole);
		setValue(9, physicalSize);
		setValue(10, downloadState);
		setValue(11, errorStr);
		setValue(12, localPath);
		setValue(13, installPath);
		setValue(14, url);
		setValue(15, state);
		setValue(16, destroyed);
		setValue(17, isCopy);
		setValue(18, updateCount);
		setValue(19, refCnt);
		setValue(20, updated);
	}
}
