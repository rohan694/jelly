package com.sks.hawkeye.model.gameSnap;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TourSnapShot")
public class TourSnapShotEntity {
	@Id
	@Column(name = "tourName", nullable = false)
	public String tourName;
	public String country;
	public String format;
	public String international;
	
	@OneToMany(mappedBy = "gameSnapShot", cascade = CascadeType.ALL)	//@PrimaryKeyJoinColumn
	private Set<MatchEntity> listMatch  = new HashSet<>();
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getInternational() {
		return international;
	}

	public void setInternational(String international) {
		this.international = international;
	}
	
	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public Set<MatchEntity> getListMatch() {
		return listMatch;
	}

	public void setListMatch(Set<MatchEntity> listMatch) {
		this.listMatch = listMatch;
	}
	
	public void addMatch(MatchEntity match) {
		match.setGameSnapShot(this);
		this.listMatch.add(match);
	}

	public MatchEntity getMatch(String matchName) {
		for (MatchEntity m : listMatch) {
			if (m != null && m.getName().equals(matchName)) {
				return m;
			}
		}
		return null;
	}
	

}
