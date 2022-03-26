package com.sks.hawkeye.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.sks.hawkeye.model.FileDB;

public interface FileDbStorageService {

	FileDB store(MultipartFile file) throws IOException;

	FileDB getFile(String id);

	Stream<FileDB> getAllFiles();


	void downloadAllFiles(HttpServletResponse response);


}
