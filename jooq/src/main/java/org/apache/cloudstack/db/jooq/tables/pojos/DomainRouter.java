/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 *
 * information about the domR instance
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "domain_router", schema = "cloud")
public class DomainRouter implements java.io.Serializable {

	private static final long serialVersionUID = -1180455335;

	private java.lang.Long    id;
	private java.lang.Long    elementId;
	private java.lang.String  publicMacAddress;
	private java.lang.String  publicIpAddress;
	private java.lang.String  publicNetmask;
	private java.lang.String  guestNetmask;
	private java.lang.String  guestIpAddress;
	private java.lang.Integer isRedundantRouter;
	private java.lang.Integer priority;
	private java.lang.Integer isPriorityBumpup;
	private java.lang.String  redundantState;
	private java.lang.Integer stopPending;
	private java.lang.String  role;
	private java.lang.String  templateVersion;
	private java.lang.String  scriptsVersion;
	private java.lang.Long    vpcId;

	public DomainRouter() {}

	public DomainRouter(
		java.lang.Long    id,
		java.lang.Long    elementId,
		java.lang.String  publicMacAddress,
		java.lang.String  publicIpAddress,
		java.lang.String  publicNetmask,
		java.lang.String  guestNetmask,
		java.lang.String  guestIpAddress,
		java.lang.Integer isRedundantRouter,
		java.lang.Integer priority,
		java.lang.Integer isPriorityBumpup,
		java.lang.String  redundantState,
		java.lang.Integer stopPending,
		java.lang.String  role,
		java.lang.String  templateVersion,
		java.lang.String  scriptsVersion,
		java.lang.Long    vpcId
	) {
		this.id = id;
		this.elementId = elementId;
		this.publicMacAddress = publicMacAddress;
		this.publicIpAddress = publicIpAddress;
		this.publicNetmask = publicNetmask;
		this.guestNetmask = guestNetmask;
		this.guestIpAddress = guestIpAddress;
		this.isRedundantRouter = isRedundantRouter;
		this.priority = priority;
		this.isPriorityBumpup = isPriorityBumpup;
		this.redundantState = redundantState;
		this.stopPending = stopPending;
		this.role = role;
		this.templateVersion = templateVersion;
		this.scriptsVersion = scriptsVersion;
		this.vpcId = vpcId;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "element_id", nullable = false, precision = 20)
	public java.lang.Long getElementId() {
		return this.elementId;
	}

	public void setElementId(java.lang.Long elementId) {
		this.elementId = elementId;
	}

	@javax.persistence.Column(name = "public_mac_address", length = 17)
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

	@javax.persistence.Column(name = "guest_netmask", length = 15)
	public java.lang.String getGuestNetmask() {
		return this.guestNetmask;
	}

	public void setGuestNetmask(java.lang.String guestNetmask) {
		this.guestNetmask = guestNetmask;
	}

	@javax.persistence.Column(name = "guest_ip_address", length = 40)
	public java.lang.String getGuestIpAddress() {
		return this.guestIpAddress;
	}

	public void setGuestIpAddress(java.lang.String guestIpAddress) {
		this.guestIpAddress = guestIpAddress;
	}

	@javax.persistence.Column(name = "is_redundant_router", nullable = false, precision = 10)
	public java.lang.Integer getIsRedundantRouter() {
		return this.isRedundantRouter;
	}

	public void setIsRedundantRouter(java.lang.Integer isRedundantRouter) {
		this.isRedundantRouter = isRedundantRouter;
	}

	@javax.persistence.Column(name = "priority", precision = 10)
	public java.lang.Integer getPriority() {
		return this.priority;
	}

	public void setPriority(java.lang.Integer priority) {
		this.priority = priority;
	}

	@javax.persistence.Column(name = "is_priority_bumpup", nullable = false, precision = 10)
	public java.lang.Integer getIsPriorityBumpup() {
		return this.isPriorityBumpup;
	}

	public void setIsPriorityBumpup(java.lang.Integer isPriorityBumpup) {
		this.isPriorityBumpup = isPriorityBumpup;
	}

	@javax.persistence.Column(name = "redundant_state", nullable = false, length = 64)
	public java.lang.String getRedundantState() {
		return this.redundantState;
	}

	public void setRedundantState(java.lang.String redundantState) {
		this.redundantState = redundantState;
	}

	@javax.persistence.Column(name = "stop_pending", nullable = false, precision = 10)
	public java.lang.Integer getStopPending() {
		return this.stopPending;
	}

	public void setStopPending(java.lang.Integer stopPending) {
		this.stopPending = stopPending;
	}

	@javax.persistence.Column(name = "role", nullable = false, length = 64)
	public java.lang.String getRole() {
		return this.role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}

	@javax.persistence.Column(name = "template_version", length = 100)
	public java.lang.String getTemplateVersion() {
		return this.templateVersion;
	}

	public void setTemplateVersion(java.lang.String templateVersion) {
		this.templateVersion = templateVersion;
	}

	@javax.persistence.Column(name = "scripts_version", length = 100)
	public java.lang.String getScriptsVersion() {
		return this.scriptsVersion;
	}

	public void setScriptsVersion(java.lang.String scriptsVersion) {
		this.scriptsVersion = scriptsVersion;
	}

	@javax.persistence.Column(name = "vpc_id", precision = 20)
	public java.lang.Long getVpcId() {
		return this.vpcId;
	}

	public void setVpcId(java.lang.Long vpcId) {
		this.vpcId = vpcId;
	}
}
