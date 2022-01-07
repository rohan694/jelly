package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bowler")
public class BowlerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	private String id;
	@OneToOne
	private BowlingTeamEntity bowlingTeam;
    private boolean rightHanded;
    private String name;
    private int spell;
    
    public BowlerEntity() {}
	public BowlerEntity(BowlingTeamEntity bowlingTeam) {
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
	public int getSpell() {
		return spell;
	}
	public void setSpell(int spell) {
		this.spell = spell;
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
