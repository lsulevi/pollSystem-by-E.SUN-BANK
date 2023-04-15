package com.ivan.vote.model;

import java.util.Date;

import com.ivan.vote.constant.PollItemState;

public class PollItem {
	
	private Integer poll_item_id;
	private String poll_item_name;
	private String poll_item_description;
	private String poll_item_email;
	private Integer poll_item_count;
	private PollItemState poll_item_state;
	private Date poll_item_gftm;
	private Date poll_item_txtm;
	
	public Integer getPoll_item_id() {
		return poll_item_id;
	}
	public void setPoll_item_id(Integer poll_item_id) {
		this.poll_item_id = poll_item_id;
	}
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
	public Integer getPoll_item_count() {
		return poll_item_count;
	}
	public void setPoll_item_count(Integer poll_item_count) {
		this.poll_item_count = poll_item_count;
	}
	public PollItemState getPoll_item_state() {
		return poll_item_state;
	}
	public void setPoll_item_state(PollItemState poll_item_state) {
		this.poll_item_state = poll_item_state;
	}
	public Date getPoll_item_gftm() {
		return poll_item_gftm;
	}
	public void setPoll_item_gftm(Date poll_item_gftm) {
		this.poll_item_gftm = poll_item_gftm;
	}
	public Date getPoll_item_txtm() {
		return poll_item_txtm;
	}
	public void setPoll_item_txtm(Date poll_item_txtm) {
		this.poll_item_txtm = poll_item_txtm;
	}
	


}
