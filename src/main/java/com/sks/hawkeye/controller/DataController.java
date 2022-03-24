package com.sks.hawkeye.controller;

import java.time.Duration;
import java.util.*;

import com.sks.hawkeye.dto.*;
import com.sks.hawkeye.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.service.DataService;

@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DataService dataService;

	@PostMapping("/getData")
	public ResponseEntity getData(@RequestBody DataRequestDto input) {
		List<DataResponse> data = dataService.getData(input);
		
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@PostMapping("/getDataByType")
	@ResponseBody
	public ResponseEntity fetchData(@RequestBody PagingRequest pagingRequest) {
		List<Map<String, Object>> data = new ArrayList<>();
		if(pagingRequest.getType().equalsIgnoreCase("match")) {
			data = dataService.getMatchData(pagingRequest);
		}else if(pagingRequest.getType().equalsIgnoreCase("player")){
			data = dataService.getPlayerData(pagingRequest);
		}else if(pagingRequest.getType().equalsIgnoreCase("venue")) {
			data = dataService.getVenueData(pagingRequest);
		}
		Page page = new Page();
		if(data.size()>0){
			page.setRecordsTotal(Integer.parseInt(data.get(0).get(ApplicationConstants.totalCount).toString()));
			page.setRecordsFiltered(Integer.parseInt(data.get(0).get(ApplicationConstants.totalCount).toString()));
		}
		page.setData(data);

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@PostMapping("/getTournamentList")
	@ResponseBody
	public ResponseEntity getTournamentName() {

		return ResponseEntity.status(HttpStatus.OK).body(dataService.getTournamentList());
	}
}
