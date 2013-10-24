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
public class S2sVpnConnection extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord> {

	private static final long serialVersionUID = -1051480210;

	/**
	 * The singleton instance of <code>cloud.s2s_vpn_connection</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.S2sVpnConnection S2S_VPN_CONNECTION = new org.apache.cloudstack.db.jooq.tables.S2sVpnConnection();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord.class;
	}

	/**
	 * The column <code>cloud.s2s_vpn_connection.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.vpn_gateway_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> VPN_GATEWAY_ID = createField("vpn_gateway_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.customer_gateway_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> CUSTOMER_GATEWAY_ID = createField("customer_gateway_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.state</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.created</code>. date created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this);

	/**
	 * The column <code>cloud.s2s_vpn_connection.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * Create a <code>cloud.s2s_vpn_connection</code> table reference
	 */
	public S2sVpnConnection() {
		super("s2s_vpn_connection", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.s2s_vpn_connection</code> table reference
	 */
	public S2sVpnConnection(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.S2sVpnConnection.S2S_VPN_CONNECTION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_S2S_VPN_CONNECTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_CONNECTION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_CONNECTION_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_S2S_VPN_CONNECTION_UC_S2S_VPN_CONNECTION__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.S2sVpnConnectionRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_CONNECTION__VPN_GATEWAY_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_CONNECTION__CUSTOMER_GATEWAY_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_CONNECTION__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_S2S_VPN_CONNECTION__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.S2sVpnConnection as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.S2sVpnConnection(alias);
	}
}
