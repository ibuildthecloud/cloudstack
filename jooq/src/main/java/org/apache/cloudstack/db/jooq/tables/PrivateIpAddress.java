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
public class PrivateIpAddress extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord> {

	private static final long serialVersionUID = 927809243;

	/**
	 * The singleton instance of <code>cloud.private_ip_address</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.PrivateIpAddress PRIVATE_IP_ADDRESS = new org.apache.cloudstack.db.jooq.tables.PrivateIpAddress();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord.class;
	}

	/**
	 * The column <code>cloud.private_ip_address.id</code>. primary key
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.private_ip_address.ip_address</code>. ip address
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.String> IP_ADDRESS = createField("ip_address", org.jooq.impl.SQLDataType.CHAR.length(40).nullable(false), this);

	/**
	 * The column <code>cloud.private_ip_address.network_id</code>. id of the network ip belongs to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.Long> NETWORK_ID = createField("network_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.private_ip_address.reservation_id</code>. reservation id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.String> RESERVATION_ID = createField("reservation_id", org.jooq.impl.SQLDataType.CHAR.length(40), this);

	/**
	 * The column <code>cloud.private_ip_address.mac_address</code>. mac address
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.String> MAC_ADDRESS = createField("mac_address", org.jooq.impl.SQLDataType.VARCHAR.length(17), this);

	/**
	 * The column <code>cloud.private_ip_address.vpc_id</code>. vpc this ip belongs to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.Long> VPC_ID = createField("vpc_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.private_ip_address.taken</code>. Date taken
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.sql.Timestamp> TAKEN = createField("taken", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.private_ip_address.source_nat</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.Byte> SOURCE_NAT = createField("source_nat", org.jooq.impl.SQLDataType.TINYINT.defaulted(true), this);

	/**
	 * Create a <code>cloud.private_ip_address</code> table reference
	 */
	public PrivateIpAddress() {
		super("private_ip_address", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.private_ip_address</code> table reference
	 */
	public PrivateIpAddress(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.PrivateIpAddress.PRIVATE_IP_ADDRESS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_PRIVATE_IP_ADDRESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_PRIVATE_IP_ADDRESS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_PRIVATE_IP_ADDRESS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.PrivateIpAddressRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_PRIVATE_IP_ADDRESS__NETWORK_ID, org.apache.cloudstack.db.jooq.Keys.FK_PRIVATE_IP_ADDRESS__VPC_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.PrivateIpAddress as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.PrivateIpAddress(alias);
	}
}
