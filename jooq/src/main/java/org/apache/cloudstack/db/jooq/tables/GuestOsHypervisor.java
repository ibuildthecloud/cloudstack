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
public class GuestOsHypervisor extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord> {

	private static final long serialVersionUID = 447129123;

	/**
	 * The singleton instance of <code>cloud.guest_os_hypervisor</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.GuestOsHypervisor GUEST_OS_HYPERVISOR = new org.apache.cloudstack.db.jooq.tables.GuestOsHypervisor();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord.class;
	}

	/**
	 * The column <code>cloud.guest_os_hypervisor.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.guest_os_hypervisor.hypervisor_type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord, java.lang.String> HYPERVISOR_TYPE = createField("hypervisor_type", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.guest_os_hypervisor.guest_os_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord, java.lang.String> GUEST_OS_NAME = createField("guest_os_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.guest_os_hypervisor.guest_os_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord, java.lang.Long> GUEST_OS_ID = createField("guest_os_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * Create a <code>cloud.guest_os_hypervisor</code> table reference
	 */
	public GuestOsHypervisor() {
		super("guest_os_hypervisor", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.guest_os_hypervisor</code> table reference
	 */
	public GuestOsHypervisor(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.GuestOsHypervisor.GUEST_OS_HYPERVISOR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_GUEST_OS_HYPERVISOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_GUEST_OS_HYPERVISOR_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.GuestOsHypervisorRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_GUEST_OS_HYPERVISOR_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.GuestOsHypervisor as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.GuestOsHypervisor(alias);
	}
}
