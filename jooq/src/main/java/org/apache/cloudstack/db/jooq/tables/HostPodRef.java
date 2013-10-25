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
public class HostPodRef extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord> {

	private static final long serialVersionUID = -1062177213;

	/**
	 * The singleton instance of <code>cloud.host_pod_ref</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.HostPodRef HOST_POD_REF = new org.apache.cloudstack.db.jooq.tables.HostPodRef();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord.class;
	}

	/**
	 * The column <code>cloud.host_pod_ref.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.host_pod_ref.name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.host_pod_ref.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.host_pod_ref.data_center_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.Long> DATA_CENTER_ID = createField("data_center_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.host_pod_ref.gateway</code>. gateway for the pod
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> GATEWAY = createField("gateway", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.host_pod_ref.cidr_address</code>. CIDR address for the pod
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> CIDR_ADDRESS = createField("cidr_address", org.jooq.impl.SQLDataType.VARCHAR.length(15).nullable(false), this);

	/**
	 * The column <code>cloud.host_pod_ref.cidr_size</code>. CIDR size for the pod
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.Long> CIDR_SIZE = createField("cidr_size", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.host_pod_ref.description</code>. store private ip range in startIP-endIP format
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.host_pod_ref.allocation_state</code>. Is this Pod enabled for allocation for new resources
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> ALLOCATION_STATE = createField("allocation_state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.host_pod_ref.external_dhcp</code>. Is this Pod using external DHCP
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.Byte> EXTERNAL_DHCP = createField("external_dhcp", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.host_pod_ref.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.host_pod_ref.owner</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> OWNER = createField("owner", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.host_pod_ref.created</code>. date created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.host_pod_ref.lastUpdated</code>. last updated
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.sql.Timestamp> LASTUPDATED = createField("lastUpdated", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.host_pod_ref.engine_state</code>. the engine state of the zone
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.String> ENGINE_STATE = createField("engine_state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaulted(true), this);

	/**
	 * Create a <code>cloud.host_pod_ref</code> table reference
	 */
	public HostPodRef() {
		super("host_pod_ref", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.host_pod_ref</code> table reference
	 */
	public HostPodRef(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.HostPodRef.HOST_POD_REF);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_HOST_POD_REF;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_HOST_POD_REF_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.HostPodRefRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_HOST_POD_REF_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_HOST_POD_REF_ID, org.apache.cloudstack.db.jooq.Keys.KEY_HOST_POD_REF_NAME, org.apache.cloudstack.db.jooq.Keys.KEY_HOST_POD_REF_UC_HOST_POD_REF__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.HostPodRef as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.HostPodRef(alias);
	}
}
