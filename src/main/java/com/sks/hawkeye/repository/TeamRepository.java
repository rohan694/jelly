package com.sks.hawkeye.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.hawkeye.model.gameSnap.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, String> {

	Optional<TeamEntity> findByTeamName(String name);

	//TeamEntity getByTeamName(String name);

}
