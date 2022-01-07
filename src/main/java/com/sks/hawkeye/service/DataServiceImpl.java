package com.sks.hawkeye.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.response.DataResponse;

public class DataServiceImpl implements DataService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DataResponse> getData(DataRequestDto data) {
		
		String query="";
	    
		Query nativeQuery = entityManager.createNativeQuery(query).setParameter("id",1);
	    return nativeQuery.getResultList();

		
	}

}
