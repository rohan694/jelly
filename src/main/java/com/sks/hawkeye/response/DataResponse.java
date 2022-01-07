package com.sks.hawkeye.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse {
	
	private String matchName;
	private String battingTeamName;
	private String batsman1;
	private String batsman2;
	private boolean isRightHand;
	private String bowlingTeamName;
	private String bowlerName;
	private String ball;
	private String over;
	private String deliverytype;
	private String extraScore;
	private String extraType;
	private String score;
	private String IsWicket;
	private String shotAttacked;
	private String shotPlayed;
	private String releaseSpeed;
	private ReleasePosition releasePosition;
	private ReleasePosition bouncePosition;
	private ReleasePosition stumpPosition;
	private ReleasePosition landingPosition;
	
}
