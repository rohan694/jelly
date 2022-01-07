package com.sks.hawkeye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sks.hawkeye.response.TourSnapShotRes;
import com.sks.hawkeye.service.GameSnapService;

@RestController
@RequestMapping("/hawk")
@CrossOrigin("http://localhost:8080")
public class HawkEyeController {
	
	@Autowired
	private GameSnapService gameSnapService;


	@GetMapping("/files/{tourName}")
	public TourSnapShotRes getTourSnapShot(@PathVariable String tourName) {
		return gameSnapService.getTourSnapShot(tourName);
	}
}
