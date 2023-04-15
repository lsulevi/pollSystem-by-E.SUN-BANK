package com.ivan.vote.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.vote.dto.UserLoginRequest;
import com.ivan.vote.dto.UserRegisterRequest;
import com.ivan.vote.model.User;
import com.ivan.vote.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//註冊新帳號
	@PostMapping("/users/register")
	public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
		
		//創建帳號
		Integer userId = userService.register(userRegisterRequest);

		//依據所創建帳號取得user資訊
		User user = userService.getUserById(userId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);

	}
	
	//登入
	@PostMapping("/users/login")
	public ResponseEntity<User> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
		
		User user = userService.login(userLoginRequest);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
