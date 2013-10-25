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
public class S2sVpnGateway extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord> {

	private static final long serialVersionUID = -2119119705;

	/**
	 * The singleton instance of <code>cloud.s2s_vpn_gateway</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.S2sVpnGateway S2S_VPN_GATEWAY = new org.apache.cloudstack.db.jooq.tables.S2sVpnGateway();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord.class;
	}

	/**
	 * The column <code>cloud.s2s_vpn_gateway.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.addr_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> ADDR_ID = createField("addr_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.vpc_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> VPC_ID = createField("vpc_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_gateway.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * Create a <code>cloud.s2s_vpn_gateway</code> table reference
	 */
	public S2sVpnGateway() {
		super("s2s_vpn_gateway", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.s2s_vpn_gateway</code> table reference
	 */
	public S2sVpnGateway(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.S2sVpnGateway.S2S_VPN_GATEWAY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_S2S_VPN_GATEWAY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_GATEWAY_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_GATEWAY_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_GATEWAY_UC_S2S_VPN_GATEWAY__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnGatewayRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_GATEWAY__ADDR_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_GATEWAY__VPC_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_GATEWAY__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_GATEWAY__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.S2sVpnGateway as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.S2sVpnGateway(alias);
	}
}
