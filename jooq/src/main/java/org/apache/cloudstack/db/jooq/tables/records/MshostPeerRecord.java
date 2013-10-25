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
@javax.persistence.Table(name = "mshost_peer", schema = "cloud", uniqueConstraints = {
	@javax.persistence.UniqueConstraint(columnNames = {"owner_mshost", "peer_mshost", "peer_runid"})
})
public class MshostPeerRecord extends org.jooq.impl.UpdatableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.MshostPeerRecord> implements org.jooq.Record6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp> {

	private static final long serialVersionUID = 1320723834;

	/**
	 * Setter for <code>cloud.mshost_peer.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.id</code>. 
	 */
	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.mshost_peer.owner_mshost</code>. 
	 */
	public void setOwnerMshost(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.owner_mshost</code>. 
	 */
	@javax.persistence.Column(name = "owner_mshost", nullable = false, precision = 20)
	public java.lang.Long getOwnerMshost() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>cloud.mshost_peer.peer_mshost</code>. 
	 */
	public void setPeerMshost(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.peer_mshost</code>. 
	 */
	@javax.persistence.Column(name = "peer_mshost", nullable = false, precision = 20)
	public java.lang.Long getPeerMshost() {
		return (java.lang.Long) getValue(2);
	}

	/**
	 * Setter for <code>cloud.mshost_peer.peer_runid</code>. 
	 */
	public void setPeerRunid(java.lang.Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.peer_runid</code>. 
	 */
	@javax.persistence.Column(name = "peer_runid", nullable = false, precision = 19)
	public java.lang.Long getPeerRunid() {
		return (java.lang.Long) getValue(3);
	}

	/**
	 * Setter for <code>cloud.mshost_peer.peer_state</code>. 
	 */
	public void setPeerState(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.peer_state</code>. 
	 */
	@javax.persistence.Column(name = "peer_state", nullable = false, length = 10)
	public java.lang.String getPeerState() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>cloud.mshost_peer.last_update</code>. Last record update time
	 */
	public void setLastUpdate(java.sql.Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.mshost_peer.last_update</code>. Last record update time
	 */
	@javax.persistence.Column(name = "last_update")
	public java.sql.Timestamp getLastUpdate() {
		return (java.sql.Timestamp) getValue(5);
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
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp> fieldsRow() {
		return (org.jooq.Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.sql.Timestamp> valuesRow() {
		return (org.jooq.Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.OWNER_MSHOST;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.PEER_MSHOST;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field4() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.PEER_RUNID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.PEER_STATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field6() {
		return org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER.LAST_UPDATE;
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
		return getOwnerMshost();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return getPeerMshost();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value4() {
		return getPeerRunid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getPeerState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value6() {
		return getLastUpdate();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MshostPeerRecord
	 */
	public MshostPeerRecord() {
		super(org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER);
	}

	/**
	 * Create a detached, initialised MshostPeerRecord
	 */
	public MshostPeerRecord(java.lang.Long id, java.lang.Long ownerMshost, java.lang.Long peerMshost, java.lang.Long peerRunid, java.lang.String peerState, java.sql.Timestamp lastUpdate) {
		super(org.apache.cloudstack.db.jooq.tables.MshostPeer.MSHOST_PEER);

		setValue(0, id);
		setValue(1, ownerMshost);
		setValue(2, peerMshost);
		setValue(3, peerRunid);
		setValue(4, peerState);
		setValue(5, lastUpdate);
	}
}
