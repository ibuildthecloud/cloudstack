/**
 * This class is generated by jOOQ
 */
package org.apache.cloudstack.db.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.2.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.persistence.Entity
@javax.persistence.Table(name = "data_center_view", schema = "cloud")
public class DataCenterViewRecord extends org.jooq.impl.TableRecordImpl<org.apache.cloudstack.db.jooq.tables.records.DataCenterViewRecord> {

	private static final long serialVersionUID = 986084830;

	/**
	 * Setter for <code>cloud.data_center_view.id</code>. 
	 */
	public void setId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.id</code>. 
	 */
	@javax.persistence.Column(name = "id", nullable = false, precision = 20)
	public java.lang.Long getId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>cloud.data_center_view.uuid</code>. 
	 */
	public void setUuid(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.uuid</code>. 
	 */
	@javax.persistence.Column(name = "uuid", length = 40)
	public java.lang.String getUuid() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>cloud.data_center_view.name</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.name</code>. 
	 */
	@javax.persistence.Column(name = "name", length = 255)
	public java.lang.String getName() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>cloud.data_center_view.is_security_group_enabled</code>. 1: enabled, 0: not
	 */
	public void setIsSecurityGroupEnabled(java.lang.Byte value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.is_security_group_enabled</code>. 1: enabled, 0: not
	 */
	@javax.persistence.Column(name = "is_security_group_enabled", nullable = false, precision = 3)
	public java.lang.Byte getIsSecurityGroupEnabled() {
		return (java.lang.Byte) getValue(3);
	}

	/**
	 * Setter for <code>cloud.data_center_view.is_local_storage_enabled</code>. Is local storage offering enabled for this data center; 1: enabled, 0: not
	 */
	public void setIsLocalStorageEnabled(java.lang.Byte value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.is_local_storage_enabled</code>. Is local storage offering enabled for this data center; 1: enabled, 0: not
	 */
	@javax.persistence.Column(name = "is_local_storage_enabled", nullable = false, precision = 3)
	public java.lang.Byte getIsLocalStorageEnabled() {
		return (java.lang.Byte) getValue(4);
	}

	/**
	 * Setter for <code>cloud.data_center_view.description</code>. 
	 */
	public void setDescription(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.description</code>. 
	 */
	@javax.persistence.Column(name = "description", length = 255)
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>cloud.data_center_view.dns1</code>. 
	 */
	public void setDns1(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.dns1</code>. 
	 */
	@javax.persistence.Column(name = "dns1", nullable = false, length = 255)
	public java.lang.String getDns1() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>cloud.data_center_view.dns2</code>. 
	 */
	public void setDns2(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.dns2</code>. 
	 */
	@javax.persistence.Column(name = "dns2", length = 255)
	public java.lang.String getDns2() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>cloud.data_center_view.ip6_dns1</code>. 
	 */
	public void setIp6Dns1(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.ip6_dns1</code>. 
	 */
	@javax.persistence.Column(name = "ip6_dns1", length = 255)
	public java.lang.String getIp6Dns1() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>cloud.data_center_view.ip6_dns2</code>. 
	 */
	public void setIp6Dns2(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.ip6_dns2</code>. 
	 */
	@javax.persistence.Column(name = "ip6_dns2", length = 255)
	public java.lang.String getIp6Dns2() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>cloud.data_center_view.internal_dns1</code>. 
	 */
	public void setInternalDns1(java.lang.String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.internal_dns1</code>. 
	 */
	@javax.persistence.Column(name = "internal_dns1", nullable = false, length = 255)
	public java.lang.String getInternalDns1() {
		return (java.lang.String) getValue(10);
	}

	/**
	 * Setter for <code>cloud.data_center_view.internal_dns2</code>. 
	 */
	public void setInternalDns2(java.lang.String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.internal_dns2</code>. 
	 */
	@javax.persistence.Column(name = "internal_dns2", length = 255)
	public java.lang.String getInternalDns2() {
		return (java.lang.String) getValue(11);
	}

	/**
	 * Setter for <code>cloud.data_center_view.guest_network_cidr</code>. 
	 */
	public void setGuestNetworkCidr(java.lang.String value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.guest_network_cidr</code>. 
	 */
	@javax.persistence.Column(name = "guest_network_cidr", length = 18)
	public java.lang.String getGuestNetworkCidr() {
		return (java.lang.String) getValue(12);
	}

	/**
	 * Setter for <code>cloud.data_center_view.domain</code>. Network domain name of the Vms of the zone
	 */
	public void setDomain(java.lang.String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.domain</code>. Network domain name of the Vms of the zone
	 */
	@javax.persistence.Column(name = "domain", length = 100)
	public java.lang.String getDomain() {
		return (java.lang.String) getValue(13);
	}

	/**
	 * Setter for <code>cloud.data_center_view.networktype</code>. Network type of the zone
	 */
	public void setNetworktype(java.lang.String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.networktype</code>. Network type of the zone
	 */
	@javax.persistence.Column(name = "networktype", nullable = false, length = 255)
	public java.lang.String getNetworktype() {
		return (java.lang.String) getValue(14);
	}

	/**
	 * Setter for <code>cloud.data_center_view.allocation_state</code>. Is this data center enabled for allocation for new resources
	 */
	public void setAllocationState(java.lang.String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.allocation_state</code>. Is this data center enabled for allocation for new resources
	 */
	@javax.persistence.Column(name = "allocation_state", nullable = false, length = 32)
	public java.lang.String getAllocationState() {
		return (java.lang.String) getValue(15);
	}

	/**
	 * Setter for <code>cloud.data_center_view.zone_token</code>. 
	 */
	public void setZoneToken(java.lang.String value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.zone_token</code>. 
	 */
	@javax.persistence.Column(name = "zone_token", length = 255)
	public java.lang.String getZoneToken() {
		return (java.lang.String) getValue(16);
	}

	/**
	 * Setter for <code>cloud.data_center_view.dhcp_provider</code>. 
	 */
	public void setDhcpProvider(java.lang.String value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.dhcp_provider</code>. 
	 */
	@javax.persistence.Column(name = "dhcp_provider", length = 64)
	public java.lang.String getDhcpProvider() {
		return (java.lang.String) getValue(17);
	}

	/**
	 * Setter for <code>cloud.data_center_view.removed</code>. date removed if not null
	 */
	public void setRemoved(java.sql.Timestamp value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.removed</code>. date removed if not null
	 */
	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return (java.sql.Timestamp) getValue(18);
	}

	/**
	 * Setter for <code>cloud.data_center_view.domain_id</code>. 
	 */
	public void setDomainId(java.lang.Long value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.domain_id</code>. 
	 */
	@javax.persistence.Column(name = "domain_id", precision = 20)
	public java.lang.Long getDomainId() {
		return (java.lang.Long) getValue(19);
	}

	/**
	 * Setter for <code>cloud.data_center_view.domain_uuid</code>. 
	 */
	public void setDomainUuid(java.lang.String value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.domain_uuid</code>. 
	 */
	@javax.persistence.Column(name = "domain_uuid", length = 40)
	public java.lang.String getDomainUuid() {
		return (java.lang.String) getValue(20);
	}

	/**
	 * Setter for <code>cloud.data_center_view.domain_name</code>. 
	 */
	public void setDomainName(java.lang.String value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.domain_name</code>. 
	 */
	@javax.persistence.Column(name = "domain_name", length = 255)
	public java.lang.String getDomainName() {
		return (java.lang.String) getValue(21);
	}

	/**
	 * Setter for <code>cloud.data_center_view.domain_path</code>. 
	 */
	public void setDomainPath(java.lang.String value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.domain_path</code>. 
	 */
	@javax.persistence.Column(name = "domain_path", length = 255)
	public java.lang.String getDomainPath() {
		return (java.lang.String) getValue(22);
	}

	/**
	 * Setter for <code>cloud.data_center_view.affinity_group_id</code>. affinity group id associated
	 */
	public void setAffinityGroupId(java.lang.Long value) {
		setValue(23, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.affinity_group_id</code>. affinity group id associated
	 */
	@javax.persistence.Column(name = "affinity_group_id", precision = 20)
	public java.lang.Long getAffinityGroupId() {
		return (java.lang.Long) getValue(23);
	}

	/**
	 * Setter for <code>cloud.data_center_view.account_id</code>. account id of the account to which resource is dedicated
	 */
	public void setAccountId(java.lang.Long value) {
		setValue(24, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.account_id</code>. account id of the account to which resource is dedicated
	 */
	@javax.persistence.Column(name = "account_id", precision = 20)
	public java.lang.Long getAccountId() {
		return (java.lang.Long) getValue(24);
	}

	/**
	 * Setter for <code>cloud.data_center_view.affinity_group_uuid</code>. 
	 */
	public void setAffinityGroupUuid(java.lang.String value) {
		setValue(25, value);
	}

	/**
	 * Getter for <code>cloud.data_center_view.affinity_group_uuid</code>. 
	 */
	@javax.persistence.Column(name = "affinity_group_uuid", length = 40)
	public java.lang.String getAffinityGroupUuid() {
		return (java.lang.String) getValue(25);
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached DataCenterViewRecord
	 */
	public DataCenterViewRecord() {
		super(org.apache.cloudstack.db.jooq.tables.DataCenterView.DATA_CENTER_VIEW);
	}

	/**
	 * Create a detached, initialised DataCenterViewRecord
	 */
	public DataCenterViewRecord(java.lang.Long id, java.lang.String uuid, java.lang.String name, java.lang.Byte isSecurityGroupEnabled, java.lang.Byte isLocalStorageEnabled, java.lang.String description, java.lang.String dns1, java.lang.String dns2, java.lang.String ip6Dns1, java.lang.String ip6Dns2, java.lang.String internalDns1, java.lang.String internalDns2, java.lang.String guestNetworkCidr, java.lang.String domain, java.lang.String networktype, java.lang.String allocationState, java.lang.String zoneToken, java.lang.String dhcpProvider, java.sql.Timestamp removed, java.lang.Long domainId, java.lang.String domainUuid, java.lang.String domainName, java.lang.String domainPath, java.lang.Long affinityGroupId, java.lang.Long accountId, java.lang.String affinityGroupUuid) {
		super(org.apache.cloudstack.db.jooq.tables.DataCenterView.DATA_CENTER_VIEW);

		setValue(0, id);
		setValue(1, uuid);
		setValue(2, name);
		setValue(3, isSecurityGroupEnabled);
		setValue(4, isLocalStorageEnabled);
		setValue(5, description);
		setValue(6, dns1);
		setValue(7, dns2);
		setValue(8, ip6Dns1);
		setValue(9, ip6Dns2);
		setValue(10, internalDns1);
		setValue(11, internalDns2);
		setValue(12, guestNetworkCidr);
		setValue(13, domain);
		setValue(14, networktype);
		setValue(15, allocationState);
		setValue(16, zoneToken);
		setValue(17, dhcpProvider);
		setValue(18, removed);
		setValue(19, domainId);
		setValue(20, domainUuid);
		setValue(21, domainName);
		setValue(22, domainPath);
		setValue(23, affinityGroupId);
		setValue(24, accountId);
		setValue(25, affinityGroupUuid);
	}
}
