package com.sks.hawkeye.service;

import com.sks.hawkeye.response.TourSnapShotRes;

public interface GameSnapService {

	void processGameSnap(String fileId);

	TourSnapShotRes getTourSnapShot(String tourName);

}
