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
public class InlineLoadBalancerNicMap extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord> {

	private static final long serialVersionUID = -1991472542;

	/**
	 * The singleton instance of <code>cloud.inline_load_balancer_nic_map</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.InlineLoadBalancerNicMap INLINE_LOAD_BALANCER_NIC_MAP = new org.apache.cloudstack.db.jooq.tables.InlineLoadBalancerNicMap();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord.class;
	}

	/**
	 * The column <code>cloud.inline_load_balancer_nic_map.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.inline_load_balancer_nic_map.public_ip_address</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, java.lang.String> PUBLIC_IP_ADDRESS = createField("public_ip_address", org.jooq.impl.SQLDataType.CHAR.length(40).nullable(false), this);

	/**
	 * The column <code>cloud.inline_load_balancer_nic_map.nic_id</code>. nic id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, java.lang.Long> NIC_ID = createField("nic_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * Create a <code>cloud.inline_load_balancer_nic_map</code> table reference
	 */
	public InlineLoadBalancerNicMap() {
		super("inline_load_balancer_nic_map", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.inline_load_balancer_nic_map</code> table reference
	 */
	public InlineLoadBalancerNicMap(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.InlineLoadBalancerNicMap.INLINE_LOAD_BALANCER_NIC_MAP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_INLINE_LOAD_BALANCER_NIC_MAP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_INLINE_LOAD_BALANCER_NIC_MAP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_INLINE_LOAD_BALANCER_NIC_MAP_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_INLINE_LOAD_BALANCER_NIC_MAP_NIC_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.InlineLoadBalancerNicMapRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_INLINE_LOAD_BALANCER_NIC_MAP__NIC_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.InlineLoadBalancerNicMap as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.InlineLoadBalancerNicMap(alias);
	}
}
