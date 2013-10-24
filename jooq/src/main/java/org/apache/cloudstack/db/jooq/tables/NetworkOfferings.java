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
public class NetworkOfferings extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord> {

	private static final long serialVersionUID = -1925428112;

	/**
	 * The singleton instance of <code>cloud.network_offerings</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.NetworkOfferings NETWORK_OFFERINGS = new org.apache.cloudstack.db.jooq.tables.NetworkOfferings();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord.class;
	}

	/**
	 * The column <code>cloud.network_offerings.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.network_offerings.name</code>. name of the network offering
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(64), this);

	/**
	 * The column <code>cloud.network_offerings.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.network_offerings.unique_name</code>. unique name of the network offering
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> UNIQUE_NAME = createField("unique_name", org.jooq.impl.SQLDataType.VARCHAR.length(64), this);

	/**
	 * The column <code>cloud.network_offerings.display_text</code>. text to display to users
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> DISPLAY_TEXT = createField("display_text", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.network_offerings.nw_rate</code>. network rate throttle mbits/s
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Short> NW_RATE = createField("nw_rate", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * The column <code>cloud.network_offerings.mc_rate</code>. mcast rate throttle mbits/s
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Short> MC_RATE = createField("mc_rate", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * The column <code>cloud.network_offerings.traffic_type</code>. traffic type carried on this network
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> TRAFFIC_TYPE = createField("traffic_type", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.network_offerings.tags</code>. tags supported by this offering
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> TAGS = createField("tags", org.jooq.impl.SQLDataType.VARCHAR.length(4096), this);

	/**
	 * The column <code>cloud.network_offerings.system_only</code>. Is this network offering for system use only
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> SYSTEM_ONLY = createField("system_only", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.specify_vlan</code>. Should the user specify vlan
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> SPECIFY_VLAN = createField("specify_vlan", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.service_offering_id</code>. service offering id that virtual router is tied to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Long> SERVICE_OFFERING_ID = createField("service_offering_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.network_offerings.conserve_mode</code>. Is this network offering is IP conserve mode enabled
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> CONSERVE_MODE = createField("conserve_mode", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.created</code>. time the entry was created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this);

	/**
	 * The column <code>cloud.network_offerings.removed</code>. time the entry was removed
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.network_offerings.default</code>. 1 if network offering is default
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> DEFAULT = createField("default", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.availability</code>. availability of the network
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> AVAILABILITY = createField("availability", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.network_offerings.dedicated_lb_service</code>. true if the network offering provides a dedicated load balancer for each network
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> DEDICATED_LB_SERVICE = createField("dedicated_lb_service", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.shared_source_nat_service</code>. true if the network offering provides the shared source nat service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> SHARED_SOURCE_NAT_SERVICE = createField("shared_source_nat_service", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.sort_key</code>. sort key used for customising sort method
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> SORT_KEY = createField("sort_key", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.redundant_router_service</code>. true if the network offering provides the redundant router service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> REDUNDANT_ROUTER_SERVICE = createField("redundant_router_service", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.state</code>. state of the network offering that has Disabled value by default
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.CHAR.length(32), this);

	/**
	 * The column <code>cloud.network_offerings.guest_type</code>. type of guest network that can be shared or isolated
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.String> GUEST_TYPE = createField("guest_type", org.jooq.impl.SQLDataType.CHAR.length(32), this);

	/**
	 * The column <code>cloud.network_offerings.elastic_ip_service</code>. true if the network offering provides elastic ip service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> ELASTIC_IP_SERVICE = createField("elastic_ip_service", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.eip_associate_public_ip</code>. true if public IP is associated with user VM creation by default when EIP service is enabled.
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> EIP_ASSOCIATE_PUBLIC_IP = createField("eip_associate_public_ip", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.elastic_lb_service</code>. true if the network offering provides elastic lb service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> ELASTIC_LB_SERVICE = createField("elastic_lb_service", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.specify_ip_ranges</code>. true if the network offering provides an ability to define ip ranges
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> SPECIFY_IP_RANGES = createField("specify_ip_ranges", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.inline</code>. Is this network offering LB provider is in inline mode
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> INLINE = createField("inline", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.is_persistent</code>. true if the network offering provides an ability to create persistent networks
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> IS_PERSISTENT = createField("is_persistent", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.internal_lb</code>. true if the network offering supports Internal lb service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> INTERNAL_LB = createField("internal_lb", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.public_lb</code>. true if the network offering supports Public lb service
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> PUBLIC_LB = createField("public_lb", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.egress_default_policy</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Byte> EGRESS_DEFAULT_POLICY = createField("egress_default_policy", org.jooq.impl.SQLDataType.TINYINT.defaulted(true), this);

	/**
	 * The column <code>cloud.network_offerings.concurrent_connections</code>. Load Balancer(haproxy) maximum number of concurrent connections(global max)
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Integer> CONCURRENT_CONNECTIONS = createField("concurrent_connections", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * Create a <code>cloud.network_offerings</code> table reference
	 */
	public NetworkOfferings() {
		super("network_offerings", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.network_offerings</code> table reference
	 */
	public NetworkOfferings(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.NetworkOfferings.NETWORK_OFFERINGS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_NETWORK_OFFERINGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_OFFERINGS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.NetworkOfferingsRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_OFFERINGS_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_OFFERINGS_ID, org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_OFFERINGS_UC_NETWORK_OFFERINGS__UUID, org.apache.cloudstack.db.jooq.Keys.KEY_NETWORK_OFFERINGS_UNIQUE_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.NetworkOfferings as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.NetworkOfferings(alias);
	}
}
