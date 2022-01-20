package com.sks.hawkeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sks.hawkeye.model.gameSnap.BattingTeamEntity;

public interface BatsmanTeamRepository extends JpaRepository<BattingTeamEntity, String> {

	BattingTeamEntity getByBattingTeamId(String battingTeamId);

}
