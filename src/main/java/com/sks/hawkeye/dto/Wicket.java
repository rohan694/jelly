package com.sks.hawkeye.dto;
public class Wicket{
    public boolean isWicket;
    public String wicketType;
    public boolean wicketsTaken;
    
	public boolean isWicket() {
		return isWicket;
	}
	public void setWicket(boolean isWicket) {
		this.isWicket = isWicket;
	}
	public String getWicketType() {
		return wicketType;
	}
	public void setWicketType(String wicketType) {
		this.wicketType = wicketType;
	}
	public boolean isWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(boolean wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
    
}
