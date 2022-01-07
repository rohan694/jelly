package com.sks.hawkeye.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Batsman{
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
	public boolean isRightHanded() {
		return rightHanded;
	}
	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
