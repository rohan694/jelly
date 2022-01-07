package com.sks.hawkeye.response;

import java.util.HashSet;
import java.util.Set;


public class Match{
    public BattingTeam battingTeam;
    public BowlingTeam bowlingTeam;
    private Set<Delivery> listDelivery  = new HashSet<>();
    public String name;
	public BattingTeam getBattingTeam() {
		return battingTeam;
	}
	public void setBattingTeam(BattingTeam battingTeam) {
		this.battingTeam = battingTeam;
	}
	public BowlingTeam getBowlingTeam() {
		return bowlingTeam;
	}
	public void setBowlingTeam(BowlingTeam bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
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
