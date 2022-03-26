package com.sks.hawkeye.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sks.hawkeye.model.FileDB;
import com.sks.hawkeye.repository.FileDBRepository;

import ch.qos.logback.core.util.TimeUtil;

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

    @Override
    public void downloadAllFiles(HttpServletResponse response) {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=download.zip");
         List<FileDB> temp = fileDBRepository.findAll();
         int i=0;
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream())) {
            for(FileDB file : temp) {
                File fileObj = new File(file.getName());
                
                ZipEntry zipEntry = new ZipEntry(file.getName());
//                zipEntry.setSize(fileSystemResource.contentLength());
                zipEntry.setTime(System.currentTimeMillis());

                zipOutputStream.putNextEntry(zipEntry);

//                StreamUtils.copy(fileSystemResource.getInputStream(), zipOutputStream);
                zipOutputStream.write(file.getData());
                zipOutputStream.closeEntry();
            }
            zipOutputStream.finish();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
