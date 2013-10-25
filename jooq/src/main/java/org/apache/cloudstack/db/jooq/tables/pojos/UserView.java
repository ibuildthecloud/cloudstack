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
@javax.persistence.Table(name = "user_view", schema = "cloud")
public class UserView implements java.io.Serializable {

	private static final long serialVersionUID = -1365838661;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.String   username;
	private java.lang.String   password;
	private java.lang.String   firstname;
	private java.lang.String   lastname;
	private java.lang.String   email;
	private java.lang.String   state;
	private java.lang.String   apiKey;
	private java.lang.String   secretKey;
	private java.sql.Timestamp created;
	private java.sql.Timestamp removed;
	private java.lang.String   timezone;
	private java.lang.String   registrationToken;
	private java.lang.Byte     isRegistered;
	private java.lang.Integer  incorrectLoginAttempts;
	private java.lang.Integer  default_;
	private java.lang.Long     accountId;
	private java.lang.String   accountUuid;
	private java.lang.String   accountName;
	private java.lang.Integer  accountType;
	private java.lang.Long     domainId;
	private java.lang.String   domainUuid;
	private java.lang.String   domainName;
	private java.lang.String   domainPath;
	private java.lang.Long     jobId;
	private java.lang.String   jobUuid;
	private java.lang.Integer  jobStatus;
	private java.lang.Long     jobAccountId;

	public UserView() {}

	public UserView(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.String   username,
		java.lang.String   password,
		java.lang.String   firstname,
		java.lang.String   lastname,
		java.lang.String   email,
		java.lang.String   state,
		java.lang.String   apiKey,
		java.lang.String   secretKey,
		java.sql.Timestamp created,
		java.sql.Timestamp removed,
		java.lang.String   timezone,
		java.lang.String   registrationToken,
		java.lang.Byte     isRegistered,
		java.lang.Integer  incorrectLoginAttempts,
		java.lang.Integer  default_,
		java.lang.Long     accountId,
		java.lang.String   accountUuid,
		java.lang.String   accountName,
		java.lang.Integer  accountType,
		java.lang.Long     domainId,
		java.lang.String   domainUuid,
		java.lang.String   domainName,
		java.lang.String   domainPath,
		java.lang.Long     jobId,
		java.lang.String   jobUuid,
		java.lang.Integer  jobStatus,
		java.lang.Long     jobAccountId
	) {
		this.id = id;
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.state = state;
		this.apiKey = apiKey;
		this.secretKey = secretKey;
		this.created = created;
		this.removed = removed;
		this.timezone = timezone;
		this.registrationToken = registrationToken;
		this.isRegistered = isRegistered;
		this.incorrectLoginAttempts = incorrectLoginAttempts;
		this.default_ = default_;
		this.accountId = accountId;
		this.accountUuid = accountUuid;
		this.accountName = accountName;
		this.accountType = accountType;
		this.domainId = domainId;
		this.domainUuid = domainUuid;
		this.domainName = domainName;
		this.domainPath = domainPath;
		this.jobId = jobId;
		this.jobUuid = jobUuid;
		this.jobStatus = jobStatus;
		this.jobAccountId = jobAccountId;
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

	@javax.persistence.Column(name = "username", nullable = false, length = 255)
	public java.lang.String getUsername() {
		return this.username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	@javax.persistence.Column(name = "password", nullable = false, length = 255)
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	@javax.persistence.Column(name = "firstname", length = 255)
	public java.lang.String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(java.lang.String firstname) {
		this.firstname = firstname;
	}

	@javax.persistence.Column(name = "lastname", length = 255)
	public java.lang.String getLastname() {
		return this.lastname;
	}

	public void setLastname(java.lang.String lastname) {
		this.lastname = lastname;
	}

	@javax.persistence.Column(name = "email", length = 255)
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	@javax.persistence.Column(name = "state", nullable = false, length = 10)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	@javax.persistence.Column(name = "api_key", length = 255)
	public java.lang.String getApiKey() {
		return this.apiKey;
	}

	public void setApiKey(java.lang.String apiKey) {
		this.apiKey = apiKey;
	}

	@javax.persistence.Column(name = "secret_key", length = 255)
	public java.lang.String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(java.lang.String secretKey) {
		this.secretKey = secretKey;
	}

	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return this.removed;
	}

	public void setRemoved(java.sql.Timestamp removed) {
		this.removed = removed;
	}

	@javax.persistence.Column(name = "timezone", length = 30)
	public java.lang.String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(java.lang.String timezone) {
		this.timezone = timezone;
	}

	@javax.persistence.Column(name = "registration_token", length = 255)
	public java.lang.String getRegistrationToken() {
		return this.registrationToken;
	}

	public void setRegistrationToken(java.lang.String registrationToken) {
		this.registrationToken = registrationToken;
	}

	@javax.persistence.Column(name = "is_registered", nullable = false, precision = 3)
	public java.lang.Byte getIsRegistered() {
		return this.isRegistered;
	}

	public void setIsRegistered(java.lang.Byte isRegistered) {
		this.isRegistered = isRegistered;
	}

	@javax.persistence.Column(name = "incorrect_login_attempts", nullable = false, precision = 10)
	public java.lang.Integer getIncorrectLoginAttempts() {
		return this.incorrectLoginAttempts;
	}

	public void setIncorrectLoginAttempts(java.lang.Integer incorrectLoginAttempts) {
		this.incorrectLoginAttempts = incorrectLoginAttempts;
	}

	@javax.persistence.Column(name = "default", nullable = false, precision = 10)
	public java.lang.Integer getDefault() {
		return this.default_;
	}

	public void setDefault(java.lang.Integer default_) {
		this.default_ = default_;
	}

	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
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

	@javax.persistence.Column(name = "account_type", nullable = false, precision = 10)
	public java.lang.Integer getAccountType() {
		return this.accountType;
	}

	public void setAccountType(java.lang.Integer accountType) {
		this.accountType = accountType;
	}

	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
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

	@javax.persistence.Column(name = "domain_path", nullable = false, length = 255)
	public java.lang.String getDomainPath() {
		return this.domainPath;
	}

	public void setDomainPath(java.lang.String domainPath) {
		this.domainPath = domainPath;
	}

	@javax.persistence.Column(name = "job_id", precision = 20)
	public java.lang.Long getJobId() {
		return this.jobId;
	}

	public void setJobId(java.lang.Long jobId) {
		this.jobId = jobId;
	}

	@javax.persistence.Column(name = "job_uuid", length = 40)
	public java.lang.String getJobUuid() {
		return this.jobUuid;
	}

	public void setJobUuid(java.lang.String jobUuid) {
		this.jobUuid = jobUuid;
	}

	@javax.persistence.Column(name = "job_status", precision = 10)
	public java.lang.Integer getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(java.lang.Integer jobStatus) {
		this.jobStatus = jobStatus;
	}

	@javax.persistence.Column(name = "job_account_id", precision = 20)
	public java.lang.Long getJobAccountId() {
		return this.jobAccountId;
	}

	public void setJobAccountId(java.lang.Long jobAccountId) {
		this.jobAccountId = jobAccountId;
	}
}
