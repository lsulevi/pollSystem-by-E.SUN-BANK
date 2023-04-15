package com.ivan.vote.model;

import java.util.Date;

public class PollDetail {

	private Integer poll_detail_id;
	private Integer poll_detail_itemId;
	private String poll_detail_userEmail;
	private Date poll_detail_gftm;
	
	public Integer getPoll_detail_id() {
		return poll_detail_id;
	}
	public void setPoll_detail_id(Integer poll_detail_id) {
		this.poll_detail_id = poll_detail_id;
	}
	public Integer getPoll_detail_itemId() {
		return poll_detail_itemId;
	}
	public void setPoll_detail_itemId(Integer poll_detail_itemId) {
		this.poll_detail_itemId = poll_detail_itemId;
	}
	public String getPoll_detail_userEmail() {
		return poll_detail_userEmail;
	}
	public void setPoll_detail_userEmail(String poll_detail_userEmail) {
		this.poll_detail_userEmail = poll_detail_userEmail;
	}
	public Date getPoll_detail_gftm() {
		return poll_detail_gftm;
	}
	public void setPoll_detail_gftm(Date poll_detail_gftm) {
		this.poll_detail_gftm = poll_detail_gftm;
	}
	

}
