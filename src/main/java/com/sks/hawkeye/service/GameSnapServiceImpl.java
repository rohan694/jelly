package com.sks.hawkeye.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.model.gameSnap.TourSnapShotEntity;
import com.sks.hawkeye.repository.FileDBRepository;
import com.sks.hawkeye.repository.GameSnapRepository;
import com.sks.hawkeye.response.TourSnapShotRes;
import com.sks.hawkeye.util.GameSnapResult;
import com.sks.hawkeye.util.GameSnapUtil;

@Service
public class GameSnapServiceImpl implements GameSnapService {

	@Autowired
	private FileDBRepository fileDBRepository;

	@Autowired
	private GameSnapRepository gameSnapRepository;

	@Override
	public void processGameSnap(String fileId) {

		FileDB fileDb = fileDBRepository.findById(fileId).get();
		if (fileDb != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				InputStream inputStream = new ByteArrayInputStream(fileDb.getData());
				TourSnapShot ts = mapper.readValue(inputStream, new TypeReference<TourSnapShot>() {});
				TourSnapShotEntity tse = gameSnapRepository.getByTourName(ts.getTourName());
				tse = GameSnapUtil.prepare(tse, ts);
				gameSnapRepository.save(tse);
				System.out.println("Game Snap Saved!");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Unable to save users: " + e.getMessage());
			}
		}
	}

	@Override
	public TourSnapShotRes getTourSnapShot(String tourName) {
		return GameSnapResult.prepare(gameSnapRepository.getByTourName(tourName));
	}

}
