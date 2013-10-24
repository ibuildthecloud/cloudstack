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
@javax.persistence.Table(name = "external_load_balancer_devices", schema = "cloud")
public class ExternalLoadBalancerDevices implements java.io.Serializable {

	private static final long serialVersionUID = 2115342244;

	private java.lang.Long    id;
	private java.lang.String  uuid;
	private java.lang.Long    physicalNetworkId;
	private java.lang.String  providerName;
	private java.lang.String  deviceName;
	private java.lang.Long    capacity;
	private java.lang.String  deviceState;
	private java.lang.String  allocationState;
	private java.lang.Integer isDedicated;
	private java.lang.Integer isManaged;
	private java.lang.Long    hostId;
	private java.lang.Long    parentHostId;
	private java.lang.Integer isGslbProvider;
	private java.lang.String  gslbSitePublicip;
	private java.lang.String  gslbSitePrivateip;

	public ExternalLoadBalancerDevices() {}

	public ExternalLoadBalancerDevices(
		java.lang.Long    id,
		java.lang.String  uuid,
		java.lang.Long    physicalNetworkId,
		java.lang.String  providerName,
		java.lang.String  deviceName,
		java.lang.Long    capacity,
		java.lang.String  deviceState,
		java.lang.String  allocationState,
		java.lang.Integer isDedicated,
		java.lang.Integer isManaged,
		java.lang.Long    hostId,
		java.lang.Long    parentHostId,
		java.lang.Integer isGslbProvider,
		java.lang.String  gslbSitePublicip,
		java.lang.String  gslbSitePrivateip
	) {
		this.id = id;
		this.uuid = uuid;
		this.physicalNetworkId = physicalNetworkId;
		this.providerName = providerName;
		this.deviceName = deviceName;
		this.capacity = capacity;
		this.deviceState = deviceState;
		this.allocationState = allocationState;
		this.isDedicated = isDedicated;
		this.isManaged = isManaged;
		this.hostId = hostId;
		this.parentHostId = parentHostId;
		this.isGslbProvider = isGslbProvider;
		this.gslbSitePublicip = gslbSitePublicip;
		this.gslbSitePrivateip = gslbSitePrivateip;
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

	@javax.persistence.Column(name = "physical_network_id", nullable = false, precision = 20)
	public java.lang.Long getPhysicalNetworkId() {
		return this.physicalNetworkId;
	}

	public void setPhysicalNetworkId(java.lang.Long physicalNetworkId) {
		this.physicalNetworkId = physicalNetworkId;
	}

	@javax.persistence.Column(name = "provider_name", nullable = false, length = 255)
	public java.lang.String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(java.lang.String providerName) {
		this.providerName = providerName;
	}

	@javax.persistence.Column(name = "device_name", nullable = false, length = 255)
	public java.lang.String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(java.lang.String deviceName) {
		this.deviceName = deviceName;
	}

	@javax.persistence.Column(name = "capacity", nullable = false, precision = 20)
	public java.lang.Long getCapacity() {
		return this.capacity;
	}

	public void setCapacity(java.lang.Long capacity) {
		this.capacity = capacity;
	}

	@javax.persistence.Column(name = "device_state", nullable = false, length = 32)
	public java.lang.String getDeviceState() {
		return this.deviceState;
	}

	public void setDeviceState(java.lang.String deviceState) {
		this.deviceState = deviceState;
	}

	@javax.persistence.Column(name = "allocation_state", nullable = false, length = 32)
	public java.lang.String getAllocationState() {
		return this.allocationState;
	}

	public void setAllocationState(java.lang.String allocationState) {
		this.allocationState = allocationState;
	}

	@javax.persistence.Column(name = "is_dedicated", nullable = false, precision = 10)
	public java.lang.Integer getIsDedicated() {
		return this.isDedicated;
	}

	public void setIsDedicated(java.lang.Integer isDedicated) {
		this.isDedicated = isDedicated;
	}

	@javax.persistence.Column(name = "is_managed", nullable = false, precision = 10)
	public java.lang.Integer getIsManaged() {
		return this.isManaged;
	}

	public void setIsManaged(java.lang.Integer isManaged) {
		this.isManaged = isManaged;
	}

	@javax.persistence.Column(name = "host_id", nullable = false, precision = 20)
	public java.lang.Long getHostId() {
		return this.hostId;
	}

	public void setHostId(java.lang.Long hostId) {
		this.hostId = hostId;
	}

	@javax.persistence.Column(name = "parent_host_id", precision = 20)
	public java.lang.Long getParentHostId() {
		return this.parentHostId;
	}

	public void setParentHostId(java.lang.Long parentHostId) {
		this.parentHostId = parentHostId;
	}

	@javax.persistence.Column(name = "is_gslb_provider", nullable = false, precision = 10)
	public java.lang.Integer getIsGslbProvider() {
		return this.isGslbProvider;
	}

	public void setIsGslbProvider(java.lang.Integer isGslbProvider) {
		this.isGslbProvider = isGslbProvider;
	}

	@javax.persistence.Column(name = "gslb_site_publicip", length = 255)
	public java.lang.String getGslbSitePublicip() {
		return this.gslbSitePublicip;
	}

	public void setGslbSitePublicip(java.lang.String gslbSitePublicip) {
		this.gslbSitePublicip = gslbSitePublicip;
	}

	@javax.persistence.Column(name = "gslb_site_privateip", length = 255)
	public java.lang.String getGslbSitePrivateip() {
		return this.gslbSitePrivateip;
	}

	public void setGslbSitePrivateip(java.lang.String gslbSitePrivateip) {
		this.gslbSitePrivateip = gslbSitePrivateip;
	}
}
