package com.qq.client.model;

import com.qq.client.view.QqFriendList;
import com.qq.common.*;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class ClientLoginModel {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkUser(User user){
//		Socket socket=null;
//		boolean isValidUser=false;
//		try {
//			socket=new Socket("127.0.0.1",9999);
//			ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
//			objectOutputStream.writeObject(user);
//			
//			ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
//			User checkedUser=(User) objectInputStream.readObject();
//			isValidUser=checkedUser.isValidUser();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				if(socket!=null) socket.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
		//return isValidUser;
		return true;
	}
	

}
