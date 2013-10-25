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
public class DataCenter extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord> {

	private static final long serialVersionUID = 1657093285;

	/**
	 * The singleton instance of <code>cloud.data_center</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.DataCenter DATA_CENTER = new org.apache.cloudstack.db.jooq.tables.DataCenter();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord.class;
	}

	/**
	 * The column <code>cloud.data_center.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.data_center.name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.data_center.description</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.dns1</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DNS1 = createField("dns1", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.data_center.dns2</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DNS2 = createField("dns2", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.internal_dns1</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> INTERNAL_DNS1 = createField("internal_dns1", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.data_center.internal_dns2</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> INTERNAL_DNS2 = createField("internal_dns2", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.gateway</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> GATEWAY = createField("gateway", org.jooq.impl.SQLDataType.VARCHAR.length(15), this);

	/**
	 * The column <code>cloud.data_center.netmask</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> NETMASK = createField("netmask", org.jooq.impl.SQLDataType.VARCHAR.length(15), this);

	/**
	 * The column <code>cloud.data_center.router_mac_address</code>. mac address for the router within the domain
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> ROUTER_MAC_ADDRESS = createField("router_mac_address", org.jooq.impl.SQLDataType.VARCHAR.length(17).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.mac_address</code>. Next available mac address for the ethernet card interacting with public internet
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Long> MAC_ADDRESS = createField("mac_address", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.guest_network_cidr</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> GUEST_NETWORK_CIDR = createField("guest_network_cidr", org.jooq.impl.SQLDataType.VARCHAR.length(18), this);

	/**
	 * The column <code>cloud.data_center.domain</code>. Network domain name of the Vms of the zone
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DOMAIN = createField("domain", org.jooq.impl.SQLDataType.VARCHAR.length(100), this);

	/**
	 * The column <code>cloud.data_center.domain_id</code>. domain id for the parent domain to this zone (null signifies public zone)
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.data_center.networktype</code>. Network type of the zone
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> NETWORKTYPE = createField("networktype", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.dns_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DNS_PROVIDER = createField("dns_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.gateway_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> GATEWAY_PROVIDER = createField("gateway_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.firewall_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> FIREWALL_PROVIDER = createField("firewall_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.dhcp_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> DHCP_PROVIDER = createField("dhcp_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.lb_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> LB_PROVIDER = createField("lb_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.vpn_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> VPN_PROVIDER = createField("vpn_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.userdata_provider</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> USERDATA_PROVIDER = createField("userdata_provider", org.jooq.impl.SQLDataType.CHAR.length(64).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.allocation_state</code>. Is this data center enabled for allocation for new resources
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> ALLOCATION_STATE = createField("allocation_state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.zone_token</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> ZONE_TOKEN = createField("zone_token", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.is_security_group_enabled</code>. 1: enabled, 0: not
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Byte> IS_SECURITY_GROUP_ENABLED = createField("is_security_group_enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.is_local_storage_enabled</code>. Is local storage offering enabled for this data center; 1: enabled, 0: not
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Byte> IS_LOCAL_STORAGE_ENABLED = createField("is_local_storage_enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.data_center.owner</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> OWNER = createField("owner", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.created</code>. date created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.data_center.lastUpdated</code>. last updated
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.sql.Timestamp> LASTUPDATED = createField("lastUpdated", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.data_center.engine_state</code>. the engine state of the zone
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> ENGINE_STATE = createField("engine_state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.data_center.ip6_dns1</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> IP6_DNS1 = createField("ip6_dns1", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.data_center.ip6_dns2</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.String> IP6_DNS2 = createField("ip6_dns2", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * Create a <code>cloud.data_center</code> table reference
	 */
	public DataCenter() {
		super("data_center", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.data_center</code> table reference
	 */
	public DataCenter(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.DataCenter.DATA_CENTER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_DATA_CENTER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_DATA_CENTER_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_DATA_CENTER_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_DATA_CENTER_ID, org.apache.cloudstack.db.jooq.Keys.KEY_DATA_CENTER_UC_DATA_CENTER__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.DataCenterRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_DATA_CENTER__DOMAIN_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.DataCenter as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.DataCenter(alias);
	}
}
