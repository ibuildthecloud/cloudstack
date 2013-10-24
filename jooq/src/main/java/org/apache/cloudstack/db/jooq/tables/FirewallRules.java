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
public class FirewallRules extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord> {

	private static final long serialVersionUID = -1852511805;

	/**
	 * The singleton instance of <code>cloud.firewall_rules</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.FirewallRules FIREWALL_RULES = new org.apache.cloudstack.db.jooq.tables.FirewallRules();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord.class;
	}

	/**
	 * The column <code>cloud.firewall_rules.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.firewall_rules.ip_address_id</code>. id of the corresponding ip address
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> IP_ADDRESS_ID = createField("ip_address_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.firewall_rules.start_port</code>. starting port of a port range
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Integer> START_PORT = createField("start_port", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.firewall_rules.end_port</code>. end port of a port range
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Integer> END_PORT = createField("end_port", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.firewall_rules.state</code>. current state of this rule
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.CHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.protocol</code>. protocol to open these ports for
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> PROTOCOL = createField("protocol", org.jooq.impl.SQLDataType.CHAR.length(16).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.firewall_rules.purpose</code>. why are these ports opened?
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> PURPOSE = createField("purpose", org.jooq.impl.SQLDataType.CHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.account_id</code>. owner id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.domain_id</code>. domain id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.network_id</code>. network id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> NETWORK_ID = createField("network_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.xid</code>. external id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> XID = createField("xid", org.jooq.impl.SQLDataType.CHAR.length(40).nullable(false), this);

	/**
	 * The column <code>cloud.firewall_rules.created</code>. Date created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.firewall_rules.icmp_code</code>. The ICMP code (if protocol=ICMP). A value of -1 means all codes for the given ICMP type.
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Integer> ICMP_CODE = createField("icmp_code", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.firewall_rules.icmp_type</code>. The ICMP type (if protocol=ICMP). A value of -1 means all types.
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Integer> ICMP_TYPE = createField("icmp_type", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>cloud.firewall_rules.related</code>. related to what other firewall rule
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> RELATED = createField("related", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.firewall_rules.type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.firewall_rules.vpc_id</code>. vpc the firewall rule is associated with
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> VPC_ID = createField("vpc_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.firewall_rules.traffic_type</code>. the traffic type of the rule, can be Ingress or Egress
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.String> TRAFFIC_TYPE = createField("traffic_type", org.jooq.impl.SQLDataType.CHAR.length(32), this);

	/**
	 * Create a <code>cloud.firewall_rules</code> table reference
	 */
	public FirewallRules() {
		super("firewall_rules", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.firewall_rules</code> table reference
	 */
	public FirewallRules(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.FirewallRules.FIREWALL_RULES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_FIREWALL_RULES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_FIREWALL_RULES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_FIREWALL_RULES_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_FIREWALL_RULES_UC_FIREWALL_RULES__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.FirewallRulesRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__IP_ADDRESS_ID, org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__ACCOUNT_ID, org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__NETWORK_ID, org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__RELATED, org.apache.cloudstack.db.jooq.Keys.FK_FIREWALL_RULES__VPC_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.FirewallRules as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.FirewallRules(alias);
	}
}
