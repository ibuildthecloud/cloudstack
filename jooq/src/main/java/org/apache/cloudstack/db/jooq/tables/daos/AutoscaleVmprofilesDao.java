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
public class AutoscaleVmprofilesDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.AutoscaleVmprofilesRecord, org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles, java.lang.Long> {

	/**
	 * Create a new AutoscaleVmprofilesDao without any configuration
	 */
	public AutoscaleVmprofilesDao() {
		super(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES, org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles.class);
	}

	/**
	 * Create a new AutoscaleVmprofilesDao with an attached configuration
	 */
	public AutoscaleVmprofilesDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES, org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.UUID, value);
	}

	/**
	 * Fetch records that have <code>zone_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByZoneId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.ZONE_ID, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>autoscale_user_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByAutoscaleUserId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.AUTOSCALE_USER_ID, values);
	}

	/**
	 * Fetch records that have <code>service_offering_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByServiceOfferingId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.SERVICE_OFFERING_ID, values);
	}

	/**
	 * Fetch records that have <code>template_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByTemplateId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.TEMPLATE_ID, values);
	}

	/**
	 * Fetch records that have <code>other_deploy_params IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByOtherDeployParams(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.OTHER_DEPLOY_PARAMS, values);
	}

	/**
	 * Fetch records that have <code>destroy_vm_grace_period IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByDestroyVmGracePeriod(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.DESTROY_VM_GRACE_PERIOD, values);
	}

	/**
	 * Fetch records that have <code>counter_params IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByCounterParams(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.COUNTER_PARAMS, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.CREATED, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AutoscaleVmprofiles> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AutoscaleVmprofiles.AUTOSCALE_VMPROFILES.REMOVED, values);
	}
}
