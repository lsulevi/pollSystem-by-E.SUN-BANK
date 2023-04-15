package com.ivan.vote.dto;

import javax.validation.constraints.NotNull;

public class Poll {

	@NotNull
	private Integer poll_item_id;

	public Integer getPoll_item_id() {
		return poll_item_id;
	}

	public void setPoll_item_id(Integer poll_item_id) {
		this.poll_item_id = poll_item_id;
	}
	
	
}
