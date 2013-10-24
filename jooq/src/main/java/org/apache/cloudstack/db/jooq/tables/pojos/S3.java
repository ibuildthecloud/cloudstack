/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "s3", schema = "cloud")
public class S3 implements java.io.Serializable {

	private static final long serialVersionUID = -1487487349;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.String   accessKey;
	private java.lang.String   secretKey;
	private java.lang.String   endPoint;
	private java.lang.String   bucket;
	private java.lang.Byte     https;
	private java.lang.Integer  connectionTimeout;
	private java.lang.Integer  maxErrorRetry;
	private java.lang.Integer  socketTimeout;
	private java.sql.Timestamp created;

	public S3() {}

	public S3(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.String   accessKey,
		java.lang.String   secretKey,
		java.lang.String   endPoint,
		java.lang.String   bucket,
		java.lang.Byte     https,
		java.lang.Integer  connectionTimeout,
		java.lang.Integer  maxErrorRetry,
		java.lang.Integer  socketTimeout,
		java.sql.Timestamp created
	) {
		this.id = id;
		this.uuid = uuid;
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.endPoint = endPoint;
		this.bucket = bucket;
		this.https = https;
		this.connectionTimeout = connectionTimeout;
		this.maxErrorRetry = maxErrorRetry;
		this.socketTimeout = socketTimeout;
		this.created = created;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "access_key", nullable = false, length = 20)
	public java.lang.String getAccessKey() {
		return this.accessKey;
	}

	public void setAccessKey(java.lang.String accessKey) {
		this.accessKey = accessKey;
	}

	@javax.persistence.Column(name = "secret_key", nullable = false, length = 40)
	public java.lang.String getSecretKey() {
		return this.secretKey;
	}

	public void setSecretKey(java.lang.String secretKey) {
		this.secretKey = secretKey;
	}

	@javax.persistence.Column(name = "end_point", length = 1024)
	public java.lang.String getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(java.lang.String endPoint) {
		this.endPoint = endPoint;
	}

	@javax.persistence.Column(name = "bucket", nullable = false, length = 63)
	public java.lang.String getBucket() {
		return this.bucket;
	}

	public void setBucket(java.lang.String bucket) {
		this.bucket = bucket;
	}

	@javax.persistence.Column(name = "https", precision = 3)
	public java.lang.Byte getHttps() {
		return this.https;
	}

	public void setHttps(java.lang.Byte https) {
		this.https = https;
	}

	@javax.persistence.Column(name = "connection_timeout", precision = 10)
	public java.lang.Integer getConnectionTimeout() {
		return this.connectionTimeout;
	}

	public void setConnectionTimeout(java.lang.Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	@javax.persistence.Column(name = "max_error_retry", precision = 10)
	public java.lang.Integer getMaxErrorRetry() {
		return this.maxErrorRetry;
	}

	public void setMaxErrorRetry(java.lang.Integer maxErrorRetry) {
		this.maxErrorRetry = maxErrorRetry;
	}

	@javax.persistence.Column(name = "socket_timeout", precision = 10)
	public java.lang.Integer getSocketTimeout() {
		return this.socketTimeout;
	}

	public void setSocketTimeout(java.lang.Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	@javax.persistence.Column(name = "created")
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
}
