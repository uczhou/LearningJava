package com.qq.client.service;

import java.util.*;
import com.qq.client.view.*;

public class ManageQqChat {
	private HashMap<String,QqChat> manageQqChat=new HashMap<>();
	
	public void addQqChat(String friendID, QqChat qqChat){
		manageQqChat.put(friendID, qqChat);
	}
	
	public QqChat getQqChat(String friendID){
		return manageQqChat.get(friendID);
	}

}
