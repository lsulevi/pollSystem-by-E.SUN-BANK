package com.ivan.vote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ivan.vote.model.PollDetail;

@Component
public class UserPollDaoImpl implements UserPollDao{

	@Autowired
	private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

	@Override
	public void createPollDetail(List<PollDetail> pollDetailList) {
		
		String sql = "INSERT INTO poll_detail(poll_detail_itemId, poll_detail_userEmail, poll_detail_gftm) VALUES (:pollDetailItemId, :pollDetailUserEmail, :pollDetailGftm)";
		
		MapSqlParameterSource[] parameterSource = new MapSqlParameterSource[pollDetailList.size()];
		
		for(int i = 0; i < pollDetailList.size() ; i++) {
			
			PollDetail pollDetail = pollDetailList.get(i);

			parameterSource[i] = new MapSqlParameterSource();
			parameterSource[i].addValue("pollDetailItemId", pollDetail.getPoll_detail_itemId());
			parameterSource[i].addValue("pollDetailUserEmail", pollDetail.getPoll_detail_userEmail());
			parameterSource[i].addValue("pollDetailGftm", pollDetail.getPoll_detail_gftm());
		
		}
		nameParameterJdbcTemplate.batchUpdate(sql, parameterSource);

	}
}
