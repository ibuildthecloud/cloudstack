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
@javax.persistence.Table(name = "op_host_transfer", schema = "cloud")
public class OpHostTransfer implements java.io.Serializable {

	private static final long serialVersionUID = 1117742692;

	private java.lang.Long     id;
	private java.lang.Long     initialMgmtServerId;
	private java.lang.Long     futureMgmtServerId;
	private java.lang.String   state;
	private java.sql.Timestamp created;

	public OpHostTransfer() {}

	public OpHostTransfer(
		java.lang.Long     id,
		java.lang.Long     initialMgmtServerId,
		java.lang.Long     futureMgmtServerId,
		java.lang.String   state,
		java.sql.Timestamp created
	) {
		this.id = id;
		this.initialMgmtServerId = initialMgmtServerId;
		this.futureMgmtServerId = futureMgmtServerId;
		this.state = state;
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

	@javax.persistence.Column(name = "initial_mgmt_server_id", precision = 20)
	public java.lang.Long getInitialMgmtServerId() {
		return this.initialMgmtServerId;
	}

	public void setInitialMgmtServerId(java.lang.Long initialMgmtServerId) {
		this.initialMgmtServerId = initialMgmtServerId;
	}

	@javax.persistence.Column(name = "future_mgmt_server_id", precision = 20)
	public java.lang.Long getFutureMgmtServerId() {
		return this.futureMgmtServerId;
	}

	public void setFutureMgmtServerId(java.lang.Long futureMgmtServerId) {
		this.futureMgmtServerId = futureMgmtServerId;
	}

	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}
}
