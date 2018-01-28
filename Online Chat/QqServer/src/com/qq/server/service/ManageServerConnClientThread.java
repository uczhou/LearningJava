package com.qq.server.service;

import java.util.*;
public class ManageServerConnClientThread {
	private static HashMap<String, ServerConnClientThread> serverConnClientThreads=new HashMap<String,ServerConnClientThread>();

	public static void addServerConnClientThread(String clientUserID, ServerConnClientThread serverConnClientThread){
		serverConnClientThreads.put(clientUserID, serverConnClientThread);
	}
	
	public static ServerConnClientThread getServerConnClientThread(String clientUserID){
		return serverConnClientThreads.get(clientUserID);
	}
	
	
}
