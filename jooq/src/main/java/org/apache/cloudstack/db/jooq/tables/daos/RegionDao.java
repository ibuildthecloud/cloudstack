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
public class RegionDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.RegionRecord, org.apache.cloudstack.db.jooq.tables.pojos.Region, java.lang.Integer> {

	/**
	 * Create a new RegionDao without any configuration
	 */
	public RegionDao() {
		super(org.apache.cloudstack.db.jooq.tables.Region.REGION, org.apache.cloudstack.db.jooq.tables.pojos.Region.class);
	}

	/**
	 * Create a new RegionDao with an attached configuration
	 */
	public RegionDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.Region.REGION, org.apache.cloudstack.db.jooq.tables.pojos.Region.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Integer getId(org.apache.cloudstack.db.jooq.tables.pojos.Region object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Region> fetchById(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Region.REGION.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.Region fetchOneById(java.lang.Integer value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.Region.REGION.ID, value);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Region> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Region.REGION.NAME, values);
	}

	/**
	 * Fetch a unique record that has <code>name = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.Region fetchOneByName(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.Region.REGION.NAME, value);
	}

	/**
	 * Fetch records that have <code>end_point IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Region> fetchByEndPoint(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Region.REGION.END_POINT, values);
	}

	/**
	 * Fetch records that have <code>portableip_service_enabled IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Region> fetchByPortableipServiceEnabled(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Region.REGION.PORTABLEIP_SERVICE_ENABLED, values);
	}

	/**
	 * Fetch records that have <code>gslb_service_enabled IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.Region> fetchByGslbServiceEnabled(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.Region.REGION.GSLB_SERVICE_ENABLED, values);
	}
}
