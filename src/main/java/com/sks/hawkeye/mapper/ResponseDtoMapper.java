package com.sks.hawkeye.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.response.ReleasePosition;

public class ResponseDtoMapper implements RowMapper<DataResponse> {

	@Override
	public DataResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DataResponse dto=new DataResponse();
		try {
			dto.setMatchName(rs.getString("matchname"));
			dto.setBattingTeamName(rs.getString("battingteamname"));
			dto.setBatsman1(rs.getString("batsman1"));
			dto.setBatsman1RightHanded(rs.getBoolean("batsman1righthanded"));
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
			//dto.setReleaseSpeed(rs.getString(rowNum));
			dto.setReleasePosition(new ReleasePosition(rs.getInt("release_position_x"),rs.getInt("release_position_y"),rs.getInt("release_position_x")));
			dto.setBouncePosition(new ReleasePosition(rs.getInt("bounce_position_x"),rs.getInt("bounce_position_y"),rs.getInt("bounce_position_z")));
			dto.setStumpPosition(new ReleasePosition(rs.getInt("stump_position_x"),rs.getInt("stump_position_y"),rs.getInt("stump_position_z")));
			dto.setLandingPosition(new ReleasePosition(rs.getInt("landing_position_x"),rs.getInt("landing_position_y"),rs.getInt("landing_position_z")));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
