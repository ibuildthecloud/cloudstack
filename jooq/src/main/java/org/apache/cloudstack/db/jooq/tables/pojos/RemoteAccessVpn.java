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
@javax.persistence.Table(name = "remote_access_vpn", schema = "cloud")
public class RemoteAccessVpn implements java.io.Serializable {

	private static final long serialVersionUID = -1648243353;

	private java.lang.Long   vpnServerAddrId;
	private java.lang.Long   accountId;
	private java.lang.Long   networkId;
	private java.lang.Long   domainId;
	private java.lang.String localIp;
	private java.lang.String ipRange;
	private java.lang.String ipsecPsk;
	private java.lang.String state;
	private java.lang.Long   id;
	private java.lang.String uuid;

	public RemoteAccessVpn() {}

	public RemoteAccessVpn(
		java.lang.Long   vpnServerAddrId,
		java.lang.Long   accountId,
		java.lang.Long   networkId,
		java.lang.Long   domainId,
		java.lang.String localIp,
		java.lang.String ipRange,
		java.lang.String ipsecPsk,
		java.lang.String state,
		java.lang.Long   id,
		java.lang.String uuid
	) {
		this.vpnServerAddrId = vpnServerAddrId;
		this.accountId = accountId;
		this.networkId = networkId;
		this.domainId = domainId;
		this.localIp = localIp;
		this.ipRange = ipRange;
		this.ipsecPsk = ipsecPsk;
		this.state = state;
		this.id = id;
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "vpn_server_addr_id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getVpnServerAddrId() {
		return this.vpnServerAddrId;
	}

	public void setVpnServerAddrId(java.lang.Long vpnServerAddrId) {
		this.vpnServerAddrId = vpnServerAddrId;
	}

	@javax.persistence.Column(name = "account_id", nullable = false, precision = 20)
	public java.lang.Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}

	@javax.persistence.Column(name = "network_id", nullable = false, precision = 20)
	public java.lang.Long getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(java.lang.Long networkId) {
		this.networkId = networkId;
	}

	@javax.persistence.Column(name = "domain_id", nullable = false, precision = 20)
	public java.lang.Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.Long domainId) {
		this.domainId = domainId;
	}

	@javax.persistence.Column(name = "local_ip", nullable = false, length = 40)
	public java.lang.String getLocalIp() {
		return this.localIp;
	}

	public void setLocalIp(java.lang.String localIp) {
		this.localIp = localIp;
	}

	@javax.persistence.Column(name = "ip_range", nullable = false, length = 32)
	public java.lang.String getIpRange() {
		return this.ipRange;
	}

	public void setIpRange(java.lang.String ipRange) {
		this.ipRange = ipRange;
	}

	@javax.persistence.Column(name = "ipsec_psk", nullable = false, length = 256)
	public java.lang.String getIpsecPsk() {
		return this.ipsecPsk;
	}

	public void setIpsecPsk(java.lang.String ipsecPsk) {
		this.ipsecPsk = ipsecPsk;
	}

	@javax.persistence.Column(name = "state", nullable = false, length = 32)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
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

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}
}
