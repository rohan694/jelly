package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BatsmanPartner")
public class BatsmanPartnerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	@OneToOne
	private BattingTeamEntity battingTeam;
	private String id;
	private boolean rightHanded;
	private String name;
	
    public BatsmanPartnerEntity() {	}
	public BatsmanPartnerEntity(BattingTeamEntity battingTeam) {
		this.battingTeam = battingTeam;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BattingTeamEntity getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(BattingTeamEntity battingTeam) {
		this.battingTeam = battingTeam;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
    
}
