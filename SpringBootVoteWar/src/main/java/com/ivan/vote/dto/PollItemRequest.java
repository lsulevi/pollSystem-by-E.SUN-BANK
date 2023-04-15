package com.ivan.vote.dto;

import javax.validation.constraints.NotNull;

public class PollItemRequest {

	@NotNull
	private String poll_item_name;
	private String poll_item_description;
	
	@NotNull
	private String poll_item_email;
	private String poll_item_state;
	
	public String getPoll_item_name() {
		return poll_item_name;
	}
	public void setPoll_item_name(String poll_item_name) {
		this.poll_item_name = poll_item_name;
	}
	public String getPoll_item_description() {
		return poll_item_description;
	}
	public void setPoll_item_description(String poll_item_description) {
		this.poll_item_description = poll_item_description;
	}
	public String getPoll_item_email() {
		return poll_item_email;
	}
	public void setPoll_item_email(String poll_item_email) {
		this.poll_item_email = poll_item_email;
	}
	public String getPoll_item_state() {
		return poll_item_state;
	}
	public void setPoll_item_state(String poll_item_state) {
		this.poll_item_state = poll_item_state;
	}
	

}
