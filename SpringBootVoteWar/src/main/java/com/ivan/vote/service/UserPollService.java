package com.ivan.vote.service;

import com.ivan.vote.dto.UserPollRequest;

public interface UserPollService {

	//建立使用者投票明細
	void createPollDetail(Integer userId, UserPollRequest userPollRequest);

}
