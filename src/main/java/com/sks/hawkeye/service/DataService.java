package com.sks.hawkeye.service;

import java.util.List;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.response.DataResponse;

public interface DataService {

	List<DataResponse> getData(DataRequestDto data);

}
