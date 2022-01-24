package com.sks.hawkeye.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.hawkeye.model.gameSnap.MatchEntity;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;

@Repository
public interface GameSnapRepository extends JpaRepository<TourSnapShotEntity, String> {

	TourSnapShotEntity getByTourName(String tourName);

	Optional<TourSnapShotEntity> findByTourName(String tourName);

}
