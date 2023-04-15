package com.ivan.vote.service;

import com.ivan.vote.dto.UserLoginRequest;
import com.ivan.vote.dto.UserRegisterRequest;
import com.ivan.vote.model.User;

public interface UserService {
	
	//取得使用者資訊
	User getUserById(Integer userId);

	//註冊
	Integer register(UserRegisterRequest userRegisterRequest);

	//登入
	User login(UserLoginRequest userLoginRequest);

}
