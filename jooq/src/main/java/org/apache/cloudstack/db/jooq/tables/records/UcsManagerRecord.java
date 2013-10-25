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
@javax.persistence.Table(name = "ucs_manager", schema = "cloud")
public class UcsManagerRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.UcsManagerRecord> implements org.jooq.Record7<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -1252569206;

	/**
	 * Setter for <code>cloud.ucs_manager.id</code>. id
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.id</code>. id
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.zone_id</code>. 
	 */
	public void setZoneId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.zone_id</code>. 
	 */
	@javax.persistence.Column(name = "zone_id", nullable = false, precision = 20)
	public java.lang.Long getZoneId() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.name</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.name</code>. 
	 */
	@javax.persistence.Column(name = "name", length = 128)
	public java.lang.String getName() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.url</code>. 
	 */
	public void setUrl(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.url</code>. 
	 */
	@javax.persistence.Column(name = "url", nullable = false, length = 255)
	public java.lang.String getUrl() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.username</code>. 
	 */
	public void setUsername(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.username</code>. 
	 */
	@javax.persistence.Column(name = "username", nullable = false, length = 255)
	public java.lang.String getUsername() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.ucs_manager.password</code>. 
	 */
	public void setPassword(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.ucs_manager.password</code>. 
	 */
	@javax.persistence.Column(name = "password", nullable = false, length = 255)
	public java.lang.String getPassword() {
		return (java.lang.String) getValue(6);
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
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.UUID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.ZONE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.USERNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER.PASSWORD;
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
	public java.lang.String value2() {
		return getUuid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getZoneId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getPassword();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UcsManagerRecord
	 */
	public UcsManagerRecord() {
		super(org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER);
	}

	/**
	 * Create a detached, initialised UcsManagerRecord
	 */
	public UcsManagerRecord(java.lang.Long id, java.lang.String uuid, java.lang.Long zoneId, java.lang.String name, java.lang.String url, java.lang.String username, java.lang.String password) {
		super(org.apache.cloudstack.db.jooq.tables.UcsManager.UCS_MANAGER);

		setValue(0, id);
		setValue(1, uuid);
		setValue(2, zoneId);
		setValue(3, name);
		setValue(4, url);
		setValue(5, username);
		setValue(6, password);
	}
}
