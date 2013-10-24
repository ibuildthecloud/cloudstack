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
@javax.persistence.Table(name = "network_offerings", schema = "cloud")
public class NetworkOfferings implements java.io.Serializable {

	private static final long serialVersionUID = -1997988410;

	private java.lang.Long     id;
	private java.lang.String   name;
	private java.lang.String   uuid;
	private java.lang.String   uniqueName;
	private java.lang.String   displayText;
	private java.lang.Short    nwRate;
	private java.lang.Short    mcRate;
	private java.lang.String   trafficType;
	private java.lang.String   tags;
	private java.lang.Integer  systemOnly;
	private java.lang.Integer  specifyVlan;
	private java.lang.Long     serviceOfferingId;
	private java.lang.Integer  conserveMode;
	private java.sql.Timestamp created;
	private java.sql.Timestamp removed;
	private java.lang.Integer  default_;
	private java.lang.String   availability;
	private java.lang.Integer  dedicatedLbService;
	private java.lang.Integer  sharedSourceNatService;
	private java.lang.Integer  sortKey;
	private java.lang.Integer  redundantRouterService;
	private java.lang.String   state;
	private java.lang.String   guestType;
	private java.lang.Integer  elasticIpService;
	private java.lang.Integer  eipAssociatePublicIp;
	private java.lang.Integer  elasticLbService;
	private java.lang.Integer  specifyIpRanges;
	private java.lang.Integer  inline;
	private java.lang.Integer  isPersistent;
	private java.lang.Integer  internalLb;
	private java.lang.Integer  publicLb;
	private java.lang.Byte     egressDefaultPolicy;
	private java.lang.Integer  concurrentConnections;

	public NetworkOfferings() {}

	public NetworkOfferings(
		java.lang.Long     id,
		java.lang.String   name,
		java.lang.String   uuid,
		java.lang.String   uniqueName,
		java.lang.String   displayText,
		java.lang.Short    nwRate,
		java.lang.Short    mcRate,
		java.lang.String   trafficType,
		java.lang.String   tags,
		java.lang.Integer  systemOnly,
		java.lang.Integer  specifyVlan,
		java.lang.Long     serviceOfferingId,
		java.lang.Integer  conserveMode,
		java.sql.Timestamp created,
		java.sql.Timestamp removed,
		java.lang.Integer  default_,
		java.lang.String   availability,
		java.lang.Integer  dedicatedLbService,
		java.lang.Integer  sharedSourceNatService,
		java.lang.Integer  sortKey,
		java.lang.Integer  redundantRouterService,
		java.lang.String   state,
		java.lang.String   guestType,
		java.lang.Integer  elasticIpService,
		java.lang.Integer  eipAssociatePublicIp,
		java.lang.Integer  elasticLbService,
		java.lang.Integer  specifyIpRanges,
		java.lang.Integer  inline,
		java.lang.Integer  isPersistent,
		java.lang.Integer  internalLb,
		java.lang.Integer  publicLb,
		java.lang.Byte     egressDefaultPolicy,
		java.lang.Integer  concurrentConnections
	) {
		this.id = id;
		this.name = name;
		this.uuid = uuid;
		this.uniqueName = uniqueName;
		this.displayText = displayText;
		this.nwRate = nwRate;
		this.mcRate = mcRate;
		this.trafficType = trafficType;
		this.tags = tags;
		this.systemOnly = systemOnly;
		this.specifyVlan = specifyVlan;
		this.serviceOfferingId = serviceOfferingId;
		this.conserveMode = conserveMode;
		this.created = created;
		this.removed = removed;
		this.default_ = default_;
		this.availability = availability;
		this.dedicatedLbService = dedicatedLbService;
		this.sharedSourceNatService = sharedSourceNatService;
		this.sortKey = sortKey;
		this.redundantRouterService = redundantRouterService;
		this.state = state;
		this.guestType = guestType;
		this.elasticIpService = elasticIpService;
		this.eipAssociatePublicIp = eipAssociatePublicIp;
		this.elasticLbService = elasticLbService;
		this.specifyIpRanges = specifyIpRanges;
		this.inline = inline;
		this.isPersistent = isPersistent;
		this.internalLb = internalLb;
		this.publicLb = publicLb;
		this.egressDefaultPolicy = egressDefaultPolicy;
		this.concurrentConnections = concurrentConnections;
	}

