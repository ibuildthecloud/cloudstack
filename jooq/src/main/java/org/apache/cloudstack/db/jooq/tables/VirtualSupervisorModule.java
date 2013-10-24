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
public class VirtualSupervisorModule extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord> {

	private static final long serialVersionUID = -1891863348;

	/**
	 * The singleton instance of <code>cloud.virtual_supervisor_module</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.VirtualSupervisorModule VIRTUAL_SUPERVISOR_MODULE = new org.apache.cloudstack.db.jooq.tables.VirtualSupervisorModule();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord.class;
	}

	/**
	 * The column <code>cloud.virtual_supervisor_module.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.host_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Long> HOST_ID = createField("host_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.vsm_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> VSM_NAME = createField("vsm_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.username</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.password</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.ipaddr</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> IPADDR = createField("ipaddr", org.jooq.impl.SQLDataType.VARCHAR.length(80).nullable(false), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.management_vlan</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Integer> MANAGEMENT_VLAN = createField("management_vlan", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.control_vlan</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Integer> CONTROL_VLAN = createField("control_vlan", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.packet_vlan</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Integer> PACKET_VLAN = createField("packet_vlan", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.storage_vlan</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Integer> STORAGE_VLAN = createField("storage_vlan", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.vsm_domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Long> VSM_DOMAIN_ID = createField("vsm_domain_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.config_mode</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> CONFIG_MODE = createField("config_mode", org.jooq.impl.SQLDataType.VARCHAR.length(20), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.config_state</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> CONFIG_STATE = createField("config_state", org.jooq.impl.SQLDataType.VARCHAR.length(20), this);

	/**
	 * The column <code>cloud.virtual_supervisor_module.vsm_device_state</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.String> VSM_DEVICE_STATE = createField("vsm_device_state", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this);

	/**
	 * Create a <code>cloud.virtual_supervisor_module</code> table reference
	 */
	public VirtualSupervisorModule() {
		super("virtual_supervisor_module", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.virtual_supervisor_module</code> table reference
	 */
	public VirtualSupervisorModule(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.VirtualSupervisorModule.VIRTUAL_SUPERVISOR_MODULE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_VIRTUAL_SUPERVISOR_MODULE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_VIRTUAL_SUPERVISOR_MODULE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VirtualSupervisorModuleRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_VIRTUAL_SUPERVISOR_MODULE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.VirtualSupervisorModule as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.VirtualSupervisorModule(alias);
	}
}
