package com.qq.client.service;

import java.util.*;


public class ManageClientConnServerThread {
	
	private static HashMap<String,ClientConnServerThread> manageClientConnServerThread=new HashMap<>();

	public static void addClientConnServerThread(String userName, ClientConnServerThread clientConnServerThread){
		manageClientConnServerThread.put(userName, clientConnServerThread);
	}
	
	public static ClientConnServerThread getClientConnServerThread(String userName){
		return manageClientConnServerThread.get(userName);
	}

}
