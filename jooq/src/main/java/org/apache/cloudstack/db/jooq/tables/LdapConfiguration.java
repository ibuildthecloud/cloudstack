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
public class LdapConfiguration extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord> {

	private static final long serialVersionUID = 635766935;

	/**
	 * The singleton instance of <code>cloud.ldap_configuration</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.LdapConfiguration LDAP_CONFIGURATION = new org.apache.cloudstack.db.jooq.tables.LdapConfiguration();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord.class;
	}

	/**
	 * The column <code>cloud.ldap_configuration.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.ldap_configuration.hostname</code>. the hostname of the ldap server
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord, java.lang.String> HOSTNAME = createField("hostname", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.ldap_configuration.port</code>. port that the ldap server is listening on
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord, java.lang.Integer> PORT = createField("port", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * Create a <code>cloud.ldap_configuration</code> table reference
	 */
	public LdapConfiguration() {
		super("ldap_configuration", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.ldap_configuration</code> table reference
	 */
	public LdapConfiguration(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.LdapConfiguration.LDAP_CONFIGURATION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_LDAP_CONFIGURATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_LDAP_CONFIGURATION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.LdapConfigurationRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_LDAP_CONFIGURATION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.LdapConfiguration as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.LdapConfiguration(alias);
	}
}
