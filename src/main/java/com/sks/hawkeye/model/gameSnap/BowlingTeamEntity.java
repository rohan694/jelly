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

import lombok.ToString;

@ToString
@Entity
@Table(name = "BowlingTeam")
public class BowlingTeamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	private String bowlingTeamId;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "matchId")
	private MatchEntity match;
	public boolean home;
	public String name;
	
	@OneToOne(mappedBy = "bowlingTeam", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn	
	public BowlerEntity bowler;
	@OneToOne(mappedBy = "bowlingTeam", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public BowlerPartnerEntity bowlerPartner;
	
	public BowlingTeamEntity() {}
	public BowlingTeamEntity(MatchEntity match) {
		this.match = match;
	}
	
	public BowlerEntity getBowler() {
		return bowler;
	}
	public void setBowler(BowlerEntity bowler) {
		this.bowler = bowler;
	}
	public BowlerPartnerEntity getBowlerPartner() {
		return bowlerPartner;
	}
	public void setBowlerPartner(BowlerPartnerEntity bowlerPartner) {
		this.bowlerPartner = bowlerPartner;
	}
	public boolean isHome() {
		return home;
	}
	public void setHome(boolean home) {
		this.home = home;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return bowlingTeamId;
	}
	public void setId(String id) {
		this.bowlingTeamId = id;
	}
	public MatchEntity getMatch() {
		return match;
	}
	public void setMatch(MatchEntity match) {
		this.match = match;
	}
    
    
}