	@javax.persistence.Id
	@javax.persistence.Column(name = "id", unique = true, nullable = false, precision = 20)
	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	@javax.persistence.Column(name = "name", length = 64)
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	@javax.persistence.Column(name = "uuid", unique = true, length = 40)
	public java.lang.String getUuid() {
		return this.uuid;
	}

	public void setUuid(java.lang.String uuid) {
		this.uuid = uuid;
	}

	@javax.persistence.Column(name = "unique_name", unique = true, length = 64)
	public java.lang.String getUniqueName() {
		return this.uniqueName;
	}

	public void setUniqueName(java.lang.String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@javax.persistence.Column(name = "display_text", nullable = false, length = 255)
	public java.lang.String getDisplayText() {
		return this.displayText;
	}

	public void setDisplayText(java.lang.String displayText) {
		this.displayText = displayText;
	}

	@javax.persistence.Column(name = "nw_rate", precision = 5)
	public java.lang.Short getNwRate() {
		return this.nwRate;
	}

	public void setNwRate(java.lang.Short nwRate) {
		this.nwRate = nwRate;
	}

	@javax.persistence.Column(name = "mc_rate", precision = 5)
	public java.lang.Short getMcRate() {
		return this.mcRate;
	}

	public void setMcRate(java.lang.Short mcRate) {
		this.mcRate = mcRate;
	}

	@javax.persistence.Column(name = "traffic_type", nullable = false, length = 32)
	public java.lang.String getTrafficType() {
		return this.trafficType;
	}

	public void setTrafficType(java.lang.String trafficType) {
		this.trafficType = trafficType;
	}

	@javax.persistence.Column(name = "tags", length = 4096)
	public java.lang.String getTags() {
		return this.tags;
	}

	public void setTags(java.lang.String tags) {
		this.tags = tags;
	}

	@javax.persistence.Column(name = "system_only", nullable = false, precision = 10)
	public java.lang.Integer getSystemOnly() {
		return this.systemOnly;
	}

	public void setSystemOnly(java.lang.Integer systemOnly) {
		this.systemOnly = systemOnly;
	}

	@javax.persistence.Column(name = "specify_vlan", nullable = false, precision = 10)
	public java.lang.Integer getSpecifyVlan() {
		return this.specifyVlan;
	}

	public void setSpecifyVlan(java.lang.Integer specifyVlan) {
		this.specifyVlan = specifyVlan;
	}

	@javax.persistence.Column(name = "service_offering_id", precision = 20)
	public java.lang.Long getServiceOfferingId() {
		return this.serviceOfferingId;
	}

	public void setServiceOfferingId(java.lang.Long serviceOfferingId) {
		this.serviceOfferingId = serviceOfferingId;
	}

	@javax.persistence.Column(name = "conserve_mode", nullable = false, precision = 10)
	public java.lang.Integer getConserveMode() {
		return this.conserveMode;
	}

	public void setConserveMode(java.lang.Integer conserveMode) {
		this.conserveMode = conserveMode;
	}

	@javax.persistence.Column(name = "created", nullable = false)
	public java.sql.Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}

	@javax.persistence.Column(name = "removed")
	public java.sql.Timestamp getRemoved() {
		return this.removed;
	}

	public void setRemoved(java.sql.Timestamp removed) {
		this.removed = removed;
	}

	@javax.persistence.Column(name = "default", nullable = false, precision = 10)
	public java.lang.Integer getDefault() {
		return this.default_;
	}

	public void setDefault(java.lang.Integer default_) {
		this.default_ = default_;
	}

	@javax.persistence.Column(name = "availability", nullable = false, length = 255)
	public java.lang.String getAvailability() {
		return this.availability;
	}

	public void setAvailability(java.lang.String availability) {
		this.availability = availability;
	}

	@javax.persistence.Column(name = "dedicated_lb_service", nullable = false, precision = 10)
	public java.lang.Integer getDedicatedLbService() {
		return this.dedicatedLbService;
	}

	public void setDedicatedLbService(java.lang.Integer dedicatedLbService) {
		this.dedicatedLbService = dedicatedLbService;
	}

