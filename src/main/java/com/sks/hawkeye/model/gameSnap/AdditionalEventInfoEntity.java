package com.sks.hawkeye.model.gameSnap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AdditionalEventInfo")
public class AdditionalEventInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private DeliveryEntity delivery;
	
	private boolean dropped;

	public AdditionalEventInfoEntity() {}
	public AdditionalEventInfoEntity(DeliveryEntity delivery) {
		this.delivery = delivery;
	}
	
	public boolean isDropped() {
		return dropped;
	}

	public void setDropped(boolean dropped) {
		this.dropped = dropped;
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
