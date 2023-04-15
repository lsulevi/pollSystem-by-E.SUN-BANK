package com.ivan.vote.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivan.vote.dto.UserPollRequest;
import com.ivan.vote.service.UserPollService;

@RestController
public class UserPollController {

	@Autowired
	private UserPollService userPollService;
	
	//進行投票，一人多票制
	@PostMapping("/users/{userId}/polls")
	public ResponseEntity<?> createPollDetail(@PathVariable Integer userId, 
			@RequestBody @Valid UserPollRequest userPollRequest){
		
		userPollService.createPollDetail(userId, userPollRequest);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
