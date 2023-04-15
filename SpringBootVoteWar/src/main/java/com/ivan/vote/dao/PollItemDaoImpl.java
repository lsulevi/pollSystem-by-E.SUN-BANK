package com.ivan.vote.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.ivan.vote.dto.PollItemRequest;
import com.ivan.vote.model.PollItem;
import com.ivan.vote.rowmapper.PollItemRowMapper;

@Component
public class PollItemDaoImpl implements PollItemDao{
	
	@Autowired
	private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

	@Override
	public List<PollItem> getPollItems() {
		
		String sql = "SELECT poll_item_id,poll_item_name,poll_item_description,poll_item_email,poll_item_count,poll_item_state,poll_item_gftm,poll_item_txtm  FROM poll_item WHERE poll_item_state = 'N'";
		
		Map<String, Object> map = new HashMap<>();

		List<PollItem> pollItemList = nameParameterJdbcTemplate.query(sql, map, new PollItemRowMapper() ); 

		return pollItemList;
	}
	
	@Override
	public PollItem getPollItemById(Integer pollItem) {
		
		String sql = "SELECT poll_item_id,poll_item_name,poll_item_description,poll_item_email,poll_item_count,poll_item_state,poll_item_gftm,poll_item_txtm FROM poll_item WHERE poll_item_id = :pollItemId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pollItemId",pollItem);
		
		List<PollItem> queryList = nameParameterJdbcTemplate.query(sql,map,new PollItemRowMapper() ); 
		
		if(queryList.size() > 0) {
			return queryList.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Integer createPollItem(PollItemRequest pollItemRequest) {
		
		String sql = "INSERT INTO poll_item(poll_item_name, poll_item_description, poll_item_email, poll_item_state,poll_item_gftm,poll_item_txtm)" +
					"VALUES (:pollItemName, :pollItemDescription, :pollItemEmail, :pollItemState, :pollItemGftm, :pollItemTxtm)";
		
		Map<String, Object> map = new HashMap<>();
		map.put("pollItemName", pollItemRequest.getPoll_item_name());
		map.put("pollItemDescription", pollItemRequest.getPoll_item_description());
		map.put("pollItemEmail", pollItemRequest.getPoll_item_email());
		map.put("pollItemState", pollItemRequest.getPoll_item_state());

		Date now = new Date();
		map.put("pollItemGftm", now);
		map.put("pollItemTxtm", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();
				
		nameParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		
		int pollItemId = keyHolder.getKey().intValue();
		
		return pollItemId;
	}
	
	@Override
	public void updatePollItem(Integer pollItemId, PollItemRequest pollItemRequest) {
		
		String sql = "UPDATE poll_item SET poll_item_name = :pollItemName, poll_item_description = :pollItemDescription, poll_item_state = :pollItemState,poll_item_txtm = :pollItemTxtm " +
				" WHERE poll_item_id = :pollItemId";		
		
		Map<String, Object> map = new HashMap<>();
		map.put("pollItemId", pollItemId);
		map.put("pollItemName", pollItemRequest.getPoll_item_name());
		map.put("pollItemDescription", pollItemRequest.getPoll_item_description());
		map.put("pollItemState", pollItemRequest.getPoll_item_state());
		map.put("pollItemTxtm", new Date());

		nameParameterJdbcTemplate.update(sql, map);
	}

	@Override
	public void updateCount(Integer pollItemId,Integer pollItemCount) {
		
		String sql = "UPDATE poll_item SET poll_item_count = :pollItemCount, poll_item_txtm = :pollItemTxtm" +
					"WHERE poll_item_id = :pollItemId";		
		Map<String, Object> map = new HashMap<>();
		map.put("pollItemCount", pollItemCount);
		map.put("pollItemTxtm", new Date());
		map.put("pollItemId", pollItemId);

		nameParameterJdbcTemplate.update(sql, map);
	}
	
}
