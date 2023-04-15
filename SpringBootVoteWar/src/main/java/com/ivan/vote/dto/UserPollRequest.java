package com.ivan.vote.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class UserPollRequest {

	@NotEmpty
	private List<Poll> pollDetailList;

	public List<Poll> getPollDetailList() {
		return pollDetailList;
	}

	public void setPollDetailList(List<Poll> pollDetailList) {
		this.pollDetailList = pollDetailList;
	}
	
	
}
