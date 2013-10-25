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
public class VmTemplateDetails extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord> {

	private static final long serialVersionUID = 416038734;

	/**
	 * The singleton instance of <code>cloud.vm_template_details</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.VmTemplateDetails VM_TEMPLATE_DETAILS = new org.apache.cloudstack.db.jooq.tables.VmTemplateDetails();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord.class;
	}

	/**
	 * The column <code>cloud.vm_template_details.id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vm_template_details.template_id</code>. template id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, java.lang.Long> TEMPLATE_ID = createField("template_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this);

	/**
	 * The column <code>cloud.vm_template_details.name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.vm_template_details.value</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, java.lang.String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(1024).nullable(false), this);

	/**
	 * Create a <code>cloud.vm_template_details</code> table reference
	 */
	public VmTemplateDetails() {
		super("vm_template_details", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.vm_template_details</code> table reference
	 */
	public VmTemplateDetails(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.VmTemplateDetails.VM_TEMPLATE_DETAILS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, java.lang.Long> getIdentity() {
		return org.apache.cloudstack.db.jooq.Keys.IDENTITY_VM_TEMPLATE_DETAILS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord> getPrimaryKey() {
		return org.apache.cloudstack.db.jooq.Keys.KEY_VM_TEMPLATE_DETAILS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord>>asList(org.apache.cloudstack.db.jooq.Keys.KEY_VM_TEMPLATE_DETAILS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.apache.cloudstack.db.jooq.tables.records.VmTemplateDetailsRecord, ?>>asList(org.apache.cloudstack.db.jooq.Keys.FK_VM_TEMPLATE_DETAILS__TEMPLATE_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.VmTemplateDetails as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.VmTemplateDetails(alias);
	}
}
