package com.sks.hawkeye.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sks.hawkeye.dto.TourSnapShot;
import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.process.FileUploadEvent;
import com.sks.hawkeye.process.FileUploadEventProcessor;
import com.sks.hawkeye.response.ResponseFile;
import com.sks.hawkeye.response.ResponseMessage;
import com.sks.hawkeye.service.FileDbStorageService;
import com.sks.hawkeye.service.GameSnapService;

@CrossOrigin
@Controller
@RequestMapping("/db")
public class HawkDbController {
	@Autowired
	private FileDbStorageService storageService;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;	
	@Autowired
	private GameSnapService gameSnapService;	
/*
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			FileDB fileDB = storageService.store(file);
			applicationEventPublisher.publishEvent(new FileUploadEvent(this, fileDB.getId()));
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
*/
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile[] files) {
		String message = "";
		for(MultipartFile file:files) {
		try {
			FileDB fileDB = storageService.store(file);
			applicationEventPublisher.publishEvent(new FileUploadEvent(this, fileDB.getId()));
			message+= "Uploaded the file successfully: " + file.getOriginalFilename()+"/n";
			
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	}
	@PostMapping("/uploadUsingJson")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestBody TourSnapShot ts) {
		String message = "";
		try {
			gameSnapService.processGameSnapUsingTourSnap(ts);
			message+= "Uploaded the data successfully: /n";
			
		} catch (Exception e) {
			message = "Could not upload the data, Something went wrong";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = 
					ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/db/files/")
					.path(dbFile.getId())
					.toUriString();

			return new ResponseFile(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = storageService.getFile(id);
		//applicationEventPublisher.publishEvent(new FileUploadEvent(this, fileDB.getId()));
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
}
