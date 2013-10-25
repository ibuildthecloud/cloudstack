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
@javax.persistence.Table(name = "guest_os_hypervisor", schema = "cloud")
public class GuestOsHypervisor implements java.io.Serializable {

	private static final long serialVersionUID = -1053410216;

	private java.lang.Long   id;
	private java.lang.String hypervisorType;
	private java.lang.String guestOsName;
	private java.lang.Long   guestOsId;

	public GuestOsHypervisor() {}

	public GuestOsHypervisor(
		java.lang.Long   id,
		java.lang.String hypervisorType,
		java.lang.String guestOsName,
		java.lang.Long   guestOsId
	) {
		this.id = id;
		this.hypervisorType = hypervisorType;
		this.guestOsName = guestOsName;
		this.guestOsId = guestOsId;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "hypervisor_type", nullable = false, length = 32)
	public java.lang.String getHypervisorType() {
		return this.hypervisorType;
	}

	public void setHypervisorType(java.lang.String hypervisorType) {
		this.hypervisorType = hypervisorType;
	}

	@javax.persistence.Column(name = "guest_os_name", nullable = false, length = 255)
	public java.lang.String getGuestOsName() {
		return this.guestOsName;
	}

	public void setGuestOsName(java.lang.String guestOsName) {
		this.guestOsName = guestOsName;
	}

	@javax.persistence.Column(name = "guest_os_id", nullable = false, precision = 20)
	public java.lang.Long getGuestOsId() {
		return this.guestOsId;
	}

	public void setGuestOsId(java.lang.Long guestOsId) {
		this.guestOsId = guestOsId;
	}
}
