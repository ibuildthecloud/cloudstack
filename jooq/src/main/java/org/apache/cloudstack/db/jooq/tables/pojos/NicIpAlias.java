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
@javax.persistence.Table(name = "nic_ip_alias", schema = "cloud")
public class NicIpAlias implements java.io.Serializable {

	private static final long serialVersionUID = -92795817;

	private java.lang.Long     id;
	private java.lang.String   uuid;
	private java.lang.Long     nicId;
	private java.lang.String   ip4Address;
	private java.lang.String   ip6Address;
	private java.lang.String   netmask;
	private java.lang.String   gateway;
	private java.lang.String   startIpOfSubnet;
	private java.lang.Long     networkId;
	private java.lang.Long     vmid;
	private java.lang.Long     aliasCount;
	private java.sql.Timestamp created;
	private java.lang.Long     accountId;
	private java.lang.Long     domainId;
	private java.lang.String   state;

	public NicIpAlias() {}

	public NicIpAlias(
		java.lang.Long     id,
		java.lang.String   uuid,
		java.lang.Long     nicId,
		java.lang.String   ip4Address,
		java.lang.String   ip6Address,
		java.lang.String   netmask,
		java.lang.String   gateway,
		java.lang.String   startIpOfSubnet,
		java.lang.Long     networkId,
		java.lang.Long     vmid,
		java.lang.Long     aliasCount,
		java.sql.Timestamp created,
		java.lang.Long     accountId,
		java.lang.Long     domainId,
		java.lang.String   state
	) {
		this.id = id;
		this.uuid = uuid;
		this.nicId = nicId;
		this.ip4Address = ip4Address;
		this.ip6Address = ip6Address;
		this.netmask = netmask;
		this.gateway = gateway;
		this.startIpOfSubnet = startIpOfSubnet;
		this.networkId = networkId;
		this.vmid = vmid;
		this.aliasCount = aliasCount;
		this.created = created;
		this.accountId = accountId;
		this.domainId = domainId;
		this.state = state;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "uuid", nullable = false, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "nic_id", precision = 20)
	public java.lang.Long getNicId() {
		return this.nicId;
	}

	public void setNicId(java.lang.Long nicId) {
		this.nicId = nicId;
	}

	@javax.persistence.Column(name = "ip4_address", length = 40)
	public java.lang.String getIp4Address() {
		return this.ip4Address;
	}

	public void setIp4Address(java.lang.String ip4Address) {
		this.ip4Address = ip4Address;
	}

	@javax.persistence.Column(name = "ip6_address", length = 40)
	public java.lang.String getIp6Address() {
		return this.ip6Address;
	}

	public void setIp6Address(java.lang.String ip6Address) {
		this.ip6Address = ip6Address;
	}

	@javax.persistence.Column(name = "netmask", length = 40)
	public java.lang.String getNetmask() {
		return this.netmask;
	}

	public void setNetmask(java.lang.String netmask) {
		this.netmask = netmask;
	}

	@javax.persistence.Column(name = "gateway", length = 40)
	public java.lang.String getGateway() {
		return this.gateway;
	}

	public void setGateway(java.lang.String gateway) {
		this.gateway = gateway;
	}

	@javax.persistence.Column(name = "start_ip_of_subnet", length = 40)
	public java.lang.String getStartIpOfSubnet() {
		return this.startIpOfSubnet;
	}

	public void setStartIpOfSubnet(java.lang.String startIpOfSubnet) {
		this.startIpOfSubnet = startIpOfSubnet;
	}

	@javax.persistence.Column(name = "network_id", precision = 20)
	public java.lang.Long getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(java.lang.Long networkId) {
		this.networkId = networkId;
	}

	@javax.persistence.Column(name = "vmId", precision = 20)
	public java.lang.Long getVmid() {
		return this.vmid;
	}

	public void setVmid(java.lang.Long vmid) {
		this.vmid = vmid;
	}

	@javax.persistence.Column(name = "alias_count", precision = 20)
	public java.lang.Long getAliasCount() {
		return this.aliasCount;
	}

	public void setAliasCount(java.lang.Long aliasCount) {
		this.aliasCount = aliasCount;
	}

	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}

	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.Long domainId) {
		this.domainId = domainId;
	}

	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}
}
