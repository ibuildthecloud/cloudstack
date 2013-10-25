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
@javax.persistence.Table(name = "account_details", schema = "cloud")
public class AccountDetailsRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.AccountDetailsRecord> implements org.jooq.Record4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -1976079002;

	/**
	 * Setter for <code>cloud.account_details.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.account_details.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.account_details.account_id</code>. account id
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.account_details.account_id</code>. account id
	 */
	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.account_details.name</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.account_details.name</code>. 
	 */
	@javax.persistence.Column(name = "name", nullable = false, length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.account_details.value</code>. 
	 */
	public void setValue(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.account_details.value</code>. 
	 */
	@javax.persistence.Column(name = "value", length = 255)
	public java.lang.String getValue() {
		return (java.lang.String) getValue(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS.ACCOUNT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS.VALUE;
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
	public java.lang.Long value2() {
		return getAccountId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getValue();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached AccountDetailsRecord
	 */
	public AccountDetailsRecord() {
		super(org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS);
	}

	/**
	 * Create a detached, initialised AccountDetailsRecord
	 */
	public AccountDetailsRecord(java.lang.Long id, java.lang.Long accountId, java.lang.String name, java.lang.String value) {
		super(org.apache.cloudstack.db.jooq.tables.AccountDetails.ACCOUNT_DETAILS);

		setValue(0, id);
		setValue(1, accountId);
		setValue(2, name);
		setValue(3, value);
	}
}
