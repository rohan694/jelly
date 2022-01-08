package com.sks.hawkeye.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DurationDto {

	private String tournamentName;
	private String tournamentFormat;
	private String matchName;
	private MatchSpecificInstance to;
	private MatchSpecificInstance from;
	
	
	
}
