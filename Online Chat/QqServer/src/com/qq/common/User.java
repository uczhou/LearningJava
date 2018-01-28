package com.qq.common;

import java.io.Serializable;

public class User extends Message {
	
	private boolean isValidUser;
	private String password;
	
	public User(){
		this.setMessageType(MessageType.message_user_login);
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String cs) {
		this.password = cs;
	}
	public boolean isValidUser() {
		return isValidUser;
	}
	public void setValidUser(boolean isValidUser) {
		this.isValidUser = isValidUser;
	}
	

}
