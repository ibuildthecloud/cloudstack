/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "project_invitation_view", schema = "cloud")
public class ProjectInvitationView implements java.io.Serializable {

	private static final long serialVersionUID = 742924310;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.String   email;
	private java.sql.Timestamp created;
	private java.lang.String   state;
	private java.lang.Long     projectId;
	private java.lang.String   projectUuid;
	private java.lang.String   projectName;
	private java.lang.Long     accountId;
	private java.lang.String   accountUuid;
	private java.lang.String   accountName;
	private java.lang.Integer  accountType;
	private java.lang.Long     domainId;
	private java.lang.String   domainUuid;
	private java.lang.String   domainName;
	private java.lang.String   domainPath;

	public ProjectInvitationView() {}

	public ProjectInvitationView(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.String   email,
		java.sql.Timestamp created,
		java.lang.String   state,
		java.lang.Long     projectId,
		java.lang.String   projectUuid,
		java.lang.String   projectName,
		java.lang.Long     accountId,
		java.lang.String   accountUuid,
		java.lang.String   accountName,
		java.lang.Integer  accountType,
		java.lang.Long     domainId,
		java.lang.String   domainUuid,
		java.lang.String   domainName,
		java.lang.String   domainPath
	) {
		this.id = id;
		this.uuid = uuid;
		this.email = email;
		this.created = created;
		this.state = state;
		this.projectId = projectId;
		this.projectUuid = projectUuid;
		this.projectName = projectName;
		this.accountId = accountId;
		this.accountUuid = accountUuid;
		this.accountName = accountName;
		this.accountType = accountType;
		this.domainId = domainId;
		this.domainUuid = domainUuid;
		this.domainName = domainName;
		this.domainPath = domainPath;
	}

	@javax.persistence.Column(name = "id", nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "uuid", length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "email", length = 255)
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "state", nullable = false, length = 255)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	@javax.persistence.Column(name = "project_id", precision = 20)
	public java.lang.Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(java.lang.Long projectId) {
		this.projectId = projectId;
	}

	@javax.persistence.Column(name = "project_uuid", length = 40)
	public java.lang.String getProjectUuid() {
		return this.projectUuid;
	}

	public void setProjectUuid(java.lang.String projectUuid) {
		this.projectUuid = projectUuid;
	}

	@javax.persistence.Column(name = "project_name", length = 255)
	public java.lang.String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(java.lang.String projectName) {
		this.projectName = projectName;
	}

	@javax.persistence.Column(name = "account_id", precision = 20)
	public java.lang.Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}

	@javax.persistence.Column(name = "account_uuid", length = 40)
	public java.lang.String getAccountUuid() {
		return this.accountUuid;
	}

	public void setAccountUuid(java.lang.String accountUuid) {
		this.accountUuid = accountUuid;
	}

	@javax.persistence.Column(name = "account_name", length = 100)
	public java.lang.String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(java.lang.String accountName) {
		this.accountName = accountName;
	}

	@javax.persistence.Column(name = "account_type", precision = 10)
	public java.lang.Integer getAccountType() {
		return this.accountType;
	}

	public void setAccountType(java.lang.Integer accountType) {
		this.accountType = accountType;
	}

	@javax.persistence.Column(name = "domain_id", precision = 20)
	public java.lang.Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.Long domainId) {
		this.domainId = domainId;
	}

	@javax.persistence.Column(name = "domain_uuid", length = 40)
	public java.lang.String getDomainUuid() {
		return this.domainUuid;
	}

	public void setDomainUuid(java.lang.String domainUuid) {
		this.domainUuid = domainUuid;
	}

	@javax.persistence.Column(name = "domain_name", length = 255)
	public java.lang.String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(java.lang.String domainName) {
		this.domainName = domainName;
	}

	@javax.persistence.Column(name = "domain_path", length = 255)
	public java.lang.String getDomainPath() {
		return this.domainPath;
	}

	public void setDomainPath(java.lang.String domainPath) {
		this.domainPath = domainPath;
	}
}
