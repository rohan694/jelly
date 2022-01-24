package com.sks.hawkeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.hawkeye.model.gameSnap.DeliveryEntity;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;

@Repository
public interface DeliveryRepository  extends JpaRepository<DeliveryEntity, String> {
	
}
