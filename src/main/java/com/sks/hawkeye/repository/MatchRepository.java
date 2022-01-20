package com.sks.hawkeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.hawkeye.model.gameSnap.MatchEntity;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

	MatchEntity getByName(String name);

}
