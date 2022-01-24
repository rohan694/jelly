package com.sks.hawkeye.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BatsmanPartner{
    private BigInteger id;
    @JsonProperty("isRightHanded") 
    private boolean rightHanded;
    private String name;
    
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
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
