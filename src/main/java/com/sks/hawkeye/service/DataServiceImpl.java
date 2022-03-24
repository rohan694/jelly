package com.sks.hawkeye.service;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sks.hawkeye.dto.PagingRequest;
import com.sks.hawkeye.mapper.ResponseMapper;
import com.sks.hawkeye.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.sks.hawkeye.dto.DataRequestDto;
import com.sks.hawkeye.mapper.ResponseDtoMapper;
import com.sks.hawkeye.response.DataResponse;
import com.sks.hawkeye.util.CommonUtil;
import com.sks.hawkeye.util.GameSnapUtil;

@Service
public class DataServiceImpl implements DataService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private GameSnapUtil gameSnapUtil;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<DataResponse> getData(DataRequestDto data) {

		String query = "select ma.name as matchName,ma.venue as venue, bsmn.name as batsman1, bsmn.right_handed as batsman1RightHanded, bsmn_ptr.name as batsman2, "
				+ "bsmn_ptr.right_handed as batsman2RightHand, bsmn.team_id as battingteamname, bowler.team_id as bowlingTeamName, "
				+ "bowler.name as bowlerName, "
				+ "bowler.right_handed as isBowlerRightHanded, "
				+ "delivery.delivery_type as deliverytype,  "
				+ "delivery_number.ball as ball, "
				+ "delivery_number.innings as innings,"
				+ "shot_info.shot_type_additional as shot_type_additional,"
				+ "trajectory.real_distance as real_distance,"
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
				+ "where ";
				//+ "order by ma.name,delivery_number.innings, delivery_number.over, delivery_number.ball ASC";


		String durationFilter = "";
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentName())) {
			durationFilter +=andAppender(durationFilter)+" lower(actual_tour_name) like('%' || lower(:actual_tour_name) || '%')";
		}
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentYear()) && CommonUtil.isNotBlank(data.getDuration().getFetchTournaments()) ) {
			durationFilter +=andAppender(durationFilter)+ " (tournament_year> :tournament_year-:no_of_past_tournaments and tournament_year<= :tournament_year)";

		} else if(CommonUtil.isNotBlank(data.getDuration().getTournamentYear())) {
			durationFilter += andAppender(durationFilter)+" tournament_year = :tournament_year ";
		}


		if(CommonUtil.isNotBlank(data.getDuration().getTournamentFormat())) {
			durationFilter += andAppender(durationFilter)+" lower(format) = lower(:format)";
		}
		if(CommonUtil.isNotBlank(data.getDuration().getMatchName())) {
			//durationFilter += andAppender(durationFilter)+"(  lower(ma.team1 || ' v ' || ma.team2) = lower(:match_name) or   lower(ma.team2 || ' v ' || ma.team1) = lower(:match_name))";
			durationFilter += andAppender(durationFilter)+"(  lower(ma.short_name) like( '%' || lower(:match_name) || '%'))";
		}
		if(CommonUtil.isNotBlank(data.getDuration().getVenueName())) {
			durationFilter += andAppender(durationFilter)+"  lower(ma.venue) =lower(:venue_name)";
		}
//		if(CommonUtil.isNotBlank(data.getDuration().getFetchMatches())) {
//			durationFilter += " and ma.name = :match_name";
//		}
		
		/*if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getDate() != null) {
			durationFilter += " and delivery.timecode >= "+data.getDuration().getFrom().getDate();
		}*/
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0 && data.getDuration().getFrom().getBall() != 0) {
			durationFilter += andAppender(durationFilter)+ "  (delivery_number.over > "+data.getDuration().getFrom().getOver()+" or (delivery_number.over = "+data.getDuration().getFrom().getOver()+" and delivery_number.ball >= "+data.getDuration().getFrom().getBall()+"))";
		} else if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getOver() != 0) {
			durationFilter += andAppender(durationFilter)+ "  delivery_number.over >= "+data.getDuration().getFrom().getOver();
		}
		if(data.getDuration().getFrom() != null && data.getDuration().getFrom().getInning() != 0) {
			durationFilter += andAppender(durationFilter)+ "  delivery_number.innings >= "+data.getDuration().getFrom().getInning();
		}
		if(data.getDuration().getTo() != null && data.getDuration().getTo().getInning() != 0) {
			durationFilter += andAppender(durationFilter)+ "  delivery_number.innings <= "+data.getDuration().getTo().getInning();
		}
		/*if(data.getDuration().getTo() != null && data.getDuration().getTo().getDate() != null) {
			durationFilter += " and delivery.timecode <= "+data.getDuration().getTo().getDate();
		}*/
		if(data.getDuration().getTo() != null && data.getDuration().getTo().getOver() != 0 && data.getDuration().getTo().getBall() != 0) {
			durationFilter += andAppender(durationFilter)+"  (delivery_number.over < "+data.getDuration().getTo().getOver() +" or (delivery_number.over = "+data.getDuration().getTo().getOver()+" and delivery_number.ball <= "+data.getDuration().getTo().getBall()+"))";
		} else if(data.getDuration().getTo() != null && data.getDuration().getTo().getOver() != 0) {
			durationFilter += andAppender(durationFilter)+"  delivery_number.over <= "+data.getDuration().getTo().getOver();
		}



		String filtering = "";
		if(CommonUtil.isNotBlank(data.getFiltering().getTournamentCountry())) {
			filtering +=andAppender(filtering+durationFilter)+" lower(tss.country) like('%' || lower(:tournament_country) || '%')";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman1())) {
			filtering += andAppender(filtering+durationFilter)+"  lower(bsmn.name) = lower(:batsman1) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman2())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(bsmn_ptr.name) = lower(:batsman2) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsmanTeam())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(bat_team.team_name) = lower(:batsmanteam) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerName())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(bowler.name) = lower(:bowlerName) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerCountry())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(bowler.team_id) = lower(:bowlerCountry) ";
		}
