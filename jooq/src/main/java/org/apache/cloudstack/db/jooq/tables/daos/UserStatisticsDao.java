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
public class UserStatisticsDao extends org.jooq.impl.DAOImpl<org.apache.cloudstack.db.jooq.tables.records.UserStatisticsRecord, org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics, java.lang.Long> {

	/**
	 * Create a new UserStatisticsDao without any configuration
	 */
	public UserStatisticsDao() {
		super(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS, org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics.class);
	}

	/**
	 * Create a new UserStatisticsDao with an attached configuration
	 */
	public UserStatisticsDao(org.jooq.Configuration configuration) {
		super(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS, org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Long getId(org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchById(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics fetchOneById(java.lang.Long value) {
		return fetchOne(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.ID, value);
	}

	/**
	 * Fetch records that have <code>data_center_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByDataCenterId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.DATA_CENTER_ID, values);
	}

	/**
	 * Fetch records that have <code>account_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByAccountId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>public_ip_address IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByPublicIpAddress(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.PUBLIC_IP_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>device_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByDeviceId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.DEVICE_ID, values);
	}

	/**
	 * Fetch records that have <code>device_type IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByDeviceType(java.lang.String... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.DEVICE_TYPE, values);
	}

	/**
	 * Fetch records that have <code>network_id IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByNetworkId(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.NETWORK_ID, values);
	}

	/**
	 * Fetch records that have <code>net_bytes_received IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByNetBytesReceived(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.NET_BYTES_RECEIVED, values);
	}

	/**
	 * Fetch records that have <code>net_bytes_sent IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByNetBytesSent(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.NET_BYTES_SENT, values);
	}

	/**
	 * Fetch records that have <code>current_bytes_received IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByCurrentBytesReceived(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.CURRENT_BYTES_RECEIVED, values);
	}

	/**
	 * Fetch records that have <code>current_bytes_sent IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByCurrentBytesSent(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.CURRENT_BYTES_SENT, values);
	}

	/**
	 * Fetch records that have <code>agg_bytes_received IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByAggBytesReceived(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.AGG_BYTES_RECEIVED, values);
	}

	/**
	 * Fetch records that have <code>agg_bytes_sent IN (values)</code>
	 */
	public java.util.List<org.apache.cloudstack.db.jooq.tables.pojos.UserStatistics> fetchByAggBytesSent(java.lang.Long... values) {
		return fetch(org.apache.cloudstack.db.jooq.tables.UserStatistics.USER_STATISTICS.AGG_BYTES_SENT, values);
	}
}
