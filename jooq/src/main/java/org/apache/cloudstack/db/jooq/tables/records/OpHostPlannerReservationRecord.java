/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "op_host_planner_reservation", schema = "cloud")
public class OpHostPlannerReservationRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.OpHostPlannerReservationRecord> implements org.jooq.Record6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String> {

	private static final long serialVersionUID = 1117681658;

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.data_center_id</code>. 
	 */
	public void setDataCenterId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.data_center_id</code>. 
	 */
	@javax.persistence.Column(name = "data_center_id", nullable = false, precision = 20)
	public java.lang.Long getDataCenterId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.pod_id</code>. 
	 */
	public void setPodId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.pod_id</code>. 
	 */
	@javax.persistence.Column(name = "pod_id", precision = 20)
	public java.lang.Long getPodId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.cluster_id</code>. 
	 */
	public void setClusterId(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.cluster_id</code>. 
	 */
	@javax.persistence.Column(name = "cluster_id", precision = 20)
	public java.lang.Long getClusterId() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.host_id</code>. 
	 */
	public void setHostId(java.lang.Long value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.host_id</code>. 
	 */
	@javax.persistence.Column(name = "host_id", precision = 20)
	public java.lang.Long getHostId() {
		return (java.lang.Long) getValue(4);
	}

	/**
	 * Setter for <code>cloud.op_host_planner_reservation.resource_usage</code>. Shared(between planners) Vs Dedicated (exclusive usage to a planner)
	 */
	public void setResourceUsage(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.op_host_planner_reservation.resource_usage</code>. Shared(between planners) Vs Dedicated (exclusive usage to a planner)
	 */
	@javax.persistence.Column(name = "resource_usage", length = 255)
	public java.lang.String getResourceUsage() {
		return (java.lang.String) getValue(5);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String> fieldsRow() {
		return (org.jooq.Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String> valuesRow() {
		return (org.jooq.Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.DATA_CENTER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.POD_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.CLUSTER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field5() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.HOST_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION.RESOURCE_USAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value2() {
		return getDataCenterId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getPodId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getClusterId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value5() {
		return getHostId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getResourceUsage();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached OpHostPlannerReservationRecord
	 */
	public OpHostPlannerReservationRecord() {
		super(org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION);
	}

	/**
	 * Create a detached, initialised OpHostPlannerReservationRecord
	 */
	public OpHostPlannerReservationRecord(java.lang.Long id, java.lang.Long dataCenterId, java.lang.Long podId, java.lang.Long clusterId, java.lang.Long hostId, java.lang.String resourceUsage) {
		super(org.apache.cloudstack.db.jooq.tables.OpHostPlannerReservation.OP_HOST_PLANNER_RESERVATION);

		setValue(0, id);
		setValue(1, dataCenterId);
		setValue(2, podId);
		setValue(3, clusterId);
		setValue(4, hostId);
		setValue(5, resourceUsage);
	}
}
