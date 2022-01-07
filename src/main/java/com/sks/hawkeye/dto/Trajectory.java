package com.sks.hawkeye.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trajectory{
    public BatStatPosition batStatPosition;
    public boolean bounceAboveStumps;
    public double bounceAngle;
    public BouncePosition bouncePosition;
    public double cof;
    public double cor;
    public CreasePosition creasePosition;
    public double deviation;
    public double dropAngle;
    private Boolean hitStumps;
    public ImpactPosition impactPosition;
    public double initialAngle;
    public LandingPosition landingPosition;
    public int length;
    public double offBatAngle;
    public double offBatSpeed;
    public double pbr;
    @JsonProperty("reactionTime(to crease)") 
    public double reactionTimeToCrease;
    @JsonProperty("reactionTime(to interception)") 
    public double reactionTimeToInterception;
    public double realDistance;
    public ReleasePosition releasePosition;
    public double releaseSpeed;
    public double spinRate;
    public StumpPosition stumpPosition;
    public double swing;
    public String trajectoryData;
	public BatStatPosition getBatStatPosition() {
		return batStatPosition;
	}
	public void setBatStatPosition(BatStatPosition batStatPosition) {
		this.batStatPosition = batStatPosition;
	}
	public boolean isBounceAboveStumps() {
		return bounceAboveStumps;
	}
	public void setBounceAboveStumps(boolean bounceAboveStumps) {
		this.bounceAboveStumps = bounceAboveStumps;
	}
	public double getBounceAngle() {
		return bounceAngle;
	}
	public void setBounceAngle(double bounceAngle) {
		this.bounceAngle = bounceAngle;
	}
	public BouncePosition getBouncePosition() {
		return bouncePosition;
	}
	public void setBouncePosition(BouncePosition bouncePosition) {
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
	public CreasePosition getCreasePosition() {
		return creasePosition;
	}
	public void setCreasePosition(CreasePosition creasePosition) {
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
	
	public ImpactPosition getImpactPosition() {
		return impactPosition;
	}
	public void setImpactPosition(ImpactPosition impactPosition) {
		this.impactPosition = impactPosition;
	}
	public double getInitialAngle() {
		return initialAngle;
	}
	public void setInitialAngle(double initialAngle) {
		this.initialAngle = initialAngle;
	}
	public LandingPosition getLandingPosition() {
		return landingPosition;
	}
	public void setLandingPosition(LandingPosition landingPosition) {
		this.landingPosition = landingPosition;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
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
	public ReleasePosition getReleasePosition() {
		return releasePosition;
	}
	public void setReleasePosition(ReleasePosition releasePosition) {
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
	public StumpPosition getStumpPosition() {
		return stumpPosition;
	}
	public void setStumpPosition(StumpPosition stumpPosition) {
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
	public Boolean getHitStumps() {
		return hitStumps;
	}
	public void setHitStumps(Boolean hitStumps) {
		this.hitStumps = hitStumps;
	}
    
    
}
