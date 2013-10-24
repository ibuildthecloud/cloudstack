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
public class SyncQueueItemDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.SyncQueueItemRecord, org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem, java.lang.Long> {

	/**
	 * Create a new SyncQueueItemDao without any configuration
	 */
	public SyncQueueItemDao() {
		super(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM, org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem.class);
	}

	/**
	 * Create a new SyncQueueItemDao with an attached configuration
	 */
	public SyncQueueItemDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM, org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.ID, value);
	}

	/**
	 * Fetch records that have <code>queue_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByQueueId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.QUEUE_ID, values);
	}

	/**
	 * Fetch records that have <code>content_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByContentType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.CONTENT_TYPE, values);
	}

	/**
	 * Fetch records that have <code>content_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByContentId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.CONTENT_ID, values);
	}

	/**
	 * Fetch records that have <code>queue_proc_msid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByQueueProcMsid(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.QUEUE_PROC_MSID, values);
	}

	/**
	 * Fetch records that have <code>queue_proc_number IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByQueueProcNumber(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.QUEUE_PROC_NUMBER, values);
	}

	/**
	 * Fetch records that have <code>queue_proc_time IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByQueueProcTime(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.QUEUE_PROC_TIME, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.SyncQueueItem> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.SyncQueueItem.SYNC_QUEUE_ITEM.CREATED, values);
	}
}
