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

import com.ivan.vote.dto.UserRegisterRequest;
import com.ivan.vote.model.User;
import com.ivan.vote.rowmapper.UserRowMapper;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private NamedParameterJdbcTemplate nameParameterJdbcTemplate;

	@Override
	public User getUserById(Integer userId) {
		
		String sql = "SELECT user_id, user_name, user_email, user_password, user_gftm,user_txtm FROM user WHERE user_id = :userId";

		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		
		List<User> userList = nameParameterJdbcTemplate.query(sql, map, new UserRowMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}else {
			return null;
		}
		
	}
	
	@Override
	public User getUserByEmail(String email) {
		
		String sql = "SELECT user_id, user_name, user_email, user_password, user_gftm,user_txtm FROM user WHERE user_email = :email";
		
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		
		List<User> userList = nameParameterJdbcTemplate.query(sql, map, new UserRowMapper());

		if(userList.size() > 0) {
			return userList.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public Integer createUser(UserRegisterRequest userRegisterRequest) {

		String sql = "INSERT INTO USER(user_name, user_email, user_password, user_gftm,user_txtm) " + 
					"VALUES (:user_name, :user_email, :user_password, :user_gftm, :user_txtm)";
		
		Map<String, Object> map = new HashMap<>();
		map.put("user_name", userRegisterRequest.getUser_name());
		map.put("user_email", userRegisterRequest.getUser_email());
		map.put("user_password", userRegisterRequest.getUser_password());

		Date now = new Date();
		map.put("user_gftm", now);
		map.put("user_txtm", now);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		nameParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		
		//資料庫自動生成的userId
		int userId = keyHolder.getKey().intValue();
		
		return userId;
	}
}
