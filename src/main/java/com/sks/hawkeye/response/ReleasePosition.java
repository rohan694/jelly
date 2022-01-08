package com.sks.hawkeye.response;

import lombok.AllArgsConstructor;

public class ReleasePosition{
	private double x;
	private double y;
	private double z;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public ReleasePosition(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public ReleasePosition() {
		super();
	}
    
	
    
}
