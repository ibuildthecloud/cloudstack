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
@javax.persistence.Table(name = "global_load_balancer_lb_rule_map", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"gslb_rule_id", "lb_rule_id"})
})
public class GlobalLoadBalancerLbRuleMap implements java.io.Serializable {

	private static final long serialVersionUID = 1137962384;

	private java.lang.Long id;
	private java.lang.Long gslbRuleId;
	private java.lang.Long lbRuleId;
	private java.lang.Long weight;
	private java.lang.Byte revoke;

	public GlobalLoadBalancerLbRuleMap() {}

	public GlobalLoadBalancerLbRuleMap(
		java.lang.Long id,
		java.lang.Long gslbRuleId,
		java.lang.Long lbRuleId,
		java.lang.Long weight,
		java.lang.Byte revoke
	) {
		this.id = id;
		this.gslbRuleId = gslbRuleId;
		this.lbRuleId = lbRuleId;
		this.weight = weight;
		this.revoke = revoke;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "gslb_rule_id", nullable = false, precision = 20)
	public java.lang.Long getGslbRuleId() {
		return this.gslbRuleId;
	}

	public void setGslbRuleId(java.lang.Long gslbRuleId) {
		this.gslbRuleId = gslbRuleId;
	}

	@javax.persistence.Column(name = "lb_rule_id", nullable = false, precision = 20)
	public java.lang.Long getLbRuleId() {
		return this.lbRuleId;
	}

	public void setLbRuleId(java.lang.Long lbRuleId) {
		this.lbRuleId = lbRuleId;
	}

	@javax.persistence.Column(name = "weight", nullable = false, precision = 20)
	public java.lang.Long getWeight() {
		return this.weight;
	}

	public void setWeight(java.lang.Long weight) {
		this.weight = weight;
	}

	@javax.persistence.Column(name = "revoke", nullable = false, precision = 3)
	public java.lang.Byte getRevoke() {
		return this.revoke;
	}

	public void setRevoke(java.lang.Byte revoke) {
		this.revoke = revoke;
	}
}
