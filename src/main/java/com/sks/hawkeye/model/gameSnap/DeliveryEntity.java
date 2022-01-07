package com.sks.hawkeye.model.gameSnap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class DeliveryEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    public String deliveryType;
    public boolean isPavilionEnd;
    public boolean round;
    public String timecode;
    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "matchId")
	private MatchEntity match;
    
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public AdditionalEventInfoEntity additionalEventInformation;
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public DeliveryNumberEntity deliveryNumber;
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public FielderPositionEntity fielderPosition;
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ScoringInfoEntity scoringInformation;
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public ShotInfoEntity shotInformation;
    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public TrajectoryEntity trajectory;
    
    public DeliveryEntity() {}
	public DeliveryEntity(MatchEntity match) {
		this.match = match;
	}
	public AdditionalEventInfoEntity getAdditionalEventInformation() {
		return additionalEventInformation;
	}
	public void setAdditionalEventInformation(AdditionalEventInfoEntity additionalEventInformation) {
		this.additionalEventInformation = additionalEventInformation;
	}
	public DeliveryNumberEntity getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(DeliveryNumberEntity deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public FielderPositionEntity getFielderPosition() {
		return fielderPosition;
	}
	public void setFielderPosition(FielderPositionEntity fielderPosition) {
		this.fielderPosition = fielderPosition;
	}
	public boolean isPavilionEnd() {
		return isPavilionEnd;
	}
	public void setPavilionEnd(boolean isPavilionEnd) {
		this.isPavilionEnd = isPavilionEnd;
	}
	public boolean isRound() {
		return round;
	}
	public void setRound(boolean round) {
		this.round = round;
	}
	public ScoringInfoEntity getScoringInformation() {
		return scoringInformation;
	}
	public void setScoringInformation(ScoringInfoEntity scoringInformation) {
		this.scoringInformation = scoringInformation;
	}
	public ShotInfoEntity getShotInformation() {
		return shotInformation;
	}
	public void setShotInformation(ShotInfoEntity shotInformation) {
		this.shotInformation = shotInformation;
	}
	public String getTimecode() {
		return timecode;
	}
	public void setTimecode(String timecode) {
		this.timecode = timecode;
	}
	public TrajectoryEntity getTrajectory() {
		return trajectory;
	}
	public void setTrajectory(TrajectoryEntity trajectory) {
		this.trajectory = trajectory;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MatchEntity getMatch() {
		return match;
	}
	public void setMatch(MatchEntity match) {
		this.match = match;
	}
    
    
}