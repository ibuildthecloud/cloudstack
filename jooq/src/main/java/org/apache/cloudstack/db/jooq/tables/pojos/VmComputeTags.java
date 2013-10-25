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
@javax.persistence.Table(name = "vm_compute_tags", schema = "cloud")
public class VmComputeTags implements java.io.Serializable {

	private static final long serialVersionUID = -505795145;

	private java.lang.Long   id;
	private java.lang.Long   vmId;
	private java.lang.String computeTag;

	public VmComputeTags() {}

	public VmComputeTags(
		java.lang.Long   id,
		java.lang.Long   vmId,
		java.lang.String computeTag
	) {
		this.id = id;
		this.vmId = vmId;
		this.computeTag = computeTag;
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

	@javax.persistence.Column(name = "compute_tag", nullable = false, length = 255)
	public java.lang.String getComputeTag() {
		return this.computeTag;
	}

	public void setComputeTag(java.lang.String computeTag) {
		this.computeTag = computeTag;
	}
}
