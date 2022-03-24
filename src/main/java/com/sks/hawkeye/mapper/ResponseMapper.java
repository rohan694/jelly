package com.sks.hawkeye.mapper;

import com.sks.hawkeye.util.ApplicationConstants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ResponseMapper implements RowMapper<Map<String, Object>> {
    private int index;

    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<String, Object> data = new LinkedHashMap<>();
        if(rowNum == 0 && hasColumn(rs,ApplicationConstants.totalCount.toLowerCase())){
            data.put(ApplicationConstants.totalCount,rs.getString(ApplicationConstants.totalCount.toLowerCase()));
        }
        data.put(ApplicationConstants.srNo,rowNum +1+ getIndex());
        if(hasColumn(rs,ApplicationConstants.tournamentName.toLowerCase()))
            data.put(ApplicationConstants.tournamentName,rs.getString(ApplicationConstants.tournamentName.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.matchName.toLowerCase()))
            data.put(ApplicationConstants.matchName,rs.getString(ApplicationConstants.matchName.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.team1.toLowerCase()))
            data.put(ApplicationConstants.team1,rs.getString(ApplicationConstants.team1.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.team2.toLowerCase()))
            data.put(ApplicationConstants.team2,rs.getString(ApplicationConstants.team2.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.venue.toLowerCase()))
            data.put(ApplicationConstants.venue,rs.getString(ApplicationConstants.venue.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.timeCode.toLowerCase()))
            data.put(ApplicationConstants.timeCode,rs.getString(ApplicationConstants.timeCode.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.playerName.toLowerCase()))
            data.put(ApplicationConstants.playerName,rs.getString(ApplicationConstants.playerName.toLowerCase()));
        if(hasColumn(rs,ApplicationConstants.team.toLowerCase()))
            data.put(ApplicationConstants.team,rs.getString(ApplicationConstants.team.toLowerCase()));
        return data;
    }

    private boolean hasColumn(ResultSet rs , String columnName){
        try {
           rs.getString(columnName);
           return true;
        } catch (java.sql.SQLException e) {
            return false;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
