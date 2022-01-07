package com.sks.hawkeye.dto;
public class Match{
    public BattingTeam battingTeam;
    public BowlingTeam bowlingTeam;
    public Delivery delivery;
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
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
