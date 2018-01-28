package com.qq.server.view;

import javax.swing.*;

import com.qq.common.MessageType;
import com.qq.common.User;
import com.qq.server.model.*;

import java.awt.*;
import java.awt.event.*;
public class QqServerLogin extends JFrame implements ActionListener{
	
	JLabel jl1,jl2;
	JTextField jtf;
	JPasswordField pwd;
	JButton jb1,jb2;
	JPanel jp1,jp2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqServerLogin qqServerLogin=new QqServerLogin();
	}
	
	public QqServerLogin(){
		
		jl1=new JLabel("用户名",JLabel.CENTER);
		jl2=new JLabel("密码",JLabel.CENTER);
		jtf=new JTextField();
		pwd=new JPasswordField();
		jp1=new JPanel(new GridLayout(2,2));
		
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jl2);
		jp1.add(pwd);
		
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jp2=new JPanel();
		jp2.add(jb1);
		jp2.add(jb2);
		
		this.setLayout(new BorderLayout());
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){
		User user=new User();
		user.setMessageType(MessageType.message_user_login);
		user.setUserName(jtf.getText().trim());
		user.setPassword(new String(pwd.getPassword()));
		ServerLoginModel serverLoginModel= new ServerLoginModel();
		if(serverLoginModel.checkUser(user)){
			Thread t1=new Thread(new QqServerView());
			t1.start();
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "用户名或密码错误");
		}
		}
		
	}

}
