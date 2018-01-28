package com.qq.client.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.qq.client.model.*;
import com.qq.client.service.*;
import com.qq.client.tools.*;
import com.qq.common.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

import java.net.*;


public class QqClientLogin extends JFrame implements ActionListener{
	//title
	Image titleIcon;
	// Panel 1
	JPanel jp1;
	JLabel jp1_label;
	ImageIcon jp1_icon;
	
	//Panel 2
	JTabbedPane jtp;
	JPanel jp2_panel1,jp2_panel2,jp2_panel3;
	JLabel jp2_p1_label1, jp2_p1_label2, jp2_p1_label3, jp2_p1_label4;
	JButton jp2_p1_button;
	JCheckBox jp2_p1_box1,jp2_p1_box2;
	JTextField jp2_p1_text;
	JPasswordField jp2_p1_password;
	
	//Panel 3
	JPanel jp3;
	JButton jp3_button1, jp3_button2, jp3_button3;
	
	Socket socket=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin qqClientLogin=new QqClientLogin();
	}
	
	public QqClientLogin(){
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//set  Panel 1
		jp1_icon=new ImageIcon("images/tou.gif");
		jp1_label=new JLabel(jp1_icon);
		//jp1=new JPanel();
		//jp1.add(jp1_label);
		
		this.add(jp1_label,"North");
		
		//set Panel 2 
		jtp=new JTabbedPane();
		jp2_p1_label1=new JLabel("QQ号码",JLabel.CENTER);
		jp2_p1_label2=new JLabel("QQ密码",JLabel.CENTER);
		jp2_p1_label3=new JLabel("忘记密码",JLabel.CENTER);
		jp2_p1_label4=new JLabel("申请密码保护",JLabel.CENTER);
		jp2_p1_box1=new JCheckBox("隐身登录");
		jp2_p1_box2=new JCheckBox("记住密码");
		jp2_p1_button=new JButton("清除号码");
		jp2_p1_text=new JTextField();
		jp2_p1_password=new JPasswordField();
		
		jp2_panel1=new JPanel(new GridLayout(3,3));
		jp2_panel1.add(jp2_p1_label1);
		jp2_panel1.add(jp2_p1_text);
		jp2_panel1.add(jp2_p1_button);
		jp2_panel1.add(jp2_p1_label2);
		jp2_panel1.add(jp2_p1_password);
		jp2_panel1.add(jp2_p1_label3);
		jp2_panel1.add(jp2_p1_box1);
		jp2_panel1.add(jp2_p1_box2);
		jp2_panel1.add(jp2_p1_label4);
		
		jp2_panel2=new JPanel();
		jp2_panel3=new JPanel();
		
		jtp.add("QQ号码", jp2_panel1);
		jtp.add("手机号码", jp2_panel2);
		jtp.add("电子邮箱", jp2_panel3);
		
		this.add(jtp,"Center");
		
		//set Panel 3;
		jp3=new JPanel();
		jp3_button1=new JButton("登录");
		jp3_button1.addActionListener(this);
		jp3_button2=new JButton("取消");
		jp3_button3=new JButton("注册向导");
		
		jp3.add(jp3_button1);
		jp3.add(jp3_button2);
		jp3.add(jp3_button3);
		
		this.add(jp3,"South");
		this.setSize(350,240);
		this.setTitle("QQ登录");
		try {
			titleIcon=ImageIO.read(new File("images/qq.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(titleIcon);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp3_button1){
			System.out.println("action performed");
			User user=new User();
			user.setMessageType(MessageType.message_user_login);
			user.setUserName(jp2_p1_text.getText());
			user.setPassword(new String(jp2_p1_password.getPassword()));
			
			try {
				socket=new Socket("127.0.0.1", 9999);
				ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
				objectOutputStream.writeObject(user);
				ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
				User checkedUser = (User) objectInputStream.readObject();
				if(checkedUser.isValidUser()){
					ClientConnServerThread clientConnServerThread=new ClientConnServerThread();
					clientConnServerThread.setSocket(socket);
					ManageClientConnServerThread.addClientConnServerThread(checkedUser.getUserName(), clientConnServerThread);
					clientConnServerThread.start();
					QqFriendList qqFriendList=new QqFriendList(checkedUser);
					ManageFriendList.addQqFriendList(checkedUser.getUserName(), qqFriendList);
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "用户名或密码错误");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		}
	}

	
}
