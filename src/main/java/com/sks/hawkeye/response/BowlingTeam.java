package com.sks.hawkeye.response;
public class BowlingTeam{
    private Bowler bowler;
    private BowlerPartner bowlerPartner;
    private boolean home;
    private String name;
    
	public Bowler getBowler() {
		return bowler;
	}
	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}
	public BowlerPartner getBowlerPartner() {
		return bowlerPartner;
	}
	public void setBowlerPartner(BowlerPartner bowlerPartner) {
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
    
    
}
