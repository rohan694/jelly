package com.sks.hawkeye.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.model.gameSnap.BattingTeamEntity;
import com.sks.hawkeye.model.gameSnap.BowlingTeamEntity;
import com.sks.hawkeye.model.gameSnap.MatchEntity;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;
import com.sks.hawkeye.repository.BatsmanTeamRepository;
import com.sks.hawkeye.repository.BowlingTeamRepository;
import com.sks.hawkeye.repository.FileDBRepository;
import com.sks.hawkeye.repository.GameSnapRepository;
import com.sks.hawkeye.repository.MatchRepository;
import com.sks.hawkeye.response.BattingTeam;
import com.sks.hawkeye.response.BowlingTeam;
import com.sks.hawkeye.response.Match;
import com.sks.hawkeye.response.TourSnapShotRes;
import com.sks.hawkeye.util.GameSnapResult;
import com.sks.hawkeye.util.GameSnapUtil;

@Service
public class GameSnapServiceImpl implements GameSnapService {

	@Autowired
	private FileDBRepository fileDBRepository;

	@Autowired
	private GameSnapRepository gameSnapRepository;
	
	@Autowired
	private BatsmanTeamRepository batsmanTeamRepo;
	
	@Autowired
	private BowlingTeamRepository bowlingTeamRepo;
	
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
				System.out.println("ts ==>  "+ts.toString());
				System.out.println(ts.getTourName());
				System.out.println(ts.getMatchName());
				TourSnapShotEntity tse = gameSnapRepository.getByTourName(ts.getTourName());
				if(tse != null )
				System.out.println("tse ===> "+tse.toString());

				MatchEntity mte = matchRepo.getByName(ts.getMatchName());
				if (mte != null)
				System.out.println("mte ===> "+mte.toString());
				
				BowlingTeamEntity bwte = bowlingTeamRepo.getByBowlingTeamId(ts.getMatch().getBowlingTeam().getId());
				if(bwte != null)
				System.out.println("bwte ===> "+bwte.toString());
				
				BattingTeamEntity bte = batsmanTeamRepo.getByBattingTeamId(ts.getMatch().getBattingTeam().getId());
				if (bte != null)
				System.out.println("bte ===> "+bte.toString());



				tse = GameSnapUtil.prepare(tse, mte, bte, bwte, ts);
				gameSnapRepository.save(tse);
				System.out.println("Game Snap Saved!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Unable to save users: " + e);
			}
		}
	}

	@Override
	public TourSnapShotRes getTourSnapShot(String tourName) {
		return GameSnapResult.prepare(gameSnapRepository.getByTourName(tourName));
	}

	@Override
	public BattingTeam getBattingTeam(String id) {
		return GameSnapResult.prepareBattingTeam(batsmanTeamRepo.getById(id));
	}

	@Override
	public BowlingTeam getBowlingTeam(String id) {
		return GameSnapResult.prepareBowlingTeam(bowlingTeamRepo.getById(id));
	}
	
	@Override
	public Match getMatch(String name) {
		return GameSnapResult.prepareMatch(matchRepo.getByName(name));
	}
	

}
