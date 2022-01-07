package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShotInfo")
public class ShotInfoEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private DeliveryEntity delivery;
    public String batsmanWeight;
    public String shotAttacked;
    public String shotPlayed;
    public String shotTypeAdditional;
    
    public ShotInfoEntity() {}
	public ShotInfoEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	
	public String getBatsmanWeight() {
		return batsmanWeight;
	}
	public void setBatsmanWeight(String batsmanWeight) {
		this.batsmanWeight = batsmanWeight;
	}
	public String getShotAttacked() {
		return shotAttacked;
	}
	public void setShotAttacked(String shotAttacked) {
		this.shotAttacked = shotAttacked;
	}
	public String getShotPlayed() {
		return shotPlayed;
	}
	public void setShotPlayed(String shotPlayed) {
		this.shotPlayed = shotPlayed;
	}
	public String getShotTypeAdditional() {
		return shotTypeAdditional;
	}
	public void setShotTypeAdditional(String shotTypeAdditional) {
		this.shotTypeAdditional = shotTypeAdditional;
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