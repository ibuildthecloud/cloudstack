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
@javax.persistence.Table(name = "sequence", schema = "cloud")
public class SequenceRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.SequenceRecord> implements org.jooq.Record2<java.lang.String, java.lang.Long> {

	private static final long serialVersionUID = 1248687176;

	/**
	 * Setter for <code>cloud.sequence.name</code>. name of the sequence
	 */
	public void setName(java.lang.String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.sequence.name</code>. name of the sequence
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "name", unique = true, nullable = false, length = 64)
	public java.lang.String getName() {
		return (java.lang.String) getValue(0);
	}

	/**
	 * Setter for <code>cloud.sequence.value</code>. sequence value
	 */
	public void setValue(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.sequence.value</code>. sequence value
	 */
	@javax.persistence.Column(name = "value", nullable = false, precision = 20)
	public java.lang.Long getValue() {
		return (java.lang.Long) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.String> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.String, java.lang.Long> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.String, java.lang.Long> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field1() {
		return org.apache.cloudstack.db.jooq.tables.Sequence.SEQUENCE.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.Sequence.SEQUENCE.VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value1() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value2() {
		return getValue();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SequenceRecord
	 */
	public SequenceRecord() {
		super(org.apache.cloudstack.db.jooq.tables.Sequence.SEQUENCE);
	}

	/**
	 * Create a detached, initialised SequenceRecord
	 */
	public SequenceRecord(java.lang.String name, java.lang.Long value) {
		super(org.apache.cloudstack.db.jooq.tables.Sequence.SEQUENCE);

		setValue(0, name);
		setValue(1, value);
	}
}
