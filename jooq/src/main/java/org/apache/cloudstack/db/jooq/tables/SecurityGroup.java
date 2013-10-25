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
public class SecurityGroup extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord> {

	private static final long serialVersionUID = 1751135482;

	/**
	 * The singleton instance of <code>cloud.security_group</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.SecurityGroup SECURITY_GROUP = new org.apache.cloudstack.db.jooq.tables.SecurityGroup();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord.class;
	}

	/**
	 * The column <code>cloud.security_group.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.security_group.name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.security_group.uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.security_group.description</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(4096), this);

	/**
	 * The column <code>cloud.security_group.domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.security_group.account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * Create a <code>cloud.security_group</code> table reference
	 */
	public SecurityGroup() {
		super("security_group", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.security_group</code> table reference
	 */
	public SecurityGroup(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.SecurityGroup.SECURITY_GROUP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_SECURITY_GROUP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_SECURITY_GROUP_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_SECURITY_GROUP_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_SECURITY_GROUP_NAME, org.apache.cloudstack.db.jooq.Keys.KEY_SECURITY_GROUP_UC_SECURITY_GROUP__UUID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_SECURITY_GROUP__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_SECURITY_GROUP__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.SecurityGroup as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.SecurityGroup(alias);
	}
}
