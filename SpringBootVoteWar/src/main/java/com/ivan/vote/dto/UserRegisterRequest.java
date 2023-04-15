package com.ivan.vote.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterRequest {

	//接收前端傳回參數設定不為空，且為email格式
	@NotBlank
	@Email
	private String user_email;
	
	@NotBlank
	private String user_name;
	
	@NotBlank
	private String user_password;
	
	
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	

}
