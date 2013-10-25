/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "security_group_view", schema = "cloud")
public class SecurityGroupViewRecord extends org.jooq.impl.TableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.SecurityGroupViewRecord> {

	private static final long serialVersionUID = -460125038;

	/**
	 * Setter for <code>cloud.security_group_view.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.id</code>. 
	 */
	@javax.persistence.Column(name = "id", nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.security_group_view.name</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.name</code>. 
	 */
	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.security_group_view.description</code>. 
	 */
	public void setDescription(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.description</code>. 
	 */
	@javax.persistence.Column(name = "description", length = 4096)
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.security_group_view.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cloud.security_group_view.account_id</code>. 
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.account_id</code>. 
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(4);
	}

	/**
	 * Setter for <code>cloud.security_group_view.account_uuid</code>. 
	 */
	public void setAccountUuid(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.account_uuid</code>. 
	 */
	@javax.persistence.Column(name = "account_uuid", length = 40)
	public java.lang.String getAccountUuid() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.security_group_view.account_name</code>. an account name set by the creator of the account, defaults to username for single accounts
	 */
	public void setAccountName(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.account_name</code>. an account name set by the creator of the account, defaults to username for single accounts
	 */
	@javax.persistence.Column(name = "account_name", length = 100)
	public java.lang.String getAccountName() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>cloud.security_group_view.account_type</code>. 
	 */
	public void setAccountType(java.lang.Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.account_type</code>. 
	 */
	@javax.persistence.Column(name = "account_type", nullable = false, precision = 10)
	public java.lang.Integer getAccountType() {
		return (java.lang.Integer) getValue(7);
	}

	/**
	 * Setter for <code>cloud.security_group_view.domain_id</code>. 
	 */
	public void setDomainId(java.lang.Long value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.domain_id</code>. 
	 */
	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return (java.lang.Long) getValue(8);
	}

	/**
	 * Setter for <code>cloud.security_group_view.domain_uuid</code>. 
	 */
	public void setDomainUuid(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.domain_uuid</code>. 
	 */
	@javax.persistence.Column(name = "domain_uuid", length = 40)
	public java.lang.String getDomainUuid() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>cloud.security_group_view.domain_name</code>. 
	 */
	public void setDomainName(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.domain_name</code>. 
	 */
	@javax.persistence.Column(name = "domain_name", length = 255)
	public java.lang.String getDomainName() {
		return (java.lang.String) getValue(10);
	}

	/**
	 * Setter for <code>cloud.security_group_view.domain_path</code>. 
	 */
	public void setDomainPath(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.domain_path</code>. 
	 */
	@javax.persistence.Column(name = "domain_path", nullable = false, length = 255)
	public java.lang.String getDomainPath() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cloud.security_group_view.project_id</code>. 
	 */
	public void setProjectId(java.lang.Long value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.project_id</code>. 
	 */
	@javax.persistence.Column(name = "project_id", precision = 20)
	public java.lang.Long getProjectId() {
		return (java.lang.Long) getValue(12);
	}

	/**
	 * Setter for <code>cloud.security_group_view.project_uuid</code>. 
	 */
	public void setProjectUuid(java.lang.String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.project_uuid</code>. 
	 */
	@javax.persistence.Column(name = "project_uuid", length = 40)
	public java.lang.String getProjectUuid() {
		return (java.lang.String) getValue(13);
	}

	/**
	 * Setter for <code>cloud.security_group_view.project_name</code>. project name
	 */
	public void setProjectName(java.lang.String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.project_name</code>. project name
	 */
	@javax.persistence.Column(name = "project_name", length = 255)
	public java.lang.String getProjectName() {
		return (java.lang.String) getValue(14);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_id</code>. 
	 */
	public void setRuleId(java.lang.Long value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_id</code>. 
	 */
	@javax.persistence.Column(name = "rule_id", precision = 20)
	public java.lang.Long getRuleId() {
		return (java.lang.Long) getValue(15);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_uuid</code>. 
	 */
	public void setRuleUuid(java.lang.String value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_uuid</code>. 
	 */
	@javax.persistence.Column(name = "rule_uuid", length = 40)
	public java.lang.String getRuleUuid() {
		return (java.lang.String) getValue(16);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_type</code>. 
	 */
	public void setRuleType(java.lang.String value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_type</code>. 
	 */
	@javax.persistence.Column(name = "rule_type", length = 10)
	public java.lang.String getRuleType() {
		return (java.lang.String) getValue(17);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_start_port</code>. 
	 */
	public void setRuleStartPort(java.lang.String value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_start_port</code>. 
	 */
	@javax.persistence.Column(name = "rule_start_port", length = 10)
	public java.lang.String getRuleStartPort() {
		return (java.lang.String) getValue(18);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_end_port</code>. 
	 */
	public void setRuleEndPort(java.lang.String value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_end_port</code>. 
	 */
	@javax.persistence.Column(name = "rule_end_port", length = 10)
	public java.lang.String getRuleEndPort() {
		return (java.lang.String) getValue(19);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_protocol</code>. 
	 */
	public void setRuleProtocol(java.lang.String value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_protocol</code>. 
	 */
	@javax.persistence.Column(name = "rule_protocol", length = 16)
	public java.lang.String getRuleProtocol() {
		return (java.lang.String) getValue(20);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_allowed_network_id</code>. 
	 */
	public void setRuleAllowedNetworkId(java.lang.Long value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_allowed_network_id</code>. 
	 */
	@javax.persistence.Column(name = "rule_allowed_network_id", precision = 20)
	public java.lang.Long getRuleAllowedNetworkId() {
		return (java.lang.Long) getValue(21);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_allowed_ip_cidr</code>. 
	 */
	public void setRuleAllowedIpCidr(java.lang.String value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_allowed_ip_cidr</code>. 
	 */
	@javax.persistence.Column(name = "rule_allowed_ip_cidr", length = 44)
	public java.lang.String getRuleAllowedIpCidr() {
		return (java.lang.String) getValue(22);
	}

	/**
	 * Setter for <code>cloud.security_group_view.rule_create_status</code>. rule creation status
	 */
	public void setRuleCreateStatus(java.lang.String value) {
		setValue(23, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.rule_create_status</code>. rule creation status
	 */
	@javax.persistence.Column(name = "rule_create_status", length = 32)
	public java.lang.String getRuleCreateStatus() {
		return (java.lang.String) getValue(23);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_id</code>. id
	 */
	public void setTagId(java.lang.Long value) {
		setValue(24, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_id</code>. id
	 */
	@javax.persistence.Column(name = "tag_id", precision = 20)
	public java.lang.Long getTagId() {
		return (java.lang.Long) getValue(24);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_uuid</code>. 
	 */
	public void setTagUuid(java.lang.String value) {
		setValue(25, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_uuid</code>. 
	 */
	@javax.persistence.Column(name = "tag_uuid", length = 40)
	public java.lang.String getTagUuid() {
		return (java.lang.String) getValue(25);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_key</code>. 
	 */
	public void setTagKey(java.lang.String value) {
		setValue(26, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_key</code>. 
	 */
	@javax.persistence.Column(name = "tag_key", length = 255)
	public java.lang.String getTagKey() {
		return (java.lang.String) getValue(26);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_value</code>. 
	 */
	public void setTagValue(java.lang.String value) {
		setValue(27, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_value</code>. 
	 */
	@javax.persistence.Column(name = "tag_value", length = 255)
	public java.lang.String getTagValue() {
		return (java.lang.String) getValue(27);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_domain_id</code>. foreign key to domain id
	 */
	public void setTagDomainId(java.lang.Long value) {
		setValue(28, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_domain_id</code>. foreign key to domain id
	 */
	@javax.persistence.Column(name = "tag_domain_id", precision = 20)
	public java.lang.Long getTagDomainId() {
		return (java.lang.Long) getValue(28);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_account_id</code>. owner of this network
	 */
	public void setTagAccountId(java.lang.Long value) {
		setValue(29, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_account_id</code>. owner of this network
	 */
	@javax.persistence.Column(name = "tag_account_id", precision = 20)
	public java.lang.Long getTagAccountId() {
		return (java.lang.Long) getValue(29);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_resource_id</code>. 
	 */
	public void setTagResourceId(java.lang.Long value) {
		setValue(30, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_resource_id</code>. 
	 */
	@javax.persistence.Column(name = "tag_resource_id", precision = 20)
	public java.lang.Long getTagResourceId() {
		return (java.lang.Long) getValue(30);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_resource_uuid</code>. 
	 */
	public void setTagResourceUuid(java.lang.String value) {
		setValue(31, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_resource_uuid</code>. 
	 */
	@javax.persistence.Column(name = "tag_resource_uuid", length = 40)
	public java.lang.String getTagResourceUuid() {
		return (java.lang.String) getValue(31);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_resource_type</code>. 
	 */
	public void setTagResourceType(java.lang.String value) {
		setValue(32, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_resource_type</code>. 
	 */
	@javax.persistence.Column(name = "tag_resource_type", length = 255)
	public java.lang.String getTagResourceType() {
		return (java.lang.String) getValue(32);
	}

	/**
	 * Setter for <code>cloud.security_group_view.tag_customer</code>. 
	 */
	public void setTagCustomer(java.lang.String value) {
		setValue(33, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.tag_customer</code>. 
	 */
	@javax.persistence.Column(name = "tag_customer", length = 255)
	public java.lang.String getTagCustomer() {
		return (java.lang.String) getValue(33);
	}

	/**
	 * Setter for <code>cloud.security_group_view.job_id</code>. 
	 */
	public void setJobId(java.lang.Long value) {
		setValue(34, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.job_id</code>. 
	 */
	@javax.persistence.Column(name = "job_id", precision = 20)
	public java.lang.Long getJobId() {
		return (java.lang.Long) getValue(34);
	}

	/**
	 * Setter for <code>cloud.security_group_view.job_uuid</code>. 
	 */
	public void setJobUuid(java.lang.String value) {
		setValue(35, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.job_uuid</code>. 
	 */
	@javax.persistence.Column(name = "job_uuid", length = 40)
	public java.lang.String getJobUuid() {
		return (java.lang.String) getValue(35);
	}

	/**
	 * Setter for <code>cloud.security_group_view.job_status</code>. general job execution status
	 */
	public void setJobStatus(java.lang.Integer value) {
		setValue(36, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.job_status</code>. general job execution status
	 */
	@javax.persistence.Column(name = "job_status", precision = 10)
	public java.lang.Integer getJobStatus() {
		return (java.lang.Integer) getValue(36);
	}

	/**
	 * Setter for <code>cloud.security_group_view.job_account_id</code>. 
	 */
	public void setJobAccountId(java.lang.Long value) {
		setValue(37, value);
	}

	/**
	 * Getter for <code>cloud.security_group_view.job_account_id</code>. 
	 */
	@javax.persistence.Column(name = "job_account_id", precision = 20)
	public java.lang.Long getJobAccountId() {
		return (java.lang.Long) getValue(37);
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SecurityGroupViewRecord
	 */
	public SecurityGroupViewRecord() {
		super(org.apache.cloudstack.db.jooq.tables.SecurityGroupView.SECURITY_GROUP_VIEW);
	}

	/**
	 * Create a detached, initialised SecurityGroupViewRecord
	 */
	public SecurityGroupViewRecord(java.lang.Long id, java.lang.String name, java.lang.String description, java.lang.String uuid, java.lang.Long accountId, java.lang.String accountUuid, java.lang.String accountName, java.lang.Integer accountType, java.lang.Long domainId, java.lang.String domainUuid, java.lang.String domainName, java.lang.String domainPath, java.lang.Long projectId, java.lang.String projectUuid, java.lang.String projectName, java.lang.Long ruleId, java.lang.String ruleUuid, java.lang.String ruleType, java.lang.String ruleStartPort, java.lang.String ruleEndPort, java.lang.String ruleProtocol, java.lang.Long ruleAllowedNetworkId, java.lang.String ruleAllowedIpCidr, java.lang.String ruleCreateStatus, java.lang.Long tagId, java.lang.String tagUuid, java.lang.String tagKey, java.lang.String tagValue, java.lang.Long tagDomainId, java.lang.Long tagAccountId, java.lang.Long tagResourceId, java.lang.String tagResourceUuid, java.lang.String tagResourceType, java.lang.String tagCustomer, java.lang.Long jobId, java.lang.String jobUuid, java.lang.Integer jobStatus, java.lang.Long jobAccountId) {
		super(org.apache.cloudstack.db.jooq.tables.SecurityGroupView.SECURITY_GROUP_VIEW);

		setValue(0, id);
		setValue(1, name);
		setValue(2, description);
		setValue(3, uuid);
		setValue(4, accountId);
		setValue(5, accountUuid);
		setValue(6, accountName);
		setValue(7, accountType);
		setValue(8, domainId);
		setValue(9, domainUuid);
		setValue(10, domainName);
		setValue(11, domainPath);
		setValue(12, projectId);
		setValue(13, projectUuid);
		setValue(14, projectName);
		setValue(15, ruleId);
		setValue(16, ruleUuid);
		setValue(17, ruleType);
		setValue(18, ruleStartPort);
		setValue(19, ruleEndPort);
		setValue(20, ruleProtocol);
		setValue(21, ruleAllowedNetworkId);
		setValue(22, ruleAllowedIpCidr);
		setValue(23, ruleCreateStatus);
		setValue(24, tagId);
		setValue(25, tagUuid);
		setValue(26, tagKey);
		setValue(27, tagValue);
		setValue(28, tagDomainId);
		setValue(29, tagAccountId);
		setValue(30, tagResourceId);
		setValue(31, tagResourceUuid);
		setValue(32, tagResourceType);
		setValue(33, tagCustomer);
		setValue(34, jobId);
		setValue(35, jobUuid);
		setValue(36, jobStatus);
		setValue(37, jobAccountId);
	}
}
