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
public class Vpc extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.VpcRecord> {

	private static final long serialVersionUID = 1994776620;

	/**
	 * The singleton instance of <code>cloud.vpc</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.Vpc VPC = new org.apache.cloudstack.db.jooq.tables.Vpc();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.VpcRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.VpcRecord.class;
	}

	/**
	 * The column <code>cloud.vpc.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40).nullable(false), this);

	/**
	 * The column <code>cloud.vpc.name</code>. vpc name
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.vpc.display_text</code>. vpc display text
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> DISPLAY_TEXT = createField("display_text", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.vpc.cidr</code>. vpc cidr
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> CIDR = createField("cidr", org.jooq.impl.SQLDataType.VARCHAR.length(18), this);

	/**
	 * The column <code>cloud.vpc.vpc_offering_id</code>. vpc offering id that this vpc is created from
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> VPC_OFFERING_ID = createField("vpc_offering_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.zone_id</code>. the id of the zone this Vpc belongs to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> ZONE_ID = createField("zone_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.state</code>. state of the VP (can be Enabled and Disabled)
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> STATE = createField("state", org.jooq.impl.SQLDataType.VARCHAR.length(32).nullable(false), this);

	/**
	 * The column <code>cloud.vpc.domain_id</code>. domain the vpc belongs to
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.account_id</code>. owner of this vpc
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.network_domain</code>. network domain
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.String> NETWORK_DOMAIN = createField("network_domain", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.vpc.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.vpc.created</code>. date created
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.sql.Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this);

	/**
	 * The column <code>cloud.vpc.restart_required</code>. 1 if restart is required for the VPC
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Integer> RESTART_REQUIRED = createField("restart_required", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this);

	/**
	 * Create a <code>cloud.vpc</code> table reference
	 */
	public Vpc() {
		super("vpc", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.vpc</code> table reference
	 */
	public Vpc(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.Vpc.VPC);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_VPC;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VpcRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_VPC_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VpcRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VpcRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_VPC_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.VpcRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_VPC__VPC_OFFERING_ID, org.apache.cloudstack.db.jooq.Keys.FK_VPC__ZONE_ID, org.apache.cloudstack.db.jooq.Keys.FK_VPC__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_VPC__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.Vpc as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.Vpc(alias);
	}
}