	@javax.persistence.Column(name = "shared_source_nat_service", nullable = false, precision = 10)
	public java.lang.Integer getSharedSourceNatService() {
		return this.sharedSourceNatService;
	}

	public void setSharedSourceNatService(java.lang.Integer sharedSourceNatService) {
		this.sharedSourceNatService = sharedSourceNatService;
	}

	@javax.persistence.Column(name = "sort_key", nullable = false, precision = 10)
	public java.lang.Integer getSortKey() {
		return this.sortKey;
	}

	public void setSortKey(java.lang.Integer sortKey) {
		this.sortKey = sortKey;
	}

	@javax.persistence.Column(name = "redundant_router_service", nullable = false, precision = 10)
	public java.lang.Integer getRedundantRouterService() {
		return this.redundantRouterService;
	}

	public void setRedundantRouterService(java.lang.Integer redundantRouterService) {
		this.redundantRouterService = redundantRouterService;
	}

	@javax.persistence.Column(name = "state", length = 32)
	public java.lang.String getState() {
		return this.state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	@javax.persistence.Column(name = "guest_type", length = 32)
	public java.lang.String getGuestType() {
		return this.guestType;
	}

	public void setGuestType(java.lang.String guestType) {
		this.guestType = guestType;
	}

	@javax.persistence.Column(name = "elastic_ip_service", nullable = false, precision = 10)
	public java.lang.Integer getElasticIpService() {
		return this.elasticIpService;
	}

	public void setElasticIpService(java.lang.Integer elasticIpService) {
		this.elasticIpService = elasticIpService;
	}

	@javax.persistence.Column(name = "eip_associate_public_ip", nullable = false, precision = 10)
	public java.lang.Integer getEipAssociatePublicIp() {
		return this.eipAssociatePublicIp;
	}

	public void setEipAssociatePublicIp(java.lang.Integer eipAssociatePublicIp) {
		this.eipAssociatePublicIp = eipAssociatePublicIp;
	}

	@javax.persistence.Column(name = "elastic_lb_service", nullable = false, precision = 10)
	public java.lang.Integer getElasticLbService() {
		return this.elasticLbService;
	}

	public void setElasticLbService(java.lang.Integer elasticLbService) {
		this.elasticLbService = elasticLbService;
	}

	@javax.persistence.Column(name = "specify_ip_ranges", nullable = false, precision = 10)
	public java.lang.Integer getSpecifyIpRanges() {
		return this.specifyIpRanges;
	}

	public void setSpecifyIpRanges(java.lang.Integer specifyIpRanges) {
		this.specifyIpRanges = specifyIpRanges;
	}

	@javax.persistence.Column(name = "inline", nullable = false, precision = 10)
	public java.lang.Integer getInline() {
		return this.inline;
	}

	public void setInline(java.lang.Integer inline) {
		this.inline = inline;
	}

	@javax.persistence.Column(name = "is_persistent", nullable = false, precision = 10)
	public java.lang.Integer getIsPersistent() {
		return this.isPersistent;
	}

	public void setIsPersistent(java.lang.Integer isPersistent) {
		this.isPersistent = isPersistent;
	}

	@javax.persistence.Column(name = "internal_lb", nullable = false, precision = 10)
	public java.lang.Integer getInternalLb() {
		return this.internalLb;
	}

	public void setInternalLb(java.lang.Integer internalLb) {
		this.internalLb = internalLb;
	}

	@javax.persistence.Column(name = "public_lb", nullable = false, precision = 10)
	public java.lang.Integer getPublicLb() {
		return this.publicLb;
	}

	public void setPublicLb(java.lang.Integer publicLb) {
		this.publicLb = publicLb;
	}

	@javax.persistence.Column(name = "egress_default_policy", precision = 3)
	public java.lang.Byte getEgressDefaultPolicy() {
		return this.egressDefaultPolicy;
	}

	public void setEgressDefaultPolicy(java.lang.Byte egressDefaultPolicy) {
		this.egressDefaultPolicy = egressDefaultPolicy;
	}

	@javax.persistence.Column(name = "concurrent_connections", precision = 10)
	public java.lang.Integer getConcurrentConnections() {
		return this.concurrentConnections;
	}

	public void setConcurrentConnections(java.lang.Integer concurrentConnections) {
		this.concurrentConnections = concurrentConnections;
	}
}
