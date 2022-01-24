package com.sks.hawkeye.dto;

import lombok.ToString;

public class TourSnapShot{
    public String country;
    public String format;
    public String international;
    public Match match;
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

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getMatchName() {
		return match != null ? match.getName() : null;
	}

}
