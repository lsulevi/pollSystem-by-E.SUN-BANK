package com.ivan.vote.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import com.ivan.vote.dao.UserDao;
import com.ivan.vote.dto.UserLoginRequest;
import com.ivan.vote.dto.UserRegisterRequest;
import com.ivan.vote.model.User;

@Component
public class UserServiceImpl implements UserService{

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public Integer register(UserRegisterRequest userRegisterRequest) {
		//檢核註冊的email
		User user = userDao.getUserByEmail(userRegisterRequest.getUser_email());

		if(user != null) {
			log.warn("該email {} 已經被註冊",userRegisterRequest.getUser_email());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		//使用md5生成密碼雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getUser_password().getBytes());
		userRegisterRequest.setUser_password(hashedPassword);

		//創建帳號
		return userDao.createUser(userRegisterRequest);
	}
	
	@Override
	public User login(UserLoginRequest userLoginRequest) {

		User user = userDao.getUserByEmail(userLoginRequest.getUser_email());
		
		if(user == null) {
			log.warn("該email {} 尚未註冊", userLoginRequest.getUser_email());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		//使用md5生成密碼雜湊值
		String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getUser_password().getBytes());
		
		if(user.getUser_password().equals(hashedPassword)) {
			return user;
		}else {
			log.warn("該email {} 的密碼不正確", userLoginRequest.getUser_email());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
