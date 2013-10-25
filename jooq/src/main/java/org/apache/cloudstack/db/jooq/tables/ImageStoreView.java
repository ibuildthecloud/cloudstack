/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ImageStoreView extends org.jooq.impl.TableImpl<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord> {

	private static final long serialVersionUID = 583743489;

	/**
	 * The singleton instance of <code>cloud.image_store_view</code>
	 */
	public static final org.apache.cloudstack.db.jooq.tables.ImageStoreView IMAGE_STORE_VIEW = new org.apache.cloudstack.db.jooq.tables.ImageStoreView();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord> getRecordType() {
		return org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord.class;
	}

	/**
	 * The column <code>cloud.image_store_view.id</code>. id
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this);

	/**
	 * The column <code>cloud.image_store_view.uuid</code>. uuid of data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.name</code>. name of data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.image_store_view.image_provider_name</code>. id of image_store_provider
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> IMAGE_PROVIDER_NAME = createField("image_provider_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.image_store_view.protocol</code>. protocol of data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> PROTOCOL = createField("protocol", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this);

	/**
	 * The column <code>cloud.image_store_view.url</code>. url for image data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> URL = createField("url", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.scope</code>. scope of data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> SCOPE = createField("scope", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.role</code>. role of data store
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> ROLE = createField("role", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.removed</code>. date removed if not null
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.sql.Timestamp> REMOVED = createField("removed", org.jooq.impl.SQLDataType.TIMESTAMP, this);

	/**
	 * The column <code>cloud.image_store_view.data_center_id</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.Long> DATA_CENTER_ID = createField("data_center_id", org.jooq.impl.SQLDataType.BIGINT.defaulted(true), this);

	/**
	 * The column <code>cloud.image_store_view.data_center_uuid</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> DATA_CENTER_UUID = createField("data_center_uuid", org.jooq.impl.SQLDataType.VARCHAR.length(40), this);

	/**
	 * The column <code>cloud.image_store_view.data_center_name</code>. 
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> DATA_CENTER_NAME = createField("data_center_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.detail_name</code>. name of the detail
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> DETAIL_NAME = createField("detail_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>cloud.image_store_view.detail_value</code>. value of the detail
	 */
	public final org.jooq.TableField<org.apache.cloudstack.db.jooq.tables.records.ImageStoreViewRecord, java.lang.String> DETAIL_VALUE = createField("detail_value", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * Create a <code>cloud.image_store_view</code> table reference
	 */
	public ImageStoreView() {
		super("image_store_view", org.apache.cloudstack.db.jooq.Cloud.CLOUD);
	}

	/**
	 * Create an aliased <code>cloud.image_store_view</code> table reference
	 */
	public ImageStoreView(java.lang.String alias) {
		super(alias, org.apache.cloudstack.db.jooq.Cloud.CLOUD, org.apache.cloudstack.db.jooq.tables.ImageStoreView.IMAGE_STORE_VIEW);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.apache.cloudstack.db.jooq.tables.ImageStoreView as(java.lang.String alias) {
		return new org.apache.cloudstack.db.jooq.tables.ImageStoreView(alias);
	}
}
