package com.sks.hawkeye.service;

import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.response.BattingTeam;
import com.sks.hawkeye.response.BowlingTeam;
import com.sks.hawkeye.response.Match;
import com.sks.hawkeye.response.TourSnapShotRes;

public interface GameSnapService {

	void processGameSnap(String fileId);
	/*

	TourSnapShotRes getTourSnapShot(String tourName);

	BattingTeam getBattingTeam(String id);
	
	BowlingTeam getBowlingTeam(String id);
	Match getMatch(String name);
		*/

	void processGameSnapUsingTourSnap(TourSnapShot ts);

}
