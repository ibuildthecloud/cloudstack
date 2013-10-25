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
public class ResourceLimit extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord> {

	private static final long serialVersionUID = -1577653344;

	/**
	 * The singleton instance of <code>cloud.resource_limit</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.ResourceLimit RESOURCE_LIMIT = new org.apache.cloudstack.db.jooq.tables.ResourceLimit();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord.class;
	}

	/**
	 * The column <code>cloud.resource_limit.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.resource_limit.domain_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.Long> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.resource_limit.account_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.Long> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * The column <code>cloud.resource_limit.type</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.resource_limit.max</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.Long> MAX = createField("max", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * Create a <code>cloud.resource_limit</code> table reference
	 */
	public ResourceLimit() {
		super("resource_limit", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.resource_limit</code> table reference
	 */
	public ResourceLimit(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.ResourceLimit.RESOURCE_LIMIT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_RESOURCE_LIMIT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_RESOURCE_LIMIT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_RESOURCE_LIMIT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.ResourceLimitRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_RESOURCE_LIMIT__DOMAIN_ID, org.apache.cloudstack.db.jooq.Keys.FK_RESOURCE_LIMIT__ACCOUNT_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.ResourceLimit as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.ResourceLimit(alias);
	}
}
