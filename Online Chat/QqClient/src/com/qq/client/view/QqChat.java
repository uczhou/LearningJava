package com.qq.client.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.qq.client.service.ManageClientConnServerThread;
import com.qq.common.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class QqChat extends JFrame implements ActionListener {
	
	JTextArea jta;
	JTextField jtf;
	JScrollPane jsp;
	JButton jb1,jb2;
	JPanel jp1,jp2;
	String friendID;
	String userName;
	
	Socket socket=null;
	
	public QqChat(String friendID,String userName){
		this.friendID=friendID;
		this.userName=userName;
			//jpanel
		jp2=new JPanel();
		jb1=new JButton("�ر�");
		jb1.addActionListener(this);
		
		jb2=new JButton("����");
		jb2.addActionListener(this);
		
		jp2.add(jb1);
		jp2.add(jb2);
		
		jtf=new JTextField();
		
		jp1=new JPanel(new BorderLayout());
		jp1.add(jtf,"Center");
		jp1.add(jp2,"South");
		
		jta=new JTextArea();
		jsp=new JScrollPane(jta);
		
		this.setLayout(new BorderLayout());
		this.add(jsp,"Center");
		this.add(jp1, "South");
		try {
			this.setIconImage(ImageIO.read(new File("images/qq32.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTitle("�����ں�  "+friendID+"  ����");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	
	public static void main(String[] args){
		//QqChat qqChat=new QqChat("1");
	}
	
	public void updateMessage(CommonMessage commonMessage){
		String information=friendID+" ����˵��"+commonMessage.getContent()+"\n";
		this.jta.append(information);
	}
	
	public void addSendMessage(CommonMessage commonMessage){
		String information="���� "+friendID+" ˵��"+commonMessage.getContent()+"\n";
		this.jta.append(information);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){
			this.dispose();
		}else if(arg0.getSource()==jb2){
			CommonMessage commonMessage=new CommonMessage();
			commonMessage.setMessageType(MessageType.message_common);
			commonMessage.setContent(jtf.getText());
			commonMessage.setUserName(userName);
			commonMessage.setGetterID(friendID);
			this.addSendMessage(commonMessage);
			try {
				ObjectOutputStream objectOutputStream=new ObjectOutputStream
						(ManageClientConnServerThread.getClientConnServerThread(userName).getSocket().getOutputStream());
				objectOutputStream.writeObject(commonMessage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jtf.setText("");
			
		}
		
	}


}
