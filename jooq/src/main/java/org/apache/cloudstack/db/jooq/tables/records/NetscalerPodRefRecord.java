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
@javax.persistence.Table(name = "netscaler_pod_ref", schema = "cloud")
public class NetscalerPodRefRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.NetscalerPodRefRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = 1136823118;

	/**
	 * Setter for <code>cloud.netscaler_pod_ref.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.netscaler_pod_ref.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.netscaler_pod_ref.external_load_balancer_device_id</code>. id of external load balancer device
	 */
	public void setExternalLoadBalancerDeviceId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.netscaler_pod_ref.external_load_balancer_device_id</code>. id of external load balancer device
	 */
	@javax.persistence.Column(name = "external_load_balancer_device_id", nullable = false, precision = 20)
	public java.lang.Long getExternalLoadBalancerDeviceId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.netscaler_pod_ref.pod_id</code>. pod id
	 */
	public void setPodId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.netscaler_pod_ref.pod_id</code>. pod id
	 */
	@javax.persistence.Column(name = "pod_id", nullable = false, precision = 20)
	public java.lang.Long getPodId() {
		return (java.lang.Long) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF.EXTERNAL_LOAD_BALANCER_DEVICE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF.POD_ID;
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
		return getExternalLoadBalancerDeviceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getPodId();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached NetscalerPodRefRecord
	 */
	public NetscalerPodRefRecord() {
		super(org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF);
	}

	/**
	 * Create a detached, initialised NetscalerPodRefRecord
	 */
	public NetscalerPodRefRecord(java.lang.Long id, java.lang.Long externalLoadBalancerDeviceId, java.lang.Long podId) {
		super(org.apache.cloudstack.db.jooq.tables.NetscalerPodRef.NETSCALER_POD_REF);

		setValue(0, id);
		setValue(1, externalLoadBalancerDeviceId);
		setValue(2, podId);
	}
}
