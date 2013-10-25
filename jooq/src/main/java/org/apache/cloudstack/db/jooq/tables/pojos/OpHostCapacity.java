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
@javax.persistence.Table(name = "op_host_capacity", schema = "cloud")
public class OpHostCapacity implements java.io.Serializable {

	private static final long serialVersionUID = 554300539;

	private java.lang.Long     id;
	private java.lang.Long     hostId;
	private java.lang.Long     dataCenterId;
	private java.lang.Long     podId;
	private java.lang.Long     clusterId;
	private java.lang.Long     usedCapacity;
	private java.lang.Long     reservedCapacity;
	private java.lang.Long     totalCapacity;
	private java.lang.Integer  capacityType;
	private java.lang.String   capacityState;
	private java.sql.Timestamp updateTime;
	private java.sql.Timestamp created;

	public OpHostCapacity() {}

	public OpHostCapacity(
		java.lang.Long     id,
		java.lang.Long     hostId,
		java.lang.Long     dataCenterId,
		java.lang.Long     podId,
		java.lang.Long     clusterId,
		java.lang.Long     usedCapacity,
		java.lang.Long     reservedCapacity,
		java.lang.Long     totalCapacity,
		java.lang.Integer  capacityType,
		java.lang.String   capacityState,
		java.sql.Timestamp updateTime,
		java.sql.Timestamp created
	) {
		this.id = id;
		this.hostId = hostId;
		this.dataCenterId = dataCenterId;
		this.podId = podId;
		this.clusterId = clusterId;
		this.usedCapacity = usedCapacity;
		this.reservedCapacity = reservedCapacity;
		this.totalCapacity = totalCapacity;
		this.capacityType = capacityType;
		this.capacityState = capacityState;
		this.updateTime = updateTime;
		this.created = created;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "host_id", precision = 20)
	public java.lang.Long getHostId() {
		return this.hostId;
	}

	public void setHostId(java.lang.Long hostId) {
		this.hostId = hostId;
	}

	@javax.persistence.Column(name = "data_center_id", nullable = false, precision = 20)
	public java.lang.Long getDataCenterId() {
		return this.dataCenterId;
	}

	public void setDataCenterId(java.lang.Long dataCenterId) {
		this.dataCenterId = dataCenterId;
	}

	@javax.persistence.Column(name = "pod_id", precision = 20)
	public java.lang.Long getPodId() {
		return this.podId;
	}

	public void setPodId(java.lang.Long podId) {
		this.podId = podId;
	}

	@javax.persistence.Column(name = "cluster_id", precision = 20)
	public java.lang.Long getClusterId() {
		return this.clusterId;
	}

	public void setClusterId(java.lang.Long clusterId) {
		this.clusterId = clusterId;
	}

	@javax.persistence.Column(name = "used_capacity", nullable = false, precision = 19)
	public java.lang.Long getUsedCapacity() {
		return this.usedCapacity;
	}

	public void setUsedCapacity(java.lang.Long usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	@javax.persistence.Column(name = "reserved_capacity", nullable = false, precision = 19)
	public java.lang.Long getReservedCapacity() {
		return this.reservedCapacity;
	}

	public void setReservedCapacity(java.lang.Long reservedCapacity) {
		this.reservedCapacity = reservedCapacity;
	}

	@javax.persistence.Column(name = "total_capacity", nullable = false, precision = 19)
	public java.lang.Long getTotalCapacity() {
		return this.totalCapacity;
	}

	public void setTotalCapacity(java.lang.Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	@javax.persistence.Column(name = "capacity_type", nullable = false, precision = 10)
	public java.lang.Integer getCapacityType() {
		return this.capacityType;
	}

	public void setCapacityType(java.lang.Integer capacityType) {
		this.capacityType = capacityType;
	}

	@javax.persistence.Column(name = "capacity_state", nullable = false, length = 32)
	public java.lang.String getCapacityState() {
		return this.capacityState;
	}

	public void setCapacityState(java.lang.String capacityState) {
		this.capacityState = capacityState;
	}

	@javax.persistence.Column(name = "update_time")
	public java.sql.Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
}
