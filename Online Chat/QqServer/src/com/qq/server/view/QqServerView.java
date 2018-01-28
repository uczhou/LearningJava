package com.qq.server.view;

import javax.swing.*;

import com.qq.common.*;
import com.qq.server.model.*;
import com.qq.server.service.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QqServerView extends JFrame implements Runnable{
	
	ServerSocket serverSocket=null;
	public QqServerView(){
		this.setTitle("QQ服务器");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		System.out.println("服务器启动成功！");
		
		try {
			serverSocket=new ServerSocket(9999);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				Socket socket = serverSocket.accept();
				ObjectInputStream  objectInputStream=new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
				User user=(User) objectInputStream.readObject();
				CheckClientLoginModel checkClientLoginModel= new CheckClientLoginModel();
				if(checkClientLoginModel.checkClientUser(user)){
					user.setValidUser(true);
					ServerConnClientThread serverConnClientThread=new ServerConnClientThread();
					serverConnClientThread.setSocket(socket);
					ManageServerConnClientThread.addServerConnClientThread(user.getUserName(), serverConnClientThread);
					serverConnClientThread.start();
					System.out.println(user.getUserName()+" 成功登陆！");
				}
				objectOutputStream.writeObject(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
	}
}
