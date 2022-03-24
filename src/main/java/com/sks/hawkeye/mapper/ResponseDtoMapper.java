package com.sks.hawkeye.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.jdbc.core.RowMapper;

import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.response.ReleasePosition;
import org.springframework.util.StringUtils;

public class ResponseDtoMapper implements RowMapper<DataResponse> {

	@Override
	public DataResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DataResponse dto=new DataResponse();
		try {
			dto.setMatchName(rs.getString("matchname"));
			dto.setVenue(rs.getString("venue"));
			dto.setBattingTeamName(rs.getString("battingteamname"));
			dto.setBatsman1(rs.getString("batsman1"));
			dto.setBatsman1RightHanded(rs.getBoolean("batsman1righthanded"));
			dto.setRightHandedBowler(rs.getBoolean("isBowlerRightHanded"));
			dto.setBatsman2(rs.getString("batsman2"));
			dto.setBatsman2RightHand(rs.getBoolean("batsman2righthand"));
			dto.setBowlingTeamName(rs.getString("bowlingteamname"));
			dto.setBowlerName(rs.getString("bowlername"));
			dto.setBall(rs.getString("ball"));
			dto.setOver(rs.getString("over"));
			dto.setDeliverytype(rs.getString("deliverytype"));
			dto.setExtraScore(rs.getString("extrascore"));
			dto.setExtraType(rs.getString("extratype"));
			dto.setScore(rs.getString("score"));
			dto.setIsWicket(rs.getBoolean("iswicket"));
			dto.setShotAttacked(rs.getString("shotattacked"));
			dto.setShotPlayed(rs.getString("shotplayed"));
			dto.setReleaseSpeed(rs.getDouble("release_speed"));
			dto.setReleasePosition(new ReleasePosition(rs.getDouble("release_position_x"),rs.getDouble("release_position_y"),rs.getDouble("release_position_z")));
			dto.setBouncePosition(new ReleasePosition(rs.getDouble("bounce_position_x"),rs.getDouble("bounce_position_y"),rs.getDouble("bounce_position_z")));
			dto.setStumpPosition(new ReleasePosition(rs.getDouble("stump_position_x"),rs.getDouble("stump_position_y"),rs.getDouble("stump_position_z")));
			dto.setLandingPosition(new ReleasePosition(rs.getDouble("landing_position_x"),rs.getDouble("landing_position_y"),rs.getDouble("landing_position_z")));
			
			dto.setInnings(rs.getDouble("innings"));
			dto.setShotTypeAdditional(rs.getString("shot_type_additional"));
			dto.setRealDistance(rs.getDouble("real_distance"));

		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
