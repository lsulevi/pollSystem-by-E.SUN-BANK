package com.ivan.vote.dao;

import java.util.List;

import com.ivan.vote.model.PollDetail;

public interface UserPollDao {

	//寫入投票細項
	void createPollDetail(List<PollDetail> pollDetailList);
}
