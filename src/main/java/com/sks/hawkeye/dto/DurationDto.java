package com.sks.hawkeye.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DurationDto {

	private String tournamentName;
	private String tournamentFormat;
	private String matchName;
	private MatchSpecificInstance to;
	private MatchSpecificInstance from;
	
}
