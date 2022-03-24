package com.sks.hawkeye.service;

import java.util.List;
import java.util.Map;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.dto.PagingRequest;
import com.sks.hawkeye.response.DataResponse;

public interface DataService {

	List<DataResponse> getData(DataRequestDto data);

	List<Map<String, Object>> getMatchData(PagingRequest pagingRequest);

	List<Map<String, Object>> getPlayerData(PagingRequest pagingRequest);

	List<Map<String, Object>> getVenueData(PagingRequest pagingRequest);

	List<Map<String, Object>> getTournamentList();
}
