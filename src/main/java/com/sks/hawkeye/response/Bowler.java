package com.sks.hawkeye.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bowler{
    private String id;
    @JsonProperty("isRightHanded") 
    private boolean rightHanded;
    private String name;
    private int spell;
    
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
	public int getSpell() {
		return spell;
	}
	public void setSpell(int spell) {
		this.spell = spell;
	}
	public boolean isRightHanded() {
		return rightHanded;
	}
	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}
    
}
