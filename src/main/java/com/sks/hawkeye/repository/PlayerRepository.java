package com.sks.hawkeye.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.hawkeye.model.gameSnap.PlayerEntity;
import com.sks.hawkeye.model.gameSnap.TeamEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, BigInteger> {

	PlayerEntity getByPlayerId(BigInteger playerId);

	Optional<PlayerEntity> findByPlayerId(BigInteger playerId);
	
}
