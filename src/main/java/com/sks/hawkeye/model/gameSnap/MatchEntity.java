package com.sks.hawkeye.model.gameSnap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity
@Table(name = "Match")
public class MatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public String name;
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Set<BattingTeamEntity> battingTeam = new HashSet<BattingTeamEntity>();
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Set<BowlingTeamEntity> bowlingTeam = new HashSet<BowlingTeamEntity>();
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)	//@PrimaryKeyJoinColumn
	private Set<DeliveryEntity> listDelivery  = new HashSet<>();
	
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tourId")
	private TourSnapShotEntity gameSnapShot;
	
	
	
	public MatchEntity() {	}	
	public MatchEntity(TourSnapShotEntity gameSnapShot) {
		this.gameSnapShot = gameSnapShot;
	}

	public Set<BattingTeamEntity> getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(Set<BattingTeamEntity> battingTeam) {
		this.battingTeam = battingTeam;
	}

	public Set<BowlingTeamEntity> getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(Set<BowlingTeamEntity> bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
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

	public TourSnapShotEntity getGameSnapShot() {
		return gameSnapShot;
	}

	public void setGameSnapShot(TourSnapShotEntity gameSnapShot) {
		this.gameSnapShot = gameSnapShot;
	}
	public Set<DeliveryEntity> getListDelivery() {
		return listDelivery;
	}
	public void setListDelivery(Set<DeliveryEntity> listDelivery) {
		this.listDelivery = listDelivery;
	}
	public void addDelivery(DeliveryEntity delivery) {
		delivery.setMatch(this);
		this.listDelivery.add(delivery);
	}
	public void addBatsmanEntity(BattingTeamEntity batting) {
		batting.setMatch(this);
		this.battingTeam.add(batting);
	}
	public void addBowlingEntity(BowlingTeamEntity bowling) {
		bowling.setMatch(this);
		this.bowlingTeam.add(bowling);
	}
	
	public void addBatsmanEntities(Set<BattingTeamEntity> listBatsmanEntity) {
		if (listBatsmanEntity != null) {
			for(BattingTeamEntity be : listBatsmanEntity) {
				be.setMatch(this);
				this.battingTeam.add(be);
			}
		}
	}
	
	public void addBowlerEntities(Set<BowlingTeamEntity> listBowlerEntity) {
		if (listBowlerEntity != null) {
			for(BowlingTeamEntity be : listBowlerEntity) {
				be.setMatch(this);
				this.bowlingTeam.add(be);
			}
		}
	}


	public void addDeliveries(Set<DeliveryEntity> listDelivery) {
		if (listDelivery != null) {
			for (DeliveryEntity d : listDelivery) {
				d.setMatch(this);
				this.listDelivery.add(d);
			}
		}
	}
}
