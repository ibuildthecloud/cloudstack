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
@javax.persistence.Table(name = "vmware_data_center", schema = "cloud")
public class VmwareDataCenter implements java.io.Serializable {

	private static final long serialVersionUID = -1887175177;

	private java.lang.Long   id;
	private java.lang.String uuid;
	private java.lang.String name;
	private java.lang.String guid;
	private java.lang.String vcenterHost;
	private java.lang.String username;
	private java.lang.String password;

	public VmwareDataCenter() {}

	public VmwareDataCenter(
		java.lang.Long   id,
		java.lang.String uuid,
		java.lang.String name,
		java.lang.String guid,
		java.lang.String vcenterHost,
		java.lang.String username,
		java.lang.String password
	) {
		this.id = id;
		this.uuid = uuid;
		this.name = name;
		this.guid = guid;
		this.vcenterHost = vcenterHost;
		this.username = username;
		this.password = password;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 255)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@javax.persistence.Column(name = "guid", unique = true, nullable = false, length = 255)
	public java.lang.String getGuid() {
		return this.guid;
	}

	public void setGuid(java.lang.String guid) {
		this.guid = guid;
	}

	@javax.persistence.Column(name = "vcenter_host", nullable = false, length = 255)
	public java.lang.String getVcenterHost() {
		return this.vcenterHost;
	}

	public void setVcenterHost(java.lang.String vcenterHost) {
		this.vcenterHost = vcenterHost;
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
}
