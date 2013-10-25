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
@javax.persistence.Table(name = "global_load_balancer_lb_rule_map", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"gslb_rule_id", "lb_rule_id"})
})
public class GlobalLoadBalancerLbRuleMapRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.GlobalLoadBalancerLbRuleMapRecord> implements org.jooq.Record5<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Byte> {

	private static final long serialVersionUID = 220897472;

	/**
	 * Setter for <code>cloud.global_load_balancer_lb_rule_map.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.global_load_balancer_lb_rule_map.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.global_load_balancer_lb_rule_map.gslb_rule_id</code>. 
	 */
	public void setGslbRuleId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.global_load_balancer_lb_rule_map.gslb_rule_id</code>. 
	 */
	@javax.persistence.Column(name = "gslb_rule_id", nullable = false, precision = 20)
	public java.lang.Long getGslbRuleId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.global_load_balancer_lb_rule_map.lb_rule_id</code>. 
	 */
	public void setLbRuleId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.global_load_balancer_lb_rule_map.lb_rule_id</code>. 
	 */
	@javax.persistence.Column(name = "lb_rule_id", nullable = false, precision = 20)
	public java.lang.Long getLbRuleId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.global_load_balancer_lb_rule_map.weight</code>. weight of the site in gslb
	 */
	public void setWeight(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.global_load_balancer_lb_rule_map.weight</code>. weight of the site in gslb
	 */
	@javax.persistence.Column(name = "weight", nullable = false, precision = 20)
	public java.lang.Long getWeight() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>cloud.global_load_balancer_lb_rule_map.revoke</code>. 1 is when rule is set for Revoke
	 */
	public void setRevoke(java.lang.Byte value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.global_load_balancer_lb_rule_map.revoke</code>. 1 is when rule is set for Revoke
	 */
	@javax.persistence.Column(name = "revoke", nullable = false, precision = 3)
	public java.lang.Byte getRevoke() {
		return (java.lang.Byte) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Byte> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Byte> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP.GSLB_RULE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP.LB_RULE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP.WEIGHT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Byte> field5() {
		return org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP.REVOKE;
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
		return getGslbRuleId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getLbRuleId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getWeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Byte value5() {
		return getRevoke();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GlobalLoadBalancerLbRuleMapRecord
	 */
	public GlobalLoadBalancerLbRuleMapRecord() {
		super(org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP);
	}

	/**
	 * Create a detached, initialised GlobalLoadBalancerLbRuleMapRecord
	 */
	public GlobalLoadBalancerLbRuleMapRecord(java.lang.Long id, java.lang.Long gslbRuleId, java.lang.Long lbRuleId, java.lang.Long weight, java.lang.Byte revoke) {
		super(org.apache.cloudstack.db.jooq.tables.GlobalLoadBalancerLbRuleMap.GLOBAL_LOAD_BALANCER_LB_RULE_MAP);

		setValue(0, id);
		setValue(1, gslbRuleId);
		setValue(2, lbRuleId);
		setValue(3, weight);
		setValue(4, revoke);
	}
}
