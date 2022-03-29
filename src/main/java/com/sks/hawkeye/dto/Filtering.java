package com.sks.hawkeye.dto;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Filtering {

	private String batsman1 ;
	private String batsman2 ;
	private String batsmanTeam ;
	private String tournamentCountry ;
	private String bowlerName ;
	private String bowlerCountry ;
	private int bouncePosition ;
	private int stumpPosition ;
	private String score ;
	private String extraType ;
	private String shotAttacked ;
	private String shotPlayed ;
	private int pitchType ;
	private String deliveryType ;
	private boolean wicket ;
	//private boolean rhbBatsman ;
	//private boolean lhbBatsman ;
	private Optional<Boolean> isRightHandedBatsman;
	private Optional<Boolean> isRightHandedBowler;
}
