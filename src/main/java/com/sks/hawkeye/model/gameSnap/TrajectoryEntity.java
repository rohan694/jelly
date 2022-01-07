package com.sks.hawkeye.model.gameSnap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "Trajectory")
public class TrajectoryEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private Boolean bounceAboveStumps;
    public double bounceAngle;
    public double cof;
    public double cor;
    public double deviation;
    public double dropAngle;
    public Boolean hitStumps;
    public double initialAngle;
    private Integer length;
    public double offBatAngle;
    public double offBatSpeed;
    public double pbr;
    public double reactionTimeToCrease;
    public double reactionTimeToInterception;
    public double realDistance;
    public double releaseSpeed;
    public double spinRate;
    public double swing;
    @Column(length = 2000)
    public String trajectoryData;
    
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public BouncePositionEntity bouncePosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public CreasePositionEntity creasePosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ReleasePositionEntity releasePosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ImpactPositionEntity impactPosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public LandingPositionEntity landingPosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public StumpPositionEntity stumpPosition;
    @OneToOne(mappedBy = "trajectory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public BatStatPositionEntity batStatPosition;
    @OneToOne
    private DeliveryEntity delivery;
    
    public TrajectoryEntity() {}
	public TrajectoryEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	public BatStatPositionEntity getBatStatPosition() {
		return batStatPosition;
	}
	public void setBatStatPosition(BatStatPositionEntity batStatPosition) {
		this.batStatPosition = batStatPosition;
	}
	
	public double getBounceAngle() {
		return bounceAngle;
	}
	public void setBounceAngle(double bounceAngle) {
		this.bounceAngle = bounceAngle;
	}
	public BouncePositionEntity getBouncePosition() {
		return bouncePosition;
	}
	public void setBouncePosition(BouncePositionEntity bouncePosition) {
		this.bouncePosition = bouncePosition;
	}
	public double getCof() {
		return cof;
	}
	public void setCof(double cof) {
		this.cof = cof;
	}
	public double getCor() {
		return cor;
	}
	public void setCor(double cor) {
		this.cor = cor;
	}
	public CreasePositionEntity getCreasePosition() {
		return creasePosition;
	}
	public void setCreasePosition(CreasePositionEntity creasePosition) {
		this.creasePosition = creasePosition;
	}
	public double getDeviation() {
		return deviation;
	}
	public void setDeviation(double deviation) {
		this.deviation = deviation;
	}
	public double getDropAngle() {
		return dropAngle;
	}
	public void setDropAngle(double dropAngle) {
		this.dropAngle = dropAngle;
	}
	public Boolean getHitStumps() {
		return hitStumps;
	}
	public void setHitStumps(Boolean hitStumps) {
		this.hitStumps = hitStumps;
	}
	public ImpactPositionEntity getImpactPosition() {
		return impactPosition;
	}
	public void setImpactPosition(ImpactPositionEntity impactPosition) {
		this.impactPosition = impactPosition;
	}
	public double getInitialAngle() {
		return initialAngle;
	}
	public void setInitialAngle(double initialAngle) {
		this.initialAngle = initialAngle;
	}
	public LandingPositionEntity getLandingPosition() {
		return landingPosition;
	}
	public void setLandingPosition(LandingPositionEntity landingPosition) {
		this.landingPosition = landingPosition;
	}
	
	public double getOffBatAngle() {
		return offBatAngle;
	}
	public void setOffBatAngle(double offBatAngle) {
		this.offBatAngle = offBatAngle;
	}
	public double getOffBatSpeed() {
		return offBatSpeed;
	}
	public void setOffBatSpeed(double offBatSpeed) {
		this.offBatSpeed = offBatSpeed;
	}
	public double getPbr() {
		return pbr;
	}
	public void setPbr(double pbr) {
		this.pbr = pbr;
	}
	public double getReactionTimeToCrease() {
		return reactionTimeToCrease;
	}
	public void setReactionTimeToCrease(double reactionTimeToCrease) {
		this.reactionTimeToCrease = reactionTimeToCrease;
	}
	public double getReactionTimeToInterception() {
		return reactionTimeToInterception;
	}
	public void setReactionTimeToInterception(double reactionTimeToInterception) {
		this.reactionTimeToInterception = reactionTimeToInterception;
	}
	public double getRealDistance() {
		return realDistance;
	}
	public void setRealDistance(double realDistance) {
		this.realDistance = realDistance;
	}
	public ReleasePositionEntity getReleasePosition() {
		return releasePosition;
	}
	public void setReleasePosition(ReleasePositionEntity releasePosition) {
		this.releasePosition = releasePosition;
	}
	public double getReleaseSpeed() {
		return releaseSpeed;
	}
	public void setReleaseSpeed(double releaseSpeed) {
		this.releaseSpeed = releaseSpeed;
	}
	public double getSpinRate() {
		return spinRate;
	}
	public void setSpinRate(double spinRate) {
		this.spinRate = spinRate;
	}
	public StumpPositionEntity getStumpPosition() {
		return stumpPosition;
	}
	public void setStumpPosition(StumpPositionEntity stumpPosition) {
		this.stumpPosition = stumpPosition;
	}
	public double getSwing() {
		return swing;
	}
	public void setSwing(double swing) {
		this.swing = swing;
	}
	public String getTrajectoryData() {
		return trajectoryData;
	}
	public void setTrajectoryData(String trajectoryData) {
		this.trajectoryData = trajectoryData;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DeliveryEntity getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Boolean isBounceAboveStumps() {
		return bounceAboveStumps;
	}
	public void setBounceAboveStumps(Boolean bounceAboveStumps) {
		this.bounceAboveStumps = bounceAboveStumps;
	}
	
    
}