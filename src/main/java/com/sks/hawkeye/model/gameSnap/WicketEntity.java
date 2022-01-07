package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Wicket")
public class WicketEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private ScoringInfoEntity scoringInformation;
    public Boolean wicket;
    public String wicketType;
    public Boolean wicketsTaken;
    
    public WicketEntity() {}
	public WicketEntity(ScoringInfoEntity scoringInformation) {
		this.scoringInformation = scoringInformation;
	}
	public Boolean isWicket() {
		return wicket;
	}
	public void setWicket(Boolean isWicket) {
		this.wicket = isWicket;
	}
	public String getWicketType() {
		return wicketType;
	}
	public void setWicketType(String wicketType) {
		this.wicketType = wicketType;
	}
	public Boolean isWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(Boolean wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ScoringInfoEntity getScoringInformation() {
		return scoringInformation;
	}
	public void setScoringInformation(ScoringInfoEntity scoringInformation) {
		this.scoringInformation = scoringInformation;
	}
	
    
    
}
