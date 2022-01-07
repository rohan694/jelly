package com.sks.hawkeye.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.sks.hawkeye.model.FileDB;

public interface FileDbStorageService {

	FileDB store(MultipartFile file) throws IOException;

	FileDB getFile(String id);

	Stream<FileDB> getAllFiles();

}
