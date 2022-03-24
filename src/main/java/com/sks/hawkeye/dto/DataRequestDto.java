package com.sks.hawkeye.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataRequestDto {

	private String search;
	private String type;
	private int page;
	private int size;
	private DurationDto duration;
	private Filtering filtering;
	
	
	
}
