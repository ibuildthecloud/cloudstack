/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HypervisorCapabilities extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord> {

	private static final long serialVersionUID = 1510750880;

	/**
	 * The singleton instance of <code>cloud.hypervisor_capabilities</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.HypervisorCapabilities HYPERVISOR_CAPABILITIES = new org.apache.cloudstack.db.jooq.tables.HypervisorCapabilities();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord.class;
	}

	/**
	 * The column <code>cloud.hypervisor_capabilities.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.hypervisor_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.String> HYPERVISOR_TYPE = createField("hypervisor_type", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.hypervisor_version</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.String> HYPERVISOR_VERSION = createField("hypervisor_version", org.jooq.impl.SQLDataType.VARCHAR.length(32), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.max_guests_limit</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Long> MAX_GUESTS_LIMIT = createField("max_guests_limit", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.security_group_enabled</code>. Is security group supported
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Integer> SECURITY_GROUP_ENABLED = createField("security_group_enabled", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.max_data_volumes_limit</code>. Max. data volumes per VM supported by hypervisor
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Integer> MAX_DATA_VOLUMES_LIMIT = createField("max_data_volumes_limit", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.max_hosts_per_cluster</code>. Max. hosts in cluster supported by hypervisor
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Integer> MAX_HOSTS_PER_CLUSTER = createField("max_hosts_per_cluster", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.storage_motion_supported</code>. Is storage motion supported
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Integer> STORAGE_MOTION_SUPPORTED = createField("storage_motion_supported", org.jooq.impl.SQLDataType.INTEGER.defaulted(true), this);

	/**
	 * The column <code>cloud.hypervisor_capabilities.vm_snapshot_enabled</code>. Whether VM snapshot is supported by hypervisor
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Byte> VM_SNAPSHOT_ENABLED = createField("vm_snapshot_enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this);

	/**
	 * Create a <code>cloud.hypervisor_capabilities</code> table reference
	 */
	public HypervisorCapabilities() {
		super("hypervisor_capabilities", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.hypervisor_capabilities</code> table reference
	 */
	public HypervisorCapabilities(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.HypervisorCapabilities.HYPERVISOR_CAPABILITIES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_HYPERVISOR_CAPABILITIES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_HYPERVISOR_CAPABILITIES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HypervisorCapabilitiesRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_HYPERVISOR_CAPABILITIES_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_HYPERVISOR_CAPABILITIES_UC_HYPERVISOR_CAPABILITIES__UUID, org.apache.cloudstack.db.jooq.Keys.KEY_HYPERVISOR_CAPABILITIES_UC_HYPERVISOR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.HypervisorCapabilities as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.HypervisorCapabilities(alias);
	}
}
