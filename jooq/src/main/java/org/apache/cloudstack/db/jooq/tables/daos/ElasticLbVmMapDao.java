/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ElasticLbVmMapDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ElasticLbVmMapRecord, org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap, java.lang.Long> {

	/**
	 * Create a new ElasticLbVmMapDao without any configuration
	 */
	public ElasticLbVmMapDao() {
		super(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP, org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap.class);
	}

	/**
	 * Create a new ElasticLbVmMapDao with an attached configuration
	 */
	public ElasticLbVmMapDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP, org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP.ID, value);
	}

	/**
	 * Fetch records that have <code>ip_addr_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap> fetchByIpAddrId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP.IP_ADDR_ID, values);
	}

	/**
	 * Fetch records that have <code>elb_vm_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap> fetchByElbVmId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP.ELB_VM_ID, values);
	}

	/**
	 * Fetch records that have <code>lb_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ElasticLbVmMap> fetchByLbId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ElasticLbVmMap.ELASTIC_LB_VM_MAP.LB_ID, values);
	}
}
