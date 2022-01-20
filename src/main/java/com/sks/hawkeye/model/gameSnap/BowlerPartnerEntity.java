package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity
@Table(name = "BowlerPartner")
public class BowlerPartnerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	private String id;
	@OneToOne
	private BowlingTeamEntity bowlingTeam;
	private boolean rightHanded;
	private String name;
    
    public BowlerPartnerEntity() {}
	public BowlerPartnerEntity(BowlingTeamEntity bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isRightHanded() {
		return rightHanded;
	}
	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BowlingTeamEntity getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(BowlingTeamEntity bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
    
    
}
