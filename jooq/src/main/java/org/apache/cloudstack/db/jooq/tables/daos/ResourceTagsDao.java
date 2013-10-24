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
public class ResourceTagsDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.ResourceTagsRecord, org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags, java.lang.Long> {

	/**
	 * Create a new ResourceTagsDao without any configuration
	 */
	public ResourceTagsDao() {
		super(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS, org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags.class);
	}

	/**
	 * Create a new ResourceTagsDao with an attached configuration
	 */
	public ResourceTagsDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS, org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.ID, value);
	}

	/**
	 * Fetch records that have <code>uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.UUID, values);
	}

	/**
	 * Fetch a unique record that has <code>uuid = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags fetchOneByUuid(java.lang.String value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.UUID, value);
	}

	/**
	 * Fetch records that have <code>key IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByKey(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.KEY, values);
	}

	/**
	 * Fetch records that have <code>value IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByValue(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.VALUE, values);
	}

	/**
	 * Fetch records that have <code>resource_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByResourceId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.RESOURCE_ID, values);
	}

	/**
	 * Fetch records that have <code>resource_uuid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByResourceUuid(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.RESOURCE_UUID, values);
	}

	/**
	 * Fetch records that have <code>resource_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByResourceType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.RESOURCE_TYPE, values);
	}

	/**
	 * Fetch records that have <code>customer IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByCustomer(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.CUSTOMER, values);
	}

	/**
	 * Fetch records that have <code>domain_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByDomainId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.DOMAIN_ID, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.ResourceTags> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.ResourceTags.RESOURCE_TAGS.ACCOUNT_ID, values);
	}
}
