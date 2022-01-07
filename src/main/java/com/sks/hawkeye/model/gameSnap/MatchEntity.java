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

@Entity
@Table(name = "Match")
public class MatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public String name;
	
	@OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public BattingTeamEntity battingTeam;
	@OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public BowlingTeamEntity bowlingTeam;
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)	//@PrimaryKeyJoinColumn
	private Set<DeliveryEntity> listDelivery  = new HashSet<>();
	
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tourId")
	private TourSnapShotEntity gameSnapShot;
	
	
	
	public MatchEntity() {	}	
	public MatchEntity(TourSnapShotEntity gameSnapShot) {
		this.gameSnapShot = gameSnapShot;
	}

	public BattingTeamEntity getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(BattingTeamEntity battingTeam) {
		this.battingTeam = battingTeam;
	}

	public BowlingTeamEntity getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(BowlingTeamEntity bowlingTeam) {
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

	public void addDeliveries(Set<DeliveryEntity> listDelivery) {
		if (listDelivery != null) {
			for (DeliveryEntity d : listDelivery) {
				d.setMatch(this);
				this.listDelivery.add(d);
			}
		}
	}
}
