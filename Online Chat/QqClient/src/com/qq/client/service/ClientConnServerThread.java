package com.qq.client.service;

import java.net.*;
import java.io.*;
import com.qq.common.*;
import com.qq.client.view.*;

public class ClientConnServerThread extends Thread{
	
	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void run(){
		while (true){
			try {
				ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
				Message message=(Message) objectInputStream.readObject();
				if(message.getMessageType().equals(MessageType.message_common)){
					CommonMessage commonMessage=(CommonMessage) message;
					System.out.println("发送的信息是："+commonMessage.getContent());
					
					QqChat qqChat=ManageFriendList.getQqFriendList
							(commonMessage.getGetterID()).getManageQqChat().getQqChat(commonMessage.getUserName());
					qqChat.updateMessage(commonMessage);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
