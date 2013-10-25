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
public class ServiceOfferingDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingRecord, org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering, java.lang.Long> {

	/**
	 * Create a new ServiceOfferingDao without any configuration
	 */
	public ServiceOfferingDao() {
		super(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING, org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering.class);
	}

	/**
	 * Create a new ServiceOfferingDao with an attached configuration
	 */
	public ServiceOfferingDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING, org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.ID, value);
	}

	/**
	 * Fetch records that have <code>cpu IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByCpu(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.CPU, values);
	}

	/**
	 * Fetch records that have <code>speed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchBySpeed(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.SPEED, values);
	}

	/**
	 * Fetch records that have <code>ram_size IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByRamSize(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.RAM_SIZE, values);
	}

	/**
	 * Fetch records that have <code>nw_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByNwRate(java.lang.Short... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.NW_RATE, values);
	}

	/**
	 * Fetch records that have <code>mc_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByMcRate(java.lang.Short... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.MC_RATE, values);
	}

	/**
	 * Fetch records that have <code>ha_enabled IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByHaEnabled(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.HA_ENABLED, values);
	}

	/**
	 * Fetch records that have <code>limit_cpu_use IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByLimitCpuUse(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.LIMIT_CPU_USE, values);
	}

	/**
	 * Fetch records that have <code>host_tag IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByHostTag(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.HOST_TAG, values);
	}

	/**
	 * Fetch records that have <code>default_use IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByDefaultUse(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.DEFAULT_USE, values);
	}

	/**
	 * Fetch records that have <code>vm_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByVmType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.VM_TYPE, values);
	}

	/**
	 * Fetch records that have <code>sort_key IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchBySortKey(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.SORT_KEY, values);
	}

	/**
	 * Fetch records that have <code>is_volatile IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByIsVolatile(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.IS_VOLATILE, values);
	}

	/**
	 * Fetch records that have <code>deployment_planner IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ServiceOffering> fetchByDeploymentPlanner(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ServiceOffering.SERVICE_OFFERING.DEPLOYMENT_PLANNER, values);
	}
}
