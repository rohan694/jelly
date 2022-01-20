package com.sks.hawkeye.model.gameSnap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "BattingTeam")
public class BattingTeamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	private String battingTeamId;
	
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "matchId")
	private MatchEntity match;
    public boolean home;
    
    public String name;
    
    @OneToOne(mappedBy = "battingTeam", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public BatsmanEntity batsman;
    @OneToOne(mappedBy = "battingTeam", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public BatsmanPartnerEntity batsmanPartner;
    public BattingTeamEntity() {	}
	public BattingTeamEntity(MatchEntity match) {
		this.match = match;
	}
	public BatsmanEntity getBatsman() {
		return batsman;
	}
	public void setBatsman(BatsmanEntity batsman) {
		this.batsman = batsman;
	}
	public BatsmanPartnerEntity getBatsmanPartner() {
		return batsmanPartner;
	}
	public void setBatsmanPartner(BatsmanPartnerEntity batsmanPartner) {
		this.batsmanPartner = batsmanPartner;
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
		return battingTeamId;
	}
	public void setId(String id) {
		this.battingTeamId = id;
	}
	public MatchEntity getMatch() {
		return match;
	}
	public void setMatch(MatchEntity match) {
		this.match = match;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
    
    
}
