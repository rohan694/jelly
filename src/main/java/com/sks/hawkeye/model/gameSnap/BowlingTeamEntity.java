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
@Table(name = "BowlingTeam")
public class BowlingTeamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
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
