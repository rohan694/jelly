package com.sks.hawkeye.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.response.DataResponse;

@Service
public class DataServiceImpl implements DataService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DataResponse> getData(DataRequestDto data) {
		
		String query = "select bsmn.name as batsman_name, bsmn.right_handed as batsman_IsRightHand, bsmn_ptr.name as batsman_partner_name, bsmn_ptr.right_handed as batsman_partner_IsRightHand, bowl_team.name as bowling_team_name, bowl_team.home as bowling_team_home, bowler.name as bowler_name, bowler.right_handed as bowler_isRightHand, bowler.spell as bowler_spell, bowler_ptr.name as bowler_ptr_name, bowler_ptr.right_handed as bowler_ptr_isRightHand, delivery.delivery_type as delivery_type, delivery.is_pavilion_end as delivery_is_pavilion_end, delivery.round as delivery_round, delivery.timecode as delivery_timecode, delivery_number.ball as delivery_ball, delivery_number.day as delivery_day, delivery_number.innings as delivery_innings, delivery_number.over as delivery_over, scoring_info.boundary as boundary, scoring_info.extras_score as extras_sore, scoring_info.extras_type as extras_type, scoring_info.overthrow_score as overthrow_score, scoring_info.score as score, wicket.wicket as wicket, wicket.wicket_type as wicket_type, wicket.wickets_taken as wicket_taken, release_position.x as release_position_x, release_position.y as release_position_y, release_position.z as release_position_z, bounce_position.x as bounce_position_x, bounce_position.y as bounce_position_y, bounce_position.z as bounce_position_z, stump_position.x as stump_position_x, stump_position.y as stump_position_y, stump_position.z as stump_position_z, landing_position.x as landing_position_x, landing_position.y as landing_position_y, landing_position.z as landing_position_z, shot_info.batsman_weight as batsman_weight, shot_info.shot_attacked as shot_attacked, shot_info.shot_played as shot_played, shot_info.shot_type_additional as shot_type_additional, ba.name as batting_team_name, ba.id as bat_team_id, ma.name as match_name ,ma.id as match_id, tour_name, country,format, international from cricket.tour_snap_shot as tss "
				+ "INNER JOIN cricket.match as ma ON ma.tour_id = tss.tour_name "
				+ "INNER JOIN cricket.batting_team as ba ON ba.match_id = ma.id "
				+ "INNER JOIN cricket.batsman as bsmn ON ba.pid = bsmn.batting_team_pid "
				+ "INNER JOIN cricket.batsman_partner as bsmn_ptr ON bsmn_ptr.batting_team_pid = ba.pid "
				+ "INNER JOIN cricket.bowling_team as bowl_team ON bowl_team.match_id = ma.id "
				+ "INNER JOIN cricket.bowler as bowler ON bowler.bowling_team_id = bowl_team.id "
				+ "INNER JOIN cricket.bowler_partner as bowler_ptr ON bowler_ptr.bowling_team_id = bowl_team.id "
				+ "INNER JOIN cricket.delivery as delivery ON delivery.match_id = ma.id "
				+ "INNER JOIN cricket.delivery_number ON delivery_number.delivery_id = delivery.id "
				+ "INNER JOIN cricket.scoring_info ON scoring_info.delivery_id = delivery.id "
				+ "INNER JOIN cricket.wicket ON wicket.scoring_information_id = scoring_info.id "
				+ "INNER JOIN cricket.shot_info ON shot_info.delivery_id = delivery.id "
				+ "INNER JOIN cricket.trajectory ON trajectory.delivery_id = delivery.id "
				+ "INNER JOIN cricket.release_position ON release_position.trajectory_id = trajectory.id "
				+ "INNER JOIN cricket.bounce_position ON bounce_position.trajectory_id = trajectory.id "
				+ "INNER JOIN cricket.stump_position ON stump_position.trajectory_id = trajectory.id "
				+ "INNER JOIN cricket.landing_position ON landing_position.trajectory_id = trajectory.id "
				+ "where tour_name = :tour_name and format = :format and ma.name = :match_name";
		String durationFilter = "";
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0) {
			durationFilter += " and delivery_over >= "+data.getDuration().getFrom().getOver();
		}
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0 && data.getDuration().getFrom().getBall() != 0) {
			durationFilter += " or (delivery_over = "+data.getDuration().getFrom().getOver()+" and delivery_ball >= "+data.getDuration().getFrom().getBall()+")";
		}
		
		String filtering = "";
		if(data.getFiltering().getBatsman1() != "") {
			filtering += " and bsmn.name = :batsman1 ";
		}
		if(data.getFiltering().getBatsman2() != "") {
			filtering += " and bsmn_ptr.name = :batsman2 ";
		}
		if(data.getFiltering().getBatsmanTeam()!= "") {
			filtering += " and ba.name = :batsmanteam ";
		}
		if(data.getFiltering().getBowlerName()!= "") {
			filtering += " and bowler.name = :bowlerName ";
		}
		if(data.getFiltering().getBowlerCountry()!= "") {
			filtering += " and bowl_team.name = :bowlerCountry ";
		}
		if(data.getFiltering().getScore()!= "") {
			filtering += " and scoring_info.score = :score ";
		}
		if(data.getFiltering().getExtraType()!= "") {
			filtering += " and scoring_info.extras_type = :extraType ";
		}
		if(data.getFiltering().getShotAttacked()!= "") {
			filtering += " and shot_info.shot_attacked = :shotAttacked ";
		}
		if(data.getFiltering().getShotPlayed()!= "") {
			filtering += " and shot_info.shot_played = :shotPlayed ";
		}
		if(data.getFiltering().getDeliveryType()!= "") {
			filtering += " and delivery.delivery_type = :deliveryType ";
		}
		if(data.getFiltering().getWicket()!= "") {
			filtering += " and wicket.wicket = :wicket ";
		}
		if(data.getFiltering().getLHB_Batsman()!= "") {
			filtering += " and bsmn.right_handed = :LHBBatsman ";
		}
		if(data.getFiltering().getRHB_Batsman()!= "") {
			filtering += " and bsmn.right_handed =  :RHBBatsman";
		}
		Query nativeQuery = entityManager.createNativeQuery(query + durationFilter + filtering);
		nativeQuery.setParameter("tour_name", data.getDuration().getTournamentName());
		nativeQuery.setParameter("format", data.getDuration().getTournamentFormat());
		nativeQuery.setParameter("match_name", data.getDuration().getMatchName());
		
		if(data.getFiltering().getBatsman1() != "") {
			nativeQuery.setParameter("batsman1", data.getFiltering().getBatsman1());
		}
		if(data.getFiltering().getBatsman2() != "") {
			nativeQuery.setParameter("batsman2", data.getFiltering().getBatsman2());
		}
		if(data.getFiltering().getBatsmanTeam() != "") {
			nativeQuery.setParameter("batsmanteam", data.getFiltering().getBatsmanTeam());
		}
		if(data.getFiltering().getBowlerName() != "") {
			nativeQuery.setParameter("bowlerName", data.getFiltering().getBowlerName());
		}
		if(data.getFiltering().getBowlerCountry() != "") {
			nativeQuery.setParameter("bowlerCountry", data.getFiltering().getBowlerCountry());
		}
		if(data.getFiltering().getScore() != "") {
			nativeQuery.setParameter("score", data.getFiltering().getScore());
		}
		if(data.getFiltering().getExtraType() != "") {
			nativeQuery.setParameter("extraType", data.getFiltering().getExtraType());
		}
		if(data.getFiltering().getShotAttacked() != "") {
			nativeQuery.setParameter("shotAttacked", data.getFiltering().getShotAttacked());
		}
		if(data.getFiltering().getShotPlayed() != "") {
			nativeQuery.setParameter("shotPlayed", data.getFiltering().getShotPlayed());
		}
		if(data.getFiltering().getDeliveryType() != "") {
			nativeQuery.setParameter("deliveryType", data.getFiltering().getDeliveryType());
		}
		if(data.getFiltering().getWicket() != "") {
			nativeQuery.setParameter("wicket", data.getFiltering().getWicket());
		}
		if(data.getFiltering().getLHB_Batsman() != "") {
			nativeQuery.setParameter("LHBBatsman", data.getFiltering().getLHB_Batsman() == "yes");
		}
		if(data.getFiltering().getRHB_Batsman() != "") {
			nativeQuery.setParameter("RHBBatsman", data.getFiltering().getRHB_Batsman() == "yes");
		}

		

		

	    return nativeQuery.getResultList();
	    

		
	}

}
