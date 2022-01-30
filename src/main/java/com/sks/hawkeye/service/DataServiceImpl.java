package com.sks.hawkeye.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.mapper.ResponseDtoMapper;
import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.util.CommonUtil;

@Service
public class DataServiceImpl implements DataService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataResponse> getData(DataRequestDto data) {
		
		String query = "select ma.name as matchName, bsmn.name as batsman1, bsmn.right_handed as batsman1RightHanded, bsmn_ptr.name as batsman2, "
				+ "bsmn_ptr.right_handed as batsman2RightHand, bsmn.team_id as battingteamname, bowler.team_id as bowlingTeamName, "
				+ "bowler.name as bowlerName, "
				+ "bowler.right_handed as isBowlerRightHanded, "
				+ "delivery.delivery_type as deliverytype,  "
				+ "delivery_number.ball as ball, "
				+ "delivery_number.over as over , scoring_info.extras_score as extraScore,  "
				+ "scoring_info.extras_type as extraType, scoring_info.score as score,  "
				+ "wicket.wicket as IsWicket, trajectory.release_speed as release_speed,"
				+ "release_position.x as release_position_x, release_position.y as release_position_y, "
				+ "release_position.z as release_position_z, bounce_position.x as bounce_position_x, "
				+ "bounce_position.y as bounce_position_y, bounce_position.z as bounce_position_z, "
				+ "stump_position.x as stump_position_x, stump_position.y as stump_position_y, stump_position.z as stump_position_z, "
				+ "landing_position.x as landing_position_x, landing_position.y as landing_position_y,  "
				+ "landing_position.z as landing_position_z,   "
				+ "shot_info.shot_attacked as shotAttacked, shot_info.shot_played as shotPlayed "
				+ "from tour_snap_shot as tss "
				+ "INNER JOIN match as ma ON ma.tour_id = tss.tour_name "
				+ "INNER JOIN delivery as delivery ON delivery.match_id = ma.id "
				+ "INNER JOIN players as bsmn ON bsmn.player_id = delivery.batsman_id "
				+ "INNER JOIN players as bsmn_ptr ON bsmn_ptr.player_id = delivery.batsman_partner_id "
				+ "INNER JOIN players as bowler ON bowler.player_id = delivery.bowler_id " 

				+ "INNER JOIN teams as bat_team ON bat_team.team_name = bsmn.team_id " 
				+ "INNER JOIN teams as bowl_team ON bowl_team.team_name = bowler.team_id " 
				
