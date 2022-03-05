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
	private int tournamentYear;
	private int fetchTournaments;
	private String matchName;
	private int fetchMatches;
	private String venueName;
	private MatchSpecificInstance to;
	private MatchSpecificInstance from;
	
    public int innings;

	
}
