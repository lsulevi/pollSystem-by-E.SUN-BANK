package com.ivan.vote.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivan.vote.constant.PollItemState;
import com.ivan.vote.model.PollItem;

public class PollItemRowMapper implements RowMapper<PollItem> {

	@Override
	public PollItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		PollItem pollItem =  new PollItem();
		
		pollItem.setPoll_item_id(rs.getInt("poll_item_id"));
		pollItem.setPoll_item_name(rs.getString("poll_item_name"));
		pollItem.setPoll_item_description(rs.getString("poll_item_description"));
		pollItem.setPoll_item_email(rs.getString("poll_item_email"));
		String stateStr = rs.getString("poll_item_state");
		PollItemState state = PollItemState.valueOf(stateStr);
		pollItem.setPoll_item_count(rs.getInt("poll_item_count"));
		pollItem.setPoll_item_state(state);
		pollItem.setPoll_item_gftm(rs.getTimestamp("poll_item_gftm"));
		pollItem.setPoll_item_txtm(rs.getTimestamp("poll_item_txtm"));
	
		return pollItem;
	}

	
	
}
