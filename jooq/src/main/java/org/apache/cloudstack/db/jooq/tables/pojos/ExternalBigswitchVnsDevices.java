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
@javax.persistence.Table(name = "external_bigswitch_vns_devices", schema = "cloud")
public class ExternalBigswitchVnsDevices implements java.io.Serializable {

	private static final long serialVersionUID = -1403847113;

	private java.lang.Long   id;
	private java.lang.String uuid;
	private java.lang.Long   physicalNetworkId;
	private java.lang.String providerName;
	private java.lang.String deviceName;
	private java.lang.Long   hostId;

	public ExternalBigswitchVnsDevices() {}

	public ExternalBigswitchVnsDevices(
		java.lang.Long   id,
		java.lang.String uuid,
		java.lang.Long   physicalNetworkId,
		java.lang.String providerName,
		java.lang.String deviceName,
		java.lang.Long   hostId
	) {
		this.id = id;
		this.uuid = uuid;
		this.physicalNetworkId = physicalNetworkId;
		this.providerName = providerName;
		this.deviceName = deviceName;
		this.hostId = hostId;
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

	@javax.persistence.Column(name = "host_id", nullable = false, precision = 20)
	public java.lang.Long getHostId() {
		return this.hostId;
	}

	public void setHostId(java.lang.Long hostId) {
		this.hostId = hostId;
	}
}
