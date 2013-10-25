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
public class TemplateSwiftRefDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.TemplateSwiftRefRecord, org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef, java.lang.Long> {

	/**
	 * Create a new TemplateSwiftRefDao without any configuration
	 */
	public TemplateSwiftRefDao() {
		super(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF, org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef.class);
	}

	/**
	 * Create a new TemplateSwiftRefDao with an attached configuration
	 */
	public TemplateSwiftRefDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF, org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.ID, value);
	}

	/**
	 * Fetch records that have <code>swift_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchBySwiftId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.SWIFT_ID, values);
	}

	/**
	 * Fetch records that have <code>template_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchByTemplateId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.TEMPLATE_ID, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.CREATED, values);
	}

	/**
	 * Fetch records that have <code>path IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchByPath(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.PATH, values);
	}

	/**
	 * Fetch records that have <code>size IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchBySize(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.SIZE, values);
	}

	/**
	 * Fetch records that have <code>physical_size IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.TemplateSwiftRef> fetchByPhysicalSize(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.TemplateSwiftRef.TEMPLATE_SWIFT_REF.PHYSICAL_SIZE, values);
	}
}
