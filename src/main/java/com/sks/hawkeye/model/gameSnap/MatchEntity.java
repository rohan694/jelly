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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.ToString;

@ToString
@Entity
@Table(name = "Match")
public class MatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public String name;
	public String team1;
	public String team2;
	public String venue;
	
	@ManyToMany
	@JoinTable(
			  name = "match_team_mapping", 
			  joinColumns = @JoinColumn(name = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "teamName"))
	//@NotFound(action = NotFoundAction.IGNORE)
	public Set<TeamEntity> participatingTeams = new HashSet<TeamEntity>();

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)	//@PrimaryKeyJoinColumn
	private Set<DeliveryEntity> listDelivery  = new HashSet<>();
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tourId")
	private TourSnapShotEntity gameSnapShot;
	
	
	
	public MatchEntity() {	}	
	public MatchEntity(TourSnapShotEntity gameSnapShot) {
		this.gameSnapShot = gameSnapShot;
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
	public void addParticipatingTeams(TeamEntity team) {
		team.addMatch(this);
		this.participatingTeams.add(team);
	}

	public void addDeliveries(Set<DeliveryEntity> listDelivery) {
		if (listDelivery != null) {
			for (DeliveryEntity d : listDelivery) {
				d.setMatch(this);
				this.listDelivery.add(d);
			}
		}
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Set<TeamEntity> getParticipatingTeams() {
		return participatingTeams;
	}
	public void setParticipatingTeams(Set<TeamEntity> participatingTeams) {
		this.participatingTeams = participatingTeams;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
}
