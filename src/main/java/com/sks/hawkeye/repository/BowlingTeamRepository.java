package com.sks.hawkeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.hawkeye.model.gameSnap.BowlingTeamEntity;

public interface BowlingTeamRepository extends JpaRepository<BowlingTeamEntity, String> {

	BowlingTeamEntity getByBowlingTeamId(String id);

}
