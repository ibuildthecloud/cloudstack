/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ServiceOfferingDetails extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord> {

	private static final long serialVersionUID = 1429476041;

	/**
	 * The singleton instance of <code>cloud.service_offering_details</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.ServiceOfferingDetails SERVICE_OFFERING_DETAILS = new org.apache.cloudstack.db.jooq.tables.ServiceOfferingDetails();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord.class;
	}

	/**
	 * The column <code>cloud.service_offering_details.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.service_offering_details.service_offering_id</code>. service offering id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, java.lang.Long> SERVICE_OFFERING_ID = createField("service_offering_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.service_offering_details.name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.service_offering_details.value</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, java.lang.String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * Create a <code>cloud.service_offering_details</code> table reference
	 */
	public ServiceOfferingDetails() {
		super("service_offering_details", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.service_offering_details</code> table reference
	 */
	public ServiceOfferingDetails(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.ServiceOfferingDetails.SERVICE_OFFERING_DETAILS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_SERVICE_OFFERING_DETAILS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_SERVICE_OFFERING_DETAILS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_SERVICE_OFFERING_DETAILS_PRIMARY, org.apache.cloudstack.db.jooq.Keys.KEY_SERVICE_OFFERING_DETAILS_UK_SERVICE_OFFERING_ID_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.ServiceOfferingDetailsRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_SERVICE_OFFERING_DETAILS__SERVICE_OFFERING_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.ServiceOfferingDetails as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.ServiceOfferingDetails(alias);
	}
}
