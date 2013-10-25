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
public class AsyncJobJoinMapDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.AsyncJobJoinMapRecord, org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap, java.lang.Long> {

	/**
	 * Create a new AsyncJobJoinMapDao without any configuration
	 */
	public AsyncJobJoinMapDao() {
		super(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP, org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap.class);
	}

	/**
	 * Create a new AsyncJobJoinMapDao with an attached configuration
	 */
	public AsyncJobJoinMapDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP, org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.ID, value);
	}

	/**
	 * Fetch records that have <code>job_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByJobId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.JOB_ID, values);
	}

	/**
	 * Fetch records that have <code>join_job_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByJoinJobId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.JOIN_JOB_ID, values);
	}

	/**
	 * Fetch records that have <code>join_status IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByJoinStatus(java.lang.Integer... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.JOIN_STATUS, values);
	}

	/**
	 * Fetch records that have <code>join_result IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByJoinResult(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.JOIN_RESULT, values);
	}

	/**
	 * Fetch records that have <code>join_msid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByJoinMsid(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.JOIN_MSID, values);
	}

	/**
	 * Fetch records that have <code>complete_msid IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByCompleteMsid(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.COMPLETE_MSID, values);
	}

	/**
	 * Fetch records that have <code>sync_source_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchBySyncSourceId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.SYNC_SOURCE_ID, values);
	}

	/**
	 * Fetch records that have <code>wakeup_handler IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByWakeupHandler(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.WAKEUP_HANDLER, values);
	}

	/**
	 * Fetch records that have <code>wakeup_dispatcher IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByWakeupDispatcher(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.WAKEUP_DISPATCHER, values);
	}

	/**
	 * Fetch records that have <code>wakeup_interval IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByWakeupInterval(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.WAKEUP_INTERVAL, values);
	}

	/**
	 * Fetch records that have <code>created IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByCreated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.CREATED, values);
	}

	/**
	 * Fetch records that have <code>last_updated IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByLastUpdated(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.LAST_UPDATED, values);
	}

	/**
	 * Fetch records that have <code>next_wakeup IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByNextWakeup(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.NEXT_WAKEUP, values);
	}

	/**
	 * Fetch records that have <code>expiration IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.AsyncJobJoinMap> fetchByExpiration(java.sql.Timestamp... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.AsyncJobJoinMap.ASYNC_JOB_JOIN_MAP.EXPIRATION, values);
	}
}
