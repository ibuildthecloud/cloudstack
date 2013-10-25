/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProjectInvitationsDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ProjectInvitationsRecord, org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations, java.lang.Long> {

	/**
	 * Create a new ProjectInvitationsDao without any configuration
	 */
	public ProjectInvitationsDao() {
		super(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS, org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations.class);
	}

	/**
	 * Create a new ProjectInvitationsDao with an attached configuration
	 */
	public ProjectInvitationsDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS, org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.UUID, value);
	}

	/**
	 * Fetch records that have <code>project_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByProjectId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.PROJECT_ID, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>email IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByEmail(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.EMAIL, values);
	}

	/**
	 * Fetch records that have <code>token IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByToken(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.TOKEN, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.STATE, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ProjectInvitations> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ProjectInvitations.PROJECT_INVITATIONS.CREATED, values);
	}
}
