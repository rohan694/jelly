package com.sks.hawkeye.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FielderPosition{
    @JsonProperty("1st Slip") 
    public boolean firstSlip;
    @JsonProperty("2nd Slip") 
    public boolean secondSlip;
    @JsonProperty("3rd Slip") 
    public boolean thirdSlip;
    @JsonProperty("4th Slip") 
    public boolean fourthSlip;
    @JsonProperty("5th Slip") 
    public boolean fifthSlip;
    @JsonProperty("Backwards Point") 
    public boolean backwardsPoint;
    @JsonProperty("Cover") 
    public boolean cover;
    @JsonProperty("Cow Corner") 
    public boolean cowCorner;
    @JsonProperty("Deep Backwards Square Leg") 
    public boolean deepBackwardsSquareLeg;
    @JsonProperty("Deep Cover") 
    public boolean deepCover;
    @JsonProperty("Deep Extra Cover") 
    public boolean deepExtraCover;
    @JsonProperty("Deep Mid Wicket") 
    public boolean deepMidWicket;
    @JsonProperty("Deep Point") 
    public boolean deepPoint;
    @JsonProperty("Deep Square Leg") 
    public boolean deepSquareLeg;
    @JsonProperty("Extra Cover") 
    public boolean extraCover;
    @JsonProperty("Fine Leg") 
    public boolean fineLeg;
    @JsonProperty("Fly Slip") 
    public boolean flySlip;
    @JsonProperty("Gully") 
    public boolean gully;
    @JsonProperty("Leg Gully") 
    public boolean legGully;
    @JsonProperty("Leg Slip") 
    public boolean legSlip;
    @JsonProperty("Long Leg") 
    public boolean longLeg;
    @JsonProperty("Long-off") 
    public boolean longOff;
    @JsonProperty("Long-on") 
    public boolean longOn;
    @JsonProperty("Mid Wicket") 
    public boolean midWicket;
    @JsonProperty("Mid-off") 
    public boolean midOff;
    @JsonProperty("Mid-on") 
    public boolean midOn;
    @JsonProperty("Point") 
    public boolean point;
    @JsonProperty("Short Extra Cover") 
    public boolean shortExtraCover;
    @JsonProperty("Short Fine Leg") 
    public boolean shortFineLeg;
    @JsonProperty("Short Leg") 
    public boolean shortLeg;
    @JsonProperty("Short Mid-wicket") 
    public boolean shortMidWicket;
    @JsonProperty("Silly Mid-off") 
    public boolean sillyMidOff;
    @JsonProperty("Silly Point") 
    public boolean sillyPoint;
    @JsonProperty("Square Leg") 
    public boolean squareLeg;
    @JsonProperty("Third Man") 
    public boolean thirdMan;
    @JsonProperty("Wicket Keeper") 
    public boolean wicketKeeper;
	
	public boolean isFirstSlip() {
		return firstSlip;
	}
	public void setFirstSlip(boolean firstSlip) {
		this.firstSlip = firstSlip;
	}
	public boolean isSecondSlip() {
		return secondSlip;
	}
	public void setSecondSlip(boolean secondSlip) {
		this.secondSlip = secondSlip;
	}
	public boolean isThirdSlip() {
		return thirdSlip;
	}
	public void setThirdSlip(boolean thirdSlip) {
		this.thirdSlip = thirdSlip;
	}
	public boolean isFourthSlip() {
		return fourthSlip;
	}
	public void setFourthSlip(boolean fourthSlip) {
		this.fourthSlip = fourthSlip;
	}
	public boolean isFifthSlip() {
		return fifthSlip;
	}
	public void setFifthSlip(boolean fifthSlip) {
		this.fifthSlip = fifthSlip;
	}
	public boolean isBackwardsPoint() {
		return backwardsPoint;
	}
	public void setBackwardsPoint(boolean backwardsPoint) {
		this.backwardsPoint = backwardsPoint;
	}
	public boolean isCover() {
		return cover;
	}
	public void setCover(boolean cover) {
		this.cover = cover;
	}
	public boolean isCowCorner() {
		return cowCorner;
	}
	public void setCowCorner(boolean cowCorner) {
		this.cowCorner = cowCorner;
	}
	public boolean isDeepBackwardsSquareLeg() {
		return deepBackwardsSquareLeg;
	}
	public void setDeepBackwardsSquareLeg(boolean deepBackwardsSquareLeg) {
		this.deepBackwardsSquareLeg = deepBackwardsSquareLeg;
	}
	public boolean isDeepCover() {
		return deepCover;
	}
	public void setDeepCover(boolean deepCover) {
		this.deepCover = deepCover;
	}
	public boolean isDeepExtraCover() {
		return deepExtraCover;
	}
	public void setDeepExtraCover(boolean deepExtraCover) {
		this.deepExtraCover = deepExtraCover;
	}
	public boolean isDeepMidWicket() {
		return deepMidWicket;
	}
	public void setDeepMidWicket(boolean deepMidWicket) {
		this.deepMidWicket = deepMidWicket;
	}
	public boolean isDeepPoint() {
		return deepPoint;
	}
	public void setDeepPoint(boolean deepPoint) {
		this.deepPoint = deepPoint;
	}
	public boolean isDeepSquareLeg() {
		return deepSquareLeg;
	}
	public void setDeepSquareLeg(boolean deepSquareLeg) {
		this.deepSquareLeg = deepSquareLeg;
	}
	public boolean isExtraCover() {
		return extraCover;
	}
	public void setExtraCover(boolean extraCover) {
		this.extraCover = extraCover;
	}
	public boolean isFineLeg() {
		return fineLeg;
	}
	public void setFineLeg(boolean fineLeg) {
		this.fineLeg = fineLeg;
	}
	public boolean isFlySlip() {
		return flySlip;
	}
	public void setFlySlip(boolean flySlip) {
		this.flySlip = flySlip;
	}
	public boolean isGully() {
		return gully;
	}
	public void setGully(boolean gully) {
		this.gully = gully;
	}
	public boolean isLegGully() {
		return legGully;
	}
	public void setLegGully(boolean legGully) {
		this.legGully = legGully;
	}
	public boolean isLegSlip() {
		return legSlip;
	}
	public void setLegSlip(boolean legSlip) {
		this.legSlip = legSlip;
	}
	public boolean isLongLeg() {
		return longLeg;
	}
	public void setLongLeg(boolean longLeg) {
		this.longLeg = longLeg;
	}
	public boolean isLongOff() {
		return longOff;
	}
	public void setLongOff(boolean longOff) {
		this.longOff = longOff;
	}
	public boolean isLongOn() {
		return longOn;
	}
	public void setLongOn(boolean longOn) {
		this.longOn = longOn;
	}
	public boolean isMidWicket() {
		return midWicket;
	}
	public void setMidWicket(boolean midWicket) {
		this.midWicket = midWicket;
	}
	public boolean isMidOff() {
		return midOff;
	}
	public void setMidOff(boolean midOff) {
		this.midOff = midOff;
	}
	public boolean isMidOn() {
		return midOn;
	}
	public void setMidOn(boolean midOn) {
		this.midOn = midOn;
	}
	public boolean isPoint() {
		return point;
	}
	public void setPoint(boolean point) {
		this.point = point;
	}
	public boolean isShortExtraCover() {
		return shortExtraCover;
	}
	public void setShortExtraCover(boolean shortExtraCover) {
		this.shortExtraCover = shortExtraCover;
	}
	public boolean isShortFineLeg() {
		return shortFineLeg;
	}
	public void setShortFineLeg(boolean shortFineLeg) {
		this.shortFineLeg = shortFineLeg;
	}
	public boolean isShortLeg() {
		return shortLeg;
	}
	public void setShortLeg(boolean shortLeg) {
		this.shortLeg = shortLeg;
	}
	public boolean isShortMidWicket() {
		return shortMidWicket;
	}
	public void setShortMidWicket(boolean shortMidWicket) {
		this.shortMidWicket = shortMidWicket;
	}
	public boolean isSillyMidOff() {
		return sillyMidOff;
	}
	public void setSillyMidOff(boolean sillyMidOff) {
		this.sillyMidOff = sillyMidOff;
	}
	public boolean isSillyPoint() {
		return sillyPoint;
	}
	public void setSillyPoint(boolean sillyPoint) {
		this.sillyPoint = sillyPoint;
	}
	public boolean isSquareLeg() {
		return squareLeg;
	}
	public void setSquareLeg(boolean squareLeg) {
		this.squareLeg = squareLeg;
	}
	public boolean isThirdMan() {
		return thirdMan;
	}
	public void setThirdMan(boolean thirdMan) {
		this.thirdMan = thirdMan;
	}
	public boolean isWicketKeeper() {
		return wicketKeeper;
	}
	public void setWicketKeeper(boolean wicketKeeper) {
		this.wicketKeeper = wicketKeeper;
	}
    
    
}
