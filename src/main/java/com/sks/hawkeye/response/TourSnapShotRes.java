package com.sks.hawkeye.response;

import java.util.HashSet;
import java.util.Set;

public class TourSnapShotRes{
    public String country;
    public String format;
    public String international;
    private Set<Match> listMatch  = new HashSet<>();
    public String tourName;

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

	public Set<Match> getListMatch() {
		return listMatch;
	}

	public void setListMatch(Set<Match> listMatch) {
		this.listMatch = listMatch;
	}
	public void addMatch(Match match) {
		this.listMatch.add(match);
	}
}