//		if(CommonUtil.isNotBlank(data.getFiltering().getScore()) && !"All".equals(data.getFiltering().getScore())  && !"0".equals(data.getFiltering().getScore())) {
//			filtering += " and scoring_info.score = :score ";
//		}
		if(CommonUtil.isNotBlank(data.getFiltering().getExtraType())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(scoring_info.extras_type) = lower(:extraType) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotAttacked())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(shot_info.shot_attacked) = lower(:shotAttacked) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getShotPlayed())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(shot_info.shot_played) = lower(:shotPlayed) ";
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getDeliveryType())) {
			filtering += andAppender(filtering+durationFilter)+"   lower(delivery.delivery_type) = lower(:deliveryType) ";
		}
		if(data.getFiltering().isWicket()) {
			filtering += andAppender(filtering+durationFilter)+"   wicket.wicket = :wicket ";
		}
		if(data.getFiltering().getIsRightHandedBatsman().isPresent()) {
			filtering += andAppender(filtering+durationFilter)+"   bsmn.right_handed = :isRightHandedBatsman ";
		}
		if(data.getFiltering().getIsRightHandedBowler().isPresent()) {
			filtering += andAppender(filtering+durationFilter)+"   bowler.right_handed =  :isRightHandedBowler";
		}
		if(data.getFiltering().getBouncePosition()>0) {
			if(data.getFiltering().getBouncePosition()==1) filtering += andAppender(filtering+durationFilter)+"   bounce_position.x<0";
			if(data.getFiltering().getBouncePosition()==2) filtering += andAppender(filtering+durationFilter)+"   (bounce_position.x>0 and bounce_position.x<=2)";
			if(data.getFiltering().getBouncePosition()==3) filtering += andAppender(filtering+durationFilter)+"   (bounce_position.x>2 and bounce_position.x<=6)";
			if(data.getFiltering().getBouncePosition()==4) filtering += andAppender(filtering+durationFilter)+"  (bounce_position.x>6 and bounce_position.x<=8)";
			if(data.getFiltering().getBouncePosition()==5) filtering += andAppender(filtering+durationFilter)+"  (bounce_position.x>8 )";
		}
		if(data.getFiltering().getStumpPosition()>0) {
			if(data.getFiltering().getStumpPosition()==1) filtering += andAppender(filtering+durationFilter)+"  (((stump_position.y > 0) and (stump_position.y < 0.15)) or ((stump_position.y < 0) and (stump_position.y > -0.15)))";
			if(data.getFiltering().getStumpPosition()==2) filtering += andAppender(filtering+durationFilter)+"  (case when bsmn.right_handed then stump_position.y>0.3 else stump_position.y<-0.3 end)";
			if(data.getFiltering().getStumpPosition()==3) filtering += andAppender(filtering+durationFilter)+"  (case when bsmn.right_handed then (stump_position.y>0.15 and stump_position.y<0.3) else (stump_position.y<-0.15 and stump_position.y>-0.3) end)";
			if(data.getFiltering().getStumpPosition()==4) filtering += andAppender(filtering+durationFilter)+"  (case when bsmn.right_handed then stump_position.y<-0.15 else stump_position.y>0.15 end) ";
		}
		String score="";

		if(CommonUtil.isNotBlank(data.getFiltering().getScore()) && !"0".equals(data.getFiltering().getScore())) {
			switch (Integer.parseInt(data.getFiltering().getScore())) {
				case 1: score="1,2,3,4,6"; break;
				case 2: score="4,6"; break;
				case 3: score="1,2,3"; break;
				case 4: score="1"; break;
				case 5: score="2"; break;
				case 6: score="3"; break;
				case 7: score="4"; break;
				case 8: score="6"; break;
			}
			filtering += andAppender(filtering+durationFilter)+"  scoring_info.score in ("+score+")";
		}
		Map inputs=new HashMap<>();

		//Query nativeQuery = entityManager.createQuery(query + durationFilter + filtering);
		inputs.put("actual_tour_name",CommonUtil.replaceSpecialChar(data.getDuration().getTournamentName()));
		inputs.put("venue_name",CommonUtil.replaceSpecialChar(data.getDuration().getVenueName()));
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentFormat())) {
			inputs.put("format", data.getDuration().getTournamentFormat());
		}
		if(CommonUtil.isNotBlank(data.getDuration().getTournamentYear())) {
			inputs.put("tournament_year", data.getDuration().getTournamentYear());
		}
		if(CommonUtil.isNotBlank(data.getDuration().getFetchTournaments())) {
			inputs.put("no_of_past_tournaments", data.getDuration().getFetchTournaments());
		}
		if(CommonUtil.isNotBlank(data.getDuration().getMatchName())) {
			inputs.put("match_name", CommonUtil.replaceAllSpecialChar(data.getDuration().getMatchName()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman1())) {
			inputs.put("batsman1", CommonUtil.replaceSpecialChar(data.getFiltering().getBatsman1()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsman2())) {
			inputs.put("batsman2", CommonUtil.replaceSpecialChar(data.getFiltering().getBatsman2()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBatsmanTeam())) {
			inputs.put("batsmanteam", CommonUtil.replaceSpecialChar(data.getFiltering().getBatsmanTeam()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerName())) {
			inputs.put("bowlerName", CommonUtil.replaceSpecialChar(data.getFiltering().getBowlerName()));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getTournamentCountry())) {
			inputs.put("tournament_country", CommonUtil.replaceSpecialChar((data.getFiltering().getTournamentCountry())));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getBowlerCountry())) {
			inputs.put("bowlerCountry", CommonUtil.replaceSpecialChar((data.getFiltering().getBowlerCountry())));
		}
		if(CommonUtil.isNotBlank(data.getFiltering().getScore()) && !"All".equals(data.getFiltering().getScore())) {
			inputs.put("score", score);
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

	@Override
	public List<Map<String, Object>> getMatchData(PagingRequest data) {

		String query = "select count(*) OVER() AS totalCount,m.name as matchName, m.team1 as team1,m.team2 as team2, m.venue as venue,max(d.timecode) as timeCode from match m "
				+"inner join teams t on m.team1 = t.team_name "
				+"inner join players p on p.team_id = t.team_name "
				+"inner join delivery d on m.id = d.match_id "
				+"inner join tour_snap_shot tss on tss.tour_name = m.tour_id "
				+"where m.name is not null";

		String filtering = " ";
		if(CommonUtil.isNotBlank(data.getSearch().getValue())) {
			filtering +=andAppender(filtering)+"(lower(m.name) like :search_value";
			filtering +=orAppender(filtering)+"lower(m.team1) like :search_value";
			filtering +=orAppender(filtering)+"lower(m.team2) like :search_value";
			filtering +=orAppender(filtering)+"lower(m.venue) like :search_value)";
		}
		if(CommonUtil.isNotBlank(data.getTournamentYear())){
			filtering +=andAppender(filtering)+"tss.tournament_year = :tournament_year ";
		}
		if(CommonUtil.isNotBlank(data.getTournamentName())){
			filtering +=andAppender(filtering)+"tss.actual_tour_name = :tour_name ";
		}
		filtering +="group by m.id,tss.tournament_year ";

		filtering += getSortquery(data);

		if(data.getStart()>0 && data.getLength() > 0){
			filtering +="OFFSET " + String.valueOf(data.getStart() * data.getLength()) + " LIMIT "+ data.getLength()+" ";
		}else if(data.getLength() > 0){
			filtering +="LIMIT "+ data.getLength();
		}

		Map inputs = getInputs(data);

		return ExecuteQuery(query+filtering,inputs,data.getStart());
	}

	@Override
	public List<Map<String, Object>> getPlayerData(PagingRequest data) {

		String playerQuery = "select count(*) OVER() AS totalCount,p.name as playername,p.team_id as team from match m inner join teams t on m.team1 = t.team_name "
				+"inner join players p on p.team_id = t.team_name "
				+"inner join delivery d on m.id = d.match_id "
				+"inner join tour_snap_shot tss on tss.tour_name = m.tour_id "
				+"where p.name is not null";

		String filtering = " ";
		if(CommonUtil.isNotBlank(data.getSearch().getValue())) {
			filtering +=andAppender(filtering)+" lower(p.name) like :search_value ";
			filtering +=orAppender(filtering)+" lower(p.team_id) like :search_value ";
		}
		if(CommonUtil.isNotBlank(data.getTournamentYear())){
			filtering +=andAppender(filtering)+" tss.tournament_year = :tournament_year ";
		}
		if(CommonUtil.isNotBlank(data.getTournamentName())){
			filtering +=andAppender(filtering)+" tss.actual_tour_name = :tour_name ";
		}

		filtering +="group by p.name,p.team_id ";

		filtering += getSortquery(data);

		if(data.getDraw()>0 && data.getLength() > 0){
			filtering +="OFFSET " + data.getStart() + " LIMIT "+ data.getLength()+" ";
		}else if(data.getLength() > 0){
			filtering +="LIMIT "+ data.getLength();
		}

		Map inputs = getInputs(data);

		return ExecuteQuery(playerQuery+filtering,inputs,data.getStart());
	}

	@Override
	public List<Map<String, Object>> getVenueData(PagingRequest data) {

		String query = "select count(*) OVER() AS totalCount,m.venue from match m " +
				"inner join tour_snap_shot tss on m.tour_id = tss.tour_name " +
				"where m.venue is not null ";

		String filtering = " ";
		if(CommonUtil.isNotBlank(data.getSearch())) {
			filtering +=andAppender(filtering)+" lower(m.venue) like :search_value ";
		}
		if(CommonUtil.isNotBlank(data.getTournamentYear())){
			filtering +=andAppender(filtering)+" tss.tournament_year = :tournament_year ";
		}
		if(CommonUtil.isNotBlank(data.getTournamentName())){
			filtering +=andAppender(filtering)+" tss.actual_tour_name = :tour_name ";
		}

		filtering +="group by m.venue ";

		filtering += getSortquery(data);

		if(data.getStart()>0 && data.getLength() > 0){
			filtering +="OFFSET " + String.valueOf(data.getStart() * data.getLength()) + " LIMIT "+ data.getLength()+" ";
		}else if(data.getLength() > 0){
			filtering +="LIMIT "+ data.getLength();
		}

		Map inputs = getInputs(data);
		return ExecuteQuery(query+filtering,inputs,data.getStart());
	}

	@Override
	public List<Map<String, Object>> getTournamentList(){
		String query ="select tss.actual_tour_name as tournamentName from tour_snap_shot tss group by tss.tour_name";
		return ExecuteQuery(query,new HashMap(),0);
	}

	private List<Map<String, Object>> ExecuteQuery(String query,Map inputs,int startIndex){
		List<Map<String, Object>> rows= new ArrayList<>();
		try {
			System.out.println(query);
			ResponseMapper responseMapper= new ResponseMapper();
			responseMapper.setIndex(startIndex);
			return namedParameterJdbcTemplate.query(query , inputs,responseMapper);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getSortquery(PagingRequest data){
		String sorting="";
		String sortColumnName = data.getColumns().get(data.getOrder().get(0).getColumn()).getData();
		if(sortColumnName.equals(ApplicationConstants.matchName)){
			sorting += "ORDER BY m.name " + data.getOrder().get(0).getDir() + " ";
		}else if(sortColumnName.equals(ApplicationConstants.team1)){
			sorting += "ORDER BY m.team1 " + data.getOrder().get(0).getDir() + " ";
		} else if(sortColumnName.equals(ApplicationConstants.team2)){
			sorting += "ORDER BY m.team2 " + data.getOrder().get(0).getDir() + " ";
		}else if(sortColumnName.equals(ApplicationConstants.venue)){
			sorting += "ORDER BY m.venue " + data.getOrder().get(0).getDir() + " ";
		}else if(sortColumnName.equals(ApplicationConstants.timeCode)){
			sorting += "ORDER BY max(d.timecode) " + data.getOrder().get(0).getDir() + " ";
		}else if(sortColumnName.equals(ApplicationConstants.playerName)){
			sorting += "ORDER BY p.name " + data.getOrder().get(0).getDir() + " ";
		}else if(sortColumnName.equals(ApplicationConstants.team)){
			sorting += "ORDER BY p.team_id " + data.getOrder().get(0).getDir() + " ";
		}
		return sorting;
	}

	private Map getInputs(PagingRequest data){
		Map inputs=new HashMap<>();

		if(CommonUtil.isNotBlank(data.getSearch())){
			inputs.put("search_value","%"+CommonUtil.replaceSpecialChar(data.getSearch().getValue()).toLowerCase()+"%");
		}
		if(CommonUtil.isNotBlank(data.getTournamentYear())){
			inputs.put("tournament_year",Integer.parseInt(data.getTournamentYear()));
		}
		if(CommonUtil.isNotBlank(data.getTournamentName())){
			inputs.put("tour_name",data.getTournamentName());
		}
		return inputs;
	}


	private String andAppender(String conditions) {
		
		return conditions.equals("")?"":" and ";
	}

	private String orAppender(String conditions) {

		return conditions.equals("")?"":" or ";
	}

}
