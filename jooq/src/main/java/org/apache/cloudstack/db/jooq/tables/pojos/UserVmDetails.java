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
@javax.persistence.Table(name = "user_vm_details", schema = "cloud")
public class UserVmDetails implements java.io.Serializable {

	private static final long serialVersionUID = 984243233;

	private java.lang.Long   id;
	private java.lang.Long   vmId;
	private java.lang.String name;
	private java.lang.String value;
	private java.lang.Byte   displayDetail;

	public UserVmDetails() {}

	public UserVmDetails(
		java.lang.Long   id,
		java.lang.Long   vmId,
		java.lang.String name,
		java.lang.String value,
		java.lang.Byte   displayDetail
	) {
		this.id = id;
		this.vmId = vmId;
		this.name = name;
		this.value = value;
		this.displayDetail = displayDetail;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "vm_id", nullable = false, precision = 20)
	public java.lang.Long getVmId() {
		return this.vmId;
	}

	public void setVmId(java.lang.Long vmId) {
		this.vmId = vmId;
	}

	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@javax.persistence.Column(name = "value", nullable = false, length = 1024)
	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

	@javax.persistence.Column(name = "display_detail", nullable = false, precision = 3)
	public java.lang.Byte getDisplayDetail() {
		return this.displayDetail;
	}

	public void setDisplayDetail(java.lang.Byte displayDetail) {
		this.displayDetail = displayDetail;
	}
}
