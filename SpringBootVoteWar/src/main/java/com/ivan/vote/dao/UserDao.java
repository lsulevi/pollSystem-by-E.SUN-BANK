package com.ivan.vote.dao;

import com.ivan.vote.dto.UserRegisterRequest;
import com.ivan.vote.model.User;

public interface UserDao {

	//取得使者資訊
	User getUserById(Integer userId);
	
	//由email取得使用者資訊，用於檢核是否已註冊
	User getUserByEmail(String email);

	//創建帳號
	Integer createUser(UserRegisterRequest userRegisterRequest);

}
