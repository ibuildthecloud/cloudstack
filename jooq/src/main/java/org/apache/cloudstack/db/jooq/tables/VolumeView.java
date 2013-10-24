/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VolumeView extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord> {

	private static final long serialVersionUID = -874071590;

	/**
	 * The singleton instance of <code>cloud.volume_view</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.VolumeView VOLUME_VIEW = new org.apache.cloudstack.db.jooq.tables.VolumeView();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord.class;
	}

	/**
	 * The column <code>cloud.volume_view.id</code>. Primary Key
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.name</code>. A user specified name for the volume
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.device_id</code>. which device inside vm instance it is 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> DEVICE_ID = createField("device_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.volume_type</code>. root, swap or data
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VOLUME_TYPE = createField("volume_type", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this);

	/**
	 * The column <code>cloud.volume_view.size</code>. total size
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> SIZE = createField("size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.volume_view.min_iops</code>. Minimum IOPS
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> MIN_IOPS = createField("min_iops", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.max_iops</code>. Maximum IOPS
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> MAX_IOPS = createField("max_iops", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.created</code>. Date Created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.volume_view.state</code>. State machine
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.volume_view.attached</code>. Date Attached
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.sql.Timestamp> ATTACHED = createField("attached", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.volume_view.removed</code>. Date removed.  not null if removed
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.volume_view.pod_id</code>. pod this volume belongs to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> POD_ID = createField("pod_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.display_volume</code>. Should volume be displayed to the end user
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Byte> DISPLAY_VOLUME = createField("display_volume", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.format</code>. volume format
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> FORMAT = createField("format", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.path</code>. Path
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> PATH = createField("path", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.account_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> ACCOUNT_UUID = createField("account_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.account_name</code>. an account name set by the creator of the account, defaults to username for single accounts
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> ACCOUNT_NAME = createField("account_name", org.jooq.impl.SQLDataType.VARCHAR.length(100), this);

	/**
	 * The column <code>cloud.volume_view.account_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Integer> ACCOUNT_TYPE = createField("account_type", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this);

	/**
	 * The column <code>cloud.volume_view.domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.domain_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DOMAIN_UUID = createField("domain_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.domain_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DOMAIN_NAME = createField("domain_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.domain_path</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DOMAIN_PATH = createField("domain_path", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.volume_view.project_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> PROJECT_ID = createField("project_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.project_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> PROJECT_UUID = createField("project_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.project_name</code>. project name
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> PROJECT_NAME = createField("project_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.data_center_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> DATA_CENTER_ID = createField("data_center_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.data_center_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DATA_CENTER_UUID = createField("data_center_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.data_center_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DATA_CENTER_NAME = createField("data_center_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.data_center_type</code>. Network type of the zone
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DATA_CENTER_TYPE = createField("data_center_type", org.jooq.impl.SQLDataType.VARCHAR.length(255).defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.vm_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> VM_ID = createField("vm_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.vm_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VM_UUID = createField("vm_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.vm_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VM_NAME = createField("vm_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.vm_state</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VM_STATE = createField("vm_state", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.volume_view.vm_type</code>. vm type
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VM_TYPE = createField("vm_type", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.volume_view.vm_display_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> VM_DISPLAY_NAME = createField("vm_display_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.volume_store_size</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> VOLUME_STORE_SIZE = createField("volume_store_size", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.download_pct</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Integer> DOWNLOAD_PCT = createField("download_pct", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.volume_view.download_state</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DOWNLOAD_STATE = createField("download_state", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.error_str</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> ERROR_STR = createField("error_str", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.created_on_store</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.sql.Timestamp> CREATED_ON_STORE = createField("created_on_store", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.volume_view.disk_offering_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> DISK_OFFERING_ID = createField("disk_offering_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.disk_offering_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DISK_OFFERING_UUID = createField("disk_offering_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.disk_offering_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DISK_OFFERING_NAME = createField("disk_offering_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.disk_offering_display_text</code>. Descrianaption text set by the admin for display purpose only
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> DISK_OFFERING_DISPLAY_TEXT = createField("disk_offering_display_text", org.jooq.impl.SQLDataType.VARCHAR.length(4096), this);

	/**
	 * The column <code>cloud.volume_view.use_local_storage</code>. Indicates whether local storage pools should be used
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Byte> USE_LOCAL_STORAGE = createField("use_local_storage", org.jooq.impl.SQLDataType.TINYINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.system_use</code>. is this offering for system used only
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Byte> SYSTEM_USE = createField("system_use", org.jooq.impl.SQLDataType.TINYINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.bytes_read_rate</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> BYTES_READ_RATE = createField("bytes_read_rate", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.bytes_write_rate</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> BYTES_WRITE_RATE = createField("bytes_write_rate", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.iops_read_rate</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> IOPS_READ_RATE = createField("iops_read_rate", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.iops_write_rate</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> IOPS_WRITE_RATE = createField("iops_write_rate", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.pool_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> POOL_ID = createField("pool_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.pool_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> POOL_UUID = createField("pool_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.pool_name</code>. should be NOT NULL
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> POOL_NAME = createField("pool_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.hypervisor_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> HYPERVISOR_TYPE = createField("hypervisor_type", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.volume_view.template_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> TEMPLATE_ID = createField("template_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.template_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TEMPLATE_UUID = createField("template_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.extractable</code>. Is this template extractable
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Integer> EXTRACTABLE = createField("extractable", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.template_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TEMPLATE_TYPE = createField("template_type", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.volume_view.tag_id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> TAG_ID = createField("tag_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.tag_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_UUID = createField("tag_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.tag_key</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_KEY = createField("tag_key", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.tag_value</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_VALUE = createField("tag_value", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.tag_domain_id</code>. foreign key to domain id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> TAG_DOMAIN_ID = createField("tag_domain_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.tag_account_id</code>. owner of this network
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> TAG_ACCOUNT_ID = createField("tag_account_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.tag_resource_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> TAG_RESOURCE_ID = createField("tag_resource_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.volume_view.tag_resource_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_RESOURCE_UUID = createField("tag_resource_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.tag_resource_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_RESOURCE_TYPE = createField("tag_resource_type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.tag_customer</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> TAG_CUSTOMER = createField("tag_customer", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.volume_view.job_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> JOB_ID = createField("job_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.volume_view.job_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.String> JOB_UUID = createField("job_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.volume_view.job_status</code>. general job execution status
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Integer> JOB_STATUS = createField("job_status", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.volume_view.job_account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VolumeViewRecord, java.lang.Long> JOB_ACCOUNT_ID = createField("job_account_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * Create a <code>cloud.volume_view</code> table reference
	 */
	public VolumeView() {
		super("volume_view", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.volume_view</code> table reference
	 */
	public VolumeView(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.VolumeView.VOLUME_VIEW);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.VolumeView as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.VolumeView(alias);
	}
}
