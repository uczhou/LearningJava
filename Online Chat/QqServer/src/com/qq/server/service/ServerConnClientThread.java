package com.qq.server.service;

import java.net.*;

import com.qq.common.*;
import com.qq.server.model.*;

import java.io.*;

public class ServerConnClientThread extends Thread{
	
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
				ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
				Message message=(Message) objectInputStream.readObject();
				if(message.getMessageType().equals(MessageType.message_user_login)){
					User user=(User)message;
					user.setValidUser(false);
					ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
					objectOutputStream.writeObject(user);
				}else if(message.getMessageType().equals(MessageType.message_common)){
					CommonMessage commonMessage=(CommonMessage) message;
					ObjectOutputStream objectOutputStream=new ObjectOutputStream
							(ManageServerConnClientThread.getServerConnClientThread(commonMessage.getGetterID()).getSocket().getOutputStream());
					objectOutputStream.writeObject(commonMessage);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
