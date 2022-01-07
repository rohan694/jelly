package com.sks.hawkeye.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.sks.hawkeye.service.GameSnapService;

@Service
public class FileUploadEventProcessor implements ApplicationListener<FileUploadEvent> {
	
	@Autowired
	private GameSnapService gameSnapService;

	@Override
	public void onApplicationEvent(FileUploadEvent event) {
		System.out.println("Received File Id: " + event.getFileId());
		gameSnapService.processGameSnap(event.getFileId());
	}

}

/*
 * 
 * @Component public class FileUploadEventPublisher {
 * 
 * @Autowired private ApplicationEventPublisher applicationEventPublisher;
 * 
 * public void publishCustomEvent(final String message) {
 * System.out.println("Publishing custom event. ");
 * applicationEventPublisher.publishEvent(new FileUploadEvent(this, message)); }
 * }
 * 
 */