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
public class NetworkExternalFirewallDeviceMap extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord> {

	private static final long serialVersionUID = 956000421;

	/**
	 * The singleton instance of <code>cloud.network_external_firewall_device_map</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.NetworkExternalFirewallDeviceMap NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP = new org.apache.cloudstack.db.jooq.tables.NetworkExternalFirewallDeviceMap();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord.class;
	}

	/**
	 * The column <code>cloud.network_external_firewall_device_map.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.network_external_firewall_device_map.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.network_external_firewall_device_map.network_id</code>.  guest network id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.lang.Long> NETWORK_ID = createField("network_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.network_external_firewall_device_map.external_firewall_device_id</code>. id of external firewall device assigned for this device
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.lang.Long> EXTERNAL_FIREWALL_DEVICE_ID = createField("external_firewall_device_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.network_external_firewall_device_map.created</code>. Date from when network started using the device
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.network_external_firewall_device_map.removed</code>. Date till the network stopped using the device 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * Create a <code>cloud.network_external_firewall_device_map</code> table reference
	 */
	public NetworkExternalFirewallDeviceMap() {
		super("network_external_firewall_device_map", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.network_external_firewall_device_map</code> table reference
	 */
	public NetworkExternalFirewallDeviceMap(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.NetworkExternalFirewallDeviceMap.NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_EXTERNAL_FIREWALL_DEVICE_MAP_UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.NetworkExternalFirewallDeviceMapRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_NETWORK_EXTERNAL_FIREWALL_DEVICES_NETWORK_ID, org.apache.cloudstack.db.jooq.Keys.FK_NETWORK_EXTERNAL_FIREWALL_DEVICES_DEVICE_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.NetworkExternalFirewallDeviceMap as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.NetworkExternalFirewallDeviceMap(alias);
	}
}
