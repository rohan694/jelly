package com.sks.hawkeye.service;

import java.io.ByteArrayInputStream;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.model.gameSnap.MatchEntity;
import com.sks.hawkeye.model.gameSnap.TeamEntity;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;
import com.sks.hawkeye.repository.FileDBRepository;
import com.sks.hawkeye.repository.GameSnapRepository;
import com.sks.hawkeye.repository.MatchRepository;
import com.sks.hawkeye.repository.TeamRepository;
import com.sks.hawkeye.response.BattingTeam;
import com.sks.hawkeye.response.BowlingTeam;
import com.sks.hawkeye.response.Match;
import com.sks.hawkeye.response.TourSnapShotRes;
import com.sks.hawkeye.util.GameSnapUtil;

@Service
public class GameSnapServiceImpl implements GameSnapService {

	@Autowired
	private FileDBRepository fileDBRepository;

	@Autowired
	private GameSnapRepository gameSnapRepository;
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private GameSnapUtil gameSnapUtil;
	
	@Autowired
	private MatchRepository matchRepo;

	@Override
	public void processGameSnap(String fileId) {

		FileDB fileDb = fileDBRepository.findById(fileId).get();
		if (fileDb != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				InputStream inputStream = new ByteArrayInputStream(fileDb.getData());
				TourSnapShot ts = mapper.readValue(inputStream, new TypeReference<TourSnapShot>() {});
				TourSnapShotEntity tse = gameSnapRepository.getByTourName(ts.getTourName());
				//MatchEntity mte = matchRepo.getByName(ts.getMatchName());
				
				//TeamEntity bwte = teamRepo.getByTeamId(ts.getMatch().getBowlingTeam().getId());
				
				//TeamEntity bte = teamRepo.getByTeamId(ts.getMatch().getBattingTeam().getId());

				tse = gameSnapUtil.prepare(tse, ts);
				
				gameSnapRepository.save(tse);
				
				System.out.println("Game Snap Saved!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Unable to save users: " + e);
			}
		}
	}
	

	@Override
	public void processGameSnapUsingTourSnap(TourSnapShot ts) {

			ObjectMapper mapper = new ObjectMapper();
			
			try {
				TourSnapShotEntity tse = gameSnapRepository.getByTourName(ts.getTourName());
				//MatchEntity mte = matchRepo.getByName(ts.getMatchName());
				
				//TeamEntity bwte = teamRepo.getByTeamId(ts.getMatch().getBowlingTeam().getId());
				
				//TeamEntity bte = teamRepo.getByTeamId(ts.getMatch().getBattingTeam().getId());

				tse = gameSnapUtil.prepare(tse, ts);
				
				gameSnapRepository.save(tse);
				
				System.out.println("Game Snap Saved!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Unable to save users: " + e);
			}
	}
	
	
	/*
	@Override
	public TourSnapShotRes getTourSnapShot(String tourName) {
		return GameSnapResult.prepare(gameSnapRepository.getByTourName(tourName));u
	}

	@Override
	public BattingTeam getBattingTeam(String id) {
		return GameSnapResult.prepareBattingTeam(teamRepo.getById(id));
	}

	@Override
	public BowlingTeam getBowlingTeam(String id) {
		return GameSnapResult.prepareBowlingTeam(bowlingTeamRepo.getById(id));
	}
	@Override
	public Match getMatch(String name) {
		return GameSnapResult.prepareMatch(matchRepo.getByName(name));
	}
		*/


}
