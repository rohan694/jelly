package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "FielderPosition")
public class FielderPositionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private DeliveryEntity delivery;
    public boolean firstSlip;
    public boolean secondSlip;
    public boolean thirdSlip;
    public boolean fourthSlip;
    public boolean fifthSlip;
    public boolean backwardsPoint;
    public boolean cover;
    public boolean cowCorner;
    public boolean deepBackwardsSquareLeg;
    public boolean deepCover;
    public boolean deepExtraCover;
    public boolean deepMidWicket;
    public boolean deepPoint;
    public boolean deepSquareLeg;
    public boolean extraCover;
    public boolean fineLeg;
    public boolean flySlip;
    public boolean gully;
    public boolean legGully;
    public boolean legSlip;
    public boolean longLeg;
    public boolean longOff;
    public boolean longOn;
    public boolean midWicket;
    public boolean midOff;
    public boolean midOn;
    public boolean point;
    public boolean shortExtraCover;
    public boolean shortFineLeg;
    public boolean shortLeg;
    public boolean shortMidWicket;
    public boolean sillyMidOff;
    public boolean sillyPoint;
    public boolean squareLeg;
    public boolean thirdMan;
    public boolean wicketKeeper;
    
    public FielderPositionEntity() {}
	public FielderPositionEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DeliveryEntity getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
    
    
}
