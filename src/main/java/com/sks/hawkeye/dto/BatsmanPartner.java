package com.sks.hawkeye.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatsmanPartner{
    private String id;
    @JsonProperty("isRightHanded") 
    private boolean rightHanded;
    private String name;
    
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
	public boolean isRightHanded() {
		return rightHanded;
	}
	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}
	
    
}
