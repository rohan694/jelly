package com.sks.hawkeye.dto;
public class ScoringInformation{
    public boolean boundary;
    public int extrasScore;
    public String extrasType;
    public boolean overthrowScore;
    public int score;
    public Wicket wicket;
	public boolean isBoundary() {
		return boundary;
	}
	public void setBoundary(boolean boundary) {
		this.boundary = boundary;
	}
	public int getExtrasScore() {
		return extrasScore;
	}
	public void setExtrasScore(int extrasScore) {
		this.extrasScore = extrasScore;
	}
	public String getExtrasType() {
		return extrasType;
	}
	public void setExtrasType(String extrasType) {
		this.extrasType = extrasType;
	}
	public boolean isOverthrowScore() {
		return overthrowScore;
	}
	public void setOverthrowScore(boolean overthrowScore) {
		this.overthrowScore = overthrowScore;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Wicket getWicket() {
		return wicket;
	}
	public void setWicket(Wicket wicket) {
		this.wicket = wicket;
	}
    
    
}