				+ "INNER JOIN delivery_number ON delivery_number.delivery_id = delivery.id "
				+ "INNER JOIN scoring_info ON scoring_info.delivery_id = delivery.id "
				+ "INNER JOIN wicket ON wicket.scoring_information_id = scoring_info.id "
				+ "INNER JOIN shot_info ON shot_info.delivery_id = delivery.id "
				+ "INNER JOIN trajectory ON trajectory.delivery_id = delivery.id "
				+ "INNER JOIN release_position ON release_position.trajectory_id = trajectory.id "
				+ "INNER JOIN bounce_position ON bounce_position.trajectory_id = trajectory.id "
				+ "INNER JOIN stump_position ON stump_position.trajectory_id = trajectory.id "
				+ "INNER JOIN landing_position ON landing_position.trajectory_id = trajectory.id "
				+ "where tour_name = :tour_name ";
				//+ "order by ma.name,delivery_number.innings, delivery_number.over, delivery_number.ball ASC";
		String durationFilter = "";
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentFormat())) {
			durationFilter += " and format = :format";
		}
		if(CommonUtil.isNotBlank(data.getDuration().getMatchName())) {
			durationFilter += " and ma.name = :match_name";
		}
		/*if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getDate() != null) {
			durationFilter += " and delivery.timecode >= "+data.getDuration().getFrom().getDate();
		}*/
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0 && data.getDuration().getFrom().getBall() != 0) {
			durationFilter +=  " and (delivery_number.over > "+data.getDuration().getFrom().getOver()+" or (delivery_number.over = "+data.getDuration().getFrom().getOver()+" and delivery_number.ball >= "+data.getDuration().getFrom().getBall()+"))";
		} else if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0) {
			durationFilter += " and delivery_number.over >= "+data.getDuration().getFrom().getOver();
		}
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getInning() != 0) {
			durationFilter +=  " and delivery_number.innings >= "+data.getDuration().getFrom().getInning();
		}
		if(data.getDuration().getTo() != null && data.getDuration().getTo().getInning() != 0) {
			durationFilter +=  " and delivery_number.innings <= "+data.getDuration().getTo().getInning();
		}
		/*if(data.getDuration().getTo() != null && data.getDuration().getTo().getDate() != null) {
			durationFilter += " and delivery.timecode <= "+data.getDuration().getTo().getDate();
		}*/
		if(data.getDuration().getTo() != null && data.getDuration().getTo().getOver() != 0 && data.getDuration().getTo().getBall() != 0) {
			durationFilter += " and (delivery_number.over < "+data.getDuration().getTo().getOver() +" or (delivery_number.over = "+data.getDuration().getTo().getOver()+" and delivery_number.ball <= "+data.getDuration().getTo().getBall()+"))";
		} else if(data.getDuration().getTo() != null && data.getDuration().getTo().getOver() != 0) {
			durationFilter += " and delivery_number.over <= "+data.getDuration().getTo().getOver();
		}
		
		
		
		String filtering = "";
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman1())) {
			filtering += " and bsmn.name = :batsman1 ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman2())) {
			filtering += " and bsmn_ptr.name = :batsman2 ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsmanTeam())) {
			filtering += " and bat_team.team_name = :batsmanteam ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerName())) {
			filtering += " and bowler.name = :bowlerName ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerCountry())) {
			filtering += " and bowler.team_id = :bowlerCountry ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getScore()) && !"All".equals(data.getFiltering().getScore())) {
			filtering += " and scoring_info.score = :score ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getExtraType())) {
			filtering += " and scoring_info.extras_type = :extraType ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotAttacked())) {
			filtering += " and shot_info.shot_attacked = :shotAttacked ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotPlayed())) {
			filtering += " and shot_info.shot_played = :shotPlayed ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getDeliveryType())) {
			filtering += " and delivery.delivery_type = :deliveryType ";
		}
		if(data.getFiltering().isWicket()) {
			filtering += " and wicket.wicket = :wicket ";
		}
		if(data.getFiltering().getIsRightHandedBatsman().isPresent()) {
			filtering += " and bsmn.right_handed = :isRightHandedBatsman ";
		}
		if(data.getFiltering().getIsRightHandedBowler().isPresent()) {
			filtering += " and bowler.right_handed =  :isRightHandedBowler";
		}
		Map inputs=new HashMap<>();
		
		//Query nativeQuery = entityManager.createQuery(query + durationFilter + filtering);
		inputs.put("tour_name", data.getDuration().getTournamentName());
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentFormat())) {
			inputs.put("format", data.getDuration().getTournamentFormat());
		}
		if(CommonUtil.isNotBlank(data.getDuration().getMatchName())) {
			inputs.put("match_name", data.getDuration().getMatchName());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman1())) {
			inputs.put("batsman1", data.getFiltering().getBatsman1());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman2())) {
			inputs.put("batsman2", data.getFiltering().getBatsman2());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsmanTeam())) {
			inputs.put("batsmanteam", data.getFiltering().getBatsmanTeam());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerName())) {
			inputs.put("bowlerName", data.getFiltering().getBowlerName());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerCountry())) {
			inputs.put("bowlerCountry", data.getFiltering().getBowlerCountry());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getScore()) && !"All".equals(data.getFiltering().getScore())) {
			inputs.put("score", Integer.parseInt(data.getFiltering().getScore()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getExtraType())) {
			inputs.put("extraType", data.getFiltering().getExtraType());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotAttacked())) {
			inputs.put("shotAttacked", data.getFiltering().getShotAttacked());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotPlayed() )) {
			inputs.put("shotPlayed", data.getFiltering().getShotPlayed());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getDeliveryType())) {
			inputs.put("deliveryType", data.getFiltering().getDeliveryType());
		}
		if(CommonUtil.isNotBlank(data.getFiltering().isWicket())) {
			inputs.put("wicket", data.getFiltering().isWicket());
		}
		if(data.getFiltering().getIsRightHandedBatsman().isPresent()) {
			inputs.put("isRightHandedBatsman", data.getFiltering().getIsRightHandedBatsman().get());
		}
		if(data.getFiltering().getIsRightHandedBowler().isPresent()) {
			inputs.put("isRightHandedBowler", data.getFiltering().getIsRightHandedBowler().get());
		}
		
	    //List<DataResponse> dbQuerry =  nativeQuery.getResultList();
		List<DataResponse> rows=null;
		try {
			System.out.println(query + durationFilter + filtering);
			rows=namedParameterJdbcTemplate.query(query + durationFilter + filtering, inputs,new ResponseDtoMapper());
			
			System.out.println(rows);
		}catch(Exception e) {
			e.printStackTrace();
		}

	    return rows;
	}

}
