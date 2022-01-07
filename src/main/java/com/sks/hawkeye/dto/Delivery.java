package com.sks.hawkeye.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Delivery{
    private AdditionalEventInformation additionalEventInformation;
    private DeliveryNumber deliveryNumber;
    private String deliveryType;
    private FielderPosition fielderPosition;
    @JsonProperty("isPavilionEnd")
    private boolean pavilionEnd;
    private boolean round;
    private ScoringInformation scoringInformation;
    private ShotInformation shotInformation;
    private String timecode;
    private Trajectory trajectory;
    
	public AdditionalEventInformation getAdditionalEventInformation() {
		return additionalEventInformation;
	}
	public void setAdditionalEventInformation(AdditionalEventInformation additionalEventInformation) {
		this.additionalEventInformation = additionalEventInformation;
	}
	public DeliveryNumber getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(DeliveryNumber deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public FielderPosition getFielderPosition() {
		return fielderPosition;
	}
	public void setFielderPosition(FielderPosition fielderPosition) {
		this.fielderPosition = fielderPosition;
	}
	
	public boolean isRound() {
		return round;
	}
	public void setRound(boolean round) {
		this.round = round;
	}
	public ScoringInformation getScoringInformation() {
		return scoringInformation;
	}
	public void setScoringInformation(ScoringInformation scoringInformation) {
		this.scoringInformation = scoringInformation;
	}
	public ShotInformation getShotInformation() {
		return shotInformation;
	}
	public void setShotInformation(ShotInformation shotInformation) {
		this.shotInformation = shotInformation;
	}
	public String getTimecode() {
		return timecode;
	}
	public void setTimecode(String timecode) {
		this.timecode = timecode;
	}
	public Trajectory getTrajectory() {
		return trajectory;
	}
	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}
	public boolean isPavilionEnd() {
		return pavilionEnd;
	}
	public void setPavilionEnd(boolean pavilionEnd) {
		this.pavilionEnd = pavilionEnd;
	}
    
    
}
