package com.ivan.vote.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private Integer user_id;
	private String user_name;
	private String user_email;
	
	//使用者資訊回傳前端時忽略user_password變數
	@JsonIgnore
	private String user_password;
	private Date user_gftm;
	private Date user_txtm;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Date getUser_gftm() {
		return user_gftm;
	}
	public void setUser_gftm(Date user_gftm) {
		this.user_gftm = user_gftm;
	}
	public Date getUser_txtm() {
		return user_txtm;
	}
	public void setUser_txtm(Date user_txtm) {
		this.user_txtm = user_txtm;
	}

	
}
