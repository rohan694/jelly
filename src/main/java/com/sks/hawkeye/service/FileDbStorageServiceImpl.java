package com.sks.hawkeye.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.repository.FileDBRepository;

@Service
public class FileDbStorageServiceImpl implements FileDbStorageService {
	@Autowired
	private FileDBRepository fileDBRepository;

	@Override
	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
		return fileDBRepository.save(fileDB);
		
	}

	@Override
	public FileDB getFile(String id) {
		return fileDBRepository.findById(id).get();
	}

	@Override
	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}

	
}
