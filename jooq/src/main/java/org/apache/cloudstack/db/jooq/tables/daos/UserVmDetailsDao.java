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
public class UserVmDetailsDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.UserVmDetailsRecord, org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails, java.lang.Long> {

	/**
	 * Create a new UserVmDetailsDao without any configuration
	 */
	public UserVmDetailsDao() {
		super(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS, org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails.class);
	}

	/**
	 * Create a new UserVmDetailsDao with an attached configuration
	 */
	public UserVmDetailsDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS, org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.ID, value);
	}

	/**
	 * Fetch records that have <code>vm_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails> fetchByVmId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.VM_ID, values);
	}

	/**
	 * Fetch records that have <code>name IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails> fetchByName(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.NAME, values);
	}

	/**
	 * Fetch records that have <code>value IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails> fetchByValue(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.VALUE, values);
	}

	/**
	 * Fetch records that have <code>display_detail IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserVmDetails> fetchByDisplayDetail(java.lang.Byte... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserVmDetails.USER_VM_DETAILS.DISPLAY_DETAIL, values);
	}
}
