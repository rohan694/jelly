package com.sks.hawkeye.model.gameSnap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ScoringInfo")
public class ScoringInfoEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public int extrasScore;
	
    public Boolean boundary;
    public String extrasType;
    public Boolean overthrowScore;
    public int score;
    
    @OneToOne(mappedBy = "scoringInformation", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
    public WicketEntity wicket;
    
    @OneToOne
    private DeliveryEntity delivery;
    
    public ScoringInfoEntity() {}
	public ScoringInfoEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	
	public Boolean isBoundary() {
		return boundary;
	}
	public void setBoundary(Boolean boundary) {
		this.boundary = boundary;
	}
	public int getExtrasScore() {
		return extrasScore;
	}
	public void setExtrasScore(int extrasScore) {
		this.extrasScore = extrasScore;
	}
	public String getExtrasType() {
		return extrasType;
	}
	public void setExtrasType(String extrasType) {
		this.extrasType = extrasType;
	}
	public Boolean isOverthrowScore() {
		return overthrowScore;
	}
	public void setOverthrowScore(Boolean overthrowScore) {
		this.overthrowScore = overthrowScore;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public WicketEntity getWicket() {
		return wicket;
	}
	public void setWicket(WicketEntity wicket) {
		this.wicket = wicket;
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
	
    
    
}
