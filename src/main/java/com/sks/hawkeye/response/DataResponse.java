package com.sks.hawkeye.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataResponse {
	
	private String matchName;
	private String battingTeamName;
	private String batsman1;
	private boolean batsman1RightHanded;
	private String batsman2;
	private boolean batsman2RightHand;
	private String bowlingTeamName;
	private String bowlerName;
	private String ball;
	private String over;
	private String deliverytype;
	private String extraScore;
	private String extraType;
	private String score;
	private boolean IsWicket;
	private String shotAttacked;
	private String shotPlayed;
	private String releaseSpeed;
	private ReleasePosition releasePosition;
	private ReleasePosition bouncePosition;
	private ReleasePosition stumpPosition;
	private ReleasePosition landingPosition;
	
	
	
	
}
