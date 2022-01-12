package com.sks.hawkeye.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.dto.Filtering;
import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.response.ResponseFile;
import com.sks.hawkeye.service.DataService;

@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	private DataService dataService;

	@PostMapping("/getData")
	public ResponseEntity getData(@RequestBody DataRequestDto input) {
		List<DataResponse> data = dataService.getData(input);
		
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
}