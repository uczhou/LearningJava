package com.qq.common;

import java.io.Serializable;

public class Message implements Serializable {
	
	private String messageType;
	private String userName;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	

}
