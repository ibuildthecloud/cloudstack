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
@javax.persistence.Table(name = "network_external_lb_device_map", schema = "cloud")
public class NetworkExternalLbDeviceMap implements java.io.Serializable {

	private static final long serialVersionUID = 1858680893;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.Long     networkId;
	private java.lang.Long     externalLoadBalancerDeviceId;
	private java.sql.Timestamp created;
	private java.sql.Timestamp removed;

	public NetworkExternalLbDeviceMap() {}

	public NetworkExternalLbDeviceMap(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.Long     networkId,
		java.lang.Long     externalLoadBalancerDeviceId,
		java.sql.Timestamp created,
		java.sql.Timestamp removed
	) {
		this.id = id;
		this.uuid = uuid;
		this.networkId = networkId;
		this.externalLoadBalancerDeviceId = externalLoadBalancerDeviceId;
		this.created = created;
		this.removed = removed;
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

	@javax.persistence.Column(name = "network_id", nullable = false, precision = 20)
	public java.lang.Long getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(java.lang.Long networkId) {
		this.networkId = networkId;
	}

	@javax.persistence.Column(name = "external_load_balancer_device_id", nullable = false, precision = 20)
	public java.lang.Long getExternalLoadBalancerDeviceId() {
		return this.externalLoadBalancerDeviceId;
	}

	public void setExternalLoadBalancerDeviceId(java.lang.Long externalLoadBalancerDeviceId) {
		this.externalLoadBalancerDeviceId = externalLoadBalancerDeviceId;
	}

	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return this.removed;
	}

	public void setRemoved(java.sql.Timestamp removed) {
		this.removed = removed;
	}
}
