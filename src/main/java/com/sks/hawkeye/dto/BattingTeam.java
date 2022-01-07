package com.sks.hawkeye.dto;

public class BattingTeam{
    public Batsman batsman;
    public BatsmanPartner batsmanPartner;
    public boolean home;
    public String id;
    public String name;
    
	public Batsman getBatsman() {
		return batsman;
	}
	public void setBatsman(Batsman batsman) {
		this.batsman = batsman;
	}
	public BatsmanPartner getBatsmanPartner() {
		return batsmanPartner;
	}
	public void setBatsmanPartner(BatsmanPartner batsmanPartner) {
		this.batsmanPartner = batsmanPartner;
	}
	public boolean isHome() {
		return home;
	}
	public void setHome(boolean home) {
		this.home = home;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
