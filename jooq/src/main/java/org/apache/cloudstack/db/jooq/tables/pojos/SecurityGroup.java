/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "security_group", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"name", "account_id"})
})
public class SecurityGroup implements java.io.Serializable {

	private static final long serialVersionUID = -77834760;

	private java.lang.Long   id;
	private java.lang.String name;
	private java.lang.String uuid;
	private java.lang.String description;
	private java.lang.Long   domainId;
	private java.lang.Long   accountId;

	public SecurityGroup() {}

	public SecurityGroup(
		java.lang.Long   id,
		java.lang.String name,
		java.lang.String uuid,
		java.lang.String description,
		java.lang.Long   domainId,
		java.lang.Long   accountId
	) {
		this.id = id;
		this.name = name;
		this.uuid = uuid;
		this.description = description;
		this.domainId = domainId;
		this.accountId = accountId;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "description", length = 4096)
	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.Long domainId) {
		this.domainId = domainId;
	}

	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}
}
