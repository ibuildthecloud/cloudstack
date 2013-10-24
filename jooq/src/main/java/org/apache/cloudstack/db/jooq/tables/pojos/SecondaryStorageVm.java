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
@javax.persistence.Table(name = "secondary_storage_vm", schema = "cloud")
public class SecondaryStorageVm implements java.io.Serializable {

	private static final long serialVersionUID = 873083985;

	private java.lang.Long     id;
	private java.lang.String   publicMacAddress;
	private java.lang.String   publicIpAddress;
	private java.lang.String   publicNetmask;
	private java.lang.String   guid;
	private java.lang.String   nfsShare;
	private java.sql.Timestamp lastUpdate;
	private java.lang.String   role;

	public SecondaryStorageVm() {}

	public SecondaryStorageVm(
		java.lang.Long     id,
		java.lang.String   publicMacAddress,
		java.lang.String   publicIpAddress,
		java.lang.String   publicNetmask,
		java.lang.String   guid,
		java.lang.String   nfsShare,
		java.sql.Timestamp lastUpdate,
		java.lang.String   role
	) {
		this.id = id;
		this.publicMacAddress = publicMacAddress;
		this.publicIpAddress = publicIpAddress;
		this.publicNetmask = publicNetmask;
		this.guid = guid;
		this.nfsShare = nfsShare;
		this.lastUpdate = lastUpdate;
		this.role = role;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "public_mac_address", unique = true, length = 17)
	public java.lang.String getPublicMacAddress() {
		return this.publicMacAddress;
	}

	public void setPublicMacAddress(java.lang.String publicMacAddress) {
		this.publicMacAddress = publicMacAddress;
	}

	@javax.persistence.Column(name = "public_ip_address", length = 40)
	public java.lang.String getPublicIpAddress() {
		return this.publicIpAddress;
	}

	public void setPublicIpAddress(java.lang.String publicIpAddress) {
		this.publicIpAddress = publicIpAddress;
	}

	@javax.persistence.Column(name = "public_netmask", length = 15)
	public java.lang.String getPublicNetmask() {
		return this.publicNetmask;
	}

	public void setPublicNetmask(java.lang.String publicNetmask) {
		this.publicNetmask = publicNetmask;
	}

	@javax.persistence.Column(name = "guid", length = 255)
	public java.lang.String getGuid() {
		return this.guid;
	}

	public void setGuid(java.lang.String guid) {
		this.guid = guid;
	}

	@javax.persistence.Column(name = "nfs_share", length = 255)
	public java.lang.String getNfsShare() {
		return this.nfsShare;
	}

	public void setNfsShare(java.lang.String nfsShare) {
		this.nfsShare = nfsShare;
	}

	@javax.persistence.Column(name = "last_update")
	public java.sql.Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(java.sql.Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@javax.persistence.Column(name = "role", nullable = false, length = 64)
	public java.lang.String getRole() {
		return this.role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}
}
