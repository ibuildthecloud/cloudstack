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
public class NetscalerPodRef extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord> {

	private static final long serialVersionUID = 1761945412;

	/**
	 * The singleton instance of <code>cloud.netscaler_pod_ref</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.NetscalerPodRef NETSCALER_POD_REF = new org.apache.cloudstack.db.jooq.tables.NetscalerPodRef();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord.class;
	}

	/**
	 * The column <code>cloud.netscaler_pod_ref.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.netscaler_pod_ref.external_load_balancer_device_id</code>. id of external load balancer device
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, java.lang.Long> EXTERNAL_LOAD_BALANCER_DEVICE_ID = createField("external_load_balancer_device_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.netscaler_pod_ref.pod_id</code>. pod id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, java.lang.Long> POD_ID = createField("pod_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * Create a <code>cloud.netscaler_pod_ref</code> table reference
	 */
	public NetscalerPodRef() {
		super("netscaler_pod_ref", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.netscaler_pod_ref</code> table reference
	 */
	public NetscalerPodRef(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_NETSCALER_POD_REF;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_NETSCALER_POD_REF_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_NETSCALER_POD_REF_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_NS_POD_REF__DEVICE_ID, org.apache.cloudstack.db.jooq.Keys.FK_NS_POD_REF__POD_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.NetscalerPodRef as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.NetscalerPodRef(alias);
	}
}
