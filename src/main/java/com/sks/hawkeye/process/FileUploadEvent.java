package com.sks.hawkeye.process;

import org.springframework.context.ApplicationEvent;

public class FileUploadEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String fileId;

	public FileUploadEvent(Object source, String fileId) {
		super(source);
		this.fileId = fileId;
	}

	public String getFileId() {
		return fileId;
	}
	
}