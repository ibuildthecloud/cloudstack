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
public class DiskOfferingDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.DiskOfferingRecord, org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering, java.lang.Long> {

	/**
	 * Create a new DiskOfferingDao without any configuration
	 */
	public DiskOfferingDao() {
		super(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING, org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering.class);
	}

	/**
	 * Create a new DiskOfferingDao with an attached configuration
	 */
	public DiskOfferingDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING, org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.ID, value);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.NAME, values);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.UUID, value);
	}

	/**
	 * Fetch records that have <code>display_text IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByDisplayText(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.DISPLAY_TEXT, values);
	}

	/**
	 * Fetch records that have <code>disk_size IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByDiskSize(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.DISK_SIZE, values);
	}

	/**
	 * Fetch records that have <code>type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.TYPE, values);
	}

	/**
	 * Fetch records that have <code>tags IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByTags(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.TAGS, values);
	}

	/**
	 * Fetch records that have <code>recreatable IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByRecreatable(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.RECREATABLE, values);
	}

	/**
	 * Fetch records that have <code>use_local_storage IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByUseLocalStorage(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.USE_LOCAL_STORAGE, values);
	}

	/**
	 * Fetch records that have <code>unique_name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByUniqueName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.UNIQUE_NAME, values);
	}

	/**
	 * Fetch a unique record that has <code>unique_name = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering fetchOneByUniqueName(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.UNIQUE_NAME, value);
	}

	/**
	 * Fetch records that have <code>system_use IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchBySystemUse(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.SYSTEM_USE, values);
	}

	/**
	 * Fetch records that have <code>customized IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByCustomized(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.CUSTOMIZED, values);
	}

	/**
	 * Fetch records that have <code>removed IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByRemoved(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.REMOVED, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.CREATED, values);
	}

	/**
	 * Fetch records that have <code>sort_key IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchBySortKey(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.SORT_KEY, values);
	}

	/**
	 * Fetch records that have <code>display_offering IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByDisplayOffering(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.DISPLAY_OFFERING, values);
	}

	/**
	 * Fetch records that have <code>customized_iops IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByCustomizedIops(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.CUSTOMIZED_IOPS, values);
	}

	/**
	 * Fetch records that have <code>min_iops IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByMinIops(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.MIN_IOPS, values);
	}

	/**
	 * Fetch records that have <code>max_iops IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByMaxIops(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.MAX_IOPS, values);
	}

	/**
	 * Fetch records that have <code>bytes_read_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByBytesReadRate(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.BYTES_READ_RATE, values);
	}

	/**
	 * Fetch records that have <code>bytes_write_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByBytesWriteRate(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.BYTES_WRITE_RATE, values);
	}

	/**
	 * Fetch records that have <code>iops_read_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByIopsReadRate(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.IOPS_READ_RATE, values);
	}

	/**
	 * Fetch records that have <code>iops_write_rate IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByIopsWriteRate(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.IOPS_WRITE_RATE, values);
	}

	/**
	 * Fetch records that have <code>state IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.DiskOffering> fetchByState(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.DiskOffering.DISK_OFFERING.STATE, values);
	}
}
