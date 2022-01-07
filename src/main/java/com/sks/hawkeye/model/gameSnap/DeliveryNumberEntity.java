package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DeliveryNumber")
public class DeliveryNumberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private DeliveryEntity delivery;
	public int ball;
    public int day;
    public int innings;
    public int over;
    
    public DeliveryNumberEntity() {}
	public DeliveryNumberEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getInnings() {
		return innings;
	}
	public void setInnings(int innings) {
		this.innings = innings;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
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
