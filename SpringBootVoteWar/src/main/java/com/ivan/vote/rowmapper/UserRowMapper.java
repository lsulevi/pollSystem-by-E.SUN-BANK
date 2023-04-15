package com.ivan.vote.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ivan.vote.model.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUser_id(rs.getInt("user_id"));
		user.setUser_name(rs.getString("user_name"));
		user.setUser_email(rs.getString("user_email"));
		user.setUser_password(rs.getString("user_password"));
		user.setUser_gftm(rs.getTimestamp("user_gftm"));
		user.setUser_txtm(rs.getTimestamp("user_txtm"));

		return user;
	}

	
}
