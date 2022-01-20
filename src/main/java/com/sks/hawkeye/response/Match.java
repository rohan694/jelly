package com.sks.hawkeye.response;

import java.util.HashSet;
import java.util.Set;


public class Match{
    public Set<BattingTeam> battingTeam;
    public Set<BowlingTeam> bowlingTeam;
    private Set<Delivery> listDelivery  = new HashSet<>();
    public String name;
	
	
	public Set<BattingTeam> getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(Set<BattingTeam> battingTeam) {
		this.battingTeam = battingTeam;
	}
	public Set<BowlingTeam> getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(Set<BowlingTeam> bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}
	
	public void addBattingTeam(BattingTeam battingTeam) {
		this.battingTeam.add(battingTeam);
	}
	
	public void addBowlingTeam(BowlingTeam bowlingTeam) {
		this.bowlingTeam.add(bowlingTeam);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Delivery> getListDelivery() {
		return listDelivery;
	}
	public void setListDelivery(Set<Delivery> listDelivery) {
		this.listDelivery = listDelivery;
	}
	public void addDelivery(Delivery delivery) {
		this.listDelivery.add(delivery);
	}
    
}
