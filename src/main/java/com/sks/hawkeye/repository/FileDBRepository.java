package com.sks.hawkeye.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sks.hawkeye.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
}
