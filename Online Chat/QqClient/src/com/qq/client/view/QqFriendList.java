package com.qq.client.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.qq.client.service.ManageQqChat;
import com.qq.common.*;

public class QqFriendList extends JFrame implements ActionListener, MouseListener{
	
	
	ImageIcon imageIcon;
	//set Initial Panel
	JPanel initPanel, initPanel_panel;
	JButton initPanel_Button1,initPanel_Button2,initPanel_Button3;
	
	//set Friend Panel
	JPanel friendPanel,friendPanel_panel1,friendPanel_panel2,friendPanel_panel3;
	JScrollPane friendPanel_jsp;
	JButton friendPanel_Button1,friendPanel_Button2,friendPanel_Button3;
	JLabel[] friendLabel;
	
	//set Stranger Panel
	JPanel strangerPanel,strangerPanel_panel1,strangerPanel_panel2,strangerPanel_panel3;
	JScrollPane strangerPanel_jsp;
	JButton strangerPanel_Button1,strangerPanel_Button2,strangerPanel_Button3;
	
	//set Panel 3
	JPanel blackListPanel, blackListPanel_panel1,blackListPanel_panel2,blackListPanel_panel3;
	JScrollPane blackListPanel_jsp;
	JButton blackListPanel_Button1,blackListPanel_Button2,blackListPanel_Button3;
	CardLayout cardLayout;
	
	User user;
	
	private ManageQqChat manageQqChat; 
	
	public QqFriendList(User user){
		ManageQqChat newQqChat=new ManageQqChat();
		this.setManageQqChat(newQqChat);
		
		this.user=user;
		this.setTitle(user.getUserName());
		
		imageIcon=new ImageIcon("images/qq32.jpg");
		//initial Panel
		this.initPanel();
		
		//Friend Panel
		this.initFriendPanel();
		
		
		//set Panel 2
		this.initStrangerPanel();
		
		//set Panel 3
		this.initBlackListPanel();
	
		
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		
		this.add(initPanel,"init");
		this.add(friendPanel,"friend");
		this.add(strangerPanel,"stranger");
		this.add(blackListPanel,"blackList");
		
		initPanel_Button1.addActionListener(this);
		initPanel_Button2.addActionListener(this);
		initPanel_Button3.addActionListener(this);
		
		friendPanel_Button1.addActionListener(this);
		friendPanel_Button2.addActionListener(this);
		friendPanel_Button3.addActionListener(this);
		
		strangerPanel_Button1.addActionListener(this);
		strangerPanel_Button2.addActionListener(this);
		strangerPanel_Button3.addActionListener(this);
		
		blackListPanel_Button1.addActionListener(this);
		blackListPanel_Button2.addActionListener(this);
		blackListPanel_Button3.addActionListener(this);
		
		this.setSize(200,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			this.setIconImage(ImageIO.read(new File("images/qq32.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		User user=new User();
		user.setUserName("1");
		QqFriendList qqFriendList=new QqFriendList(user);
	}
	
	private void initPanel(){
		initPanel_Button1=new JButton("好友列表");
		initPanel_Button2=new JButton("陌生人");
		initPanel_Button3=new JButton("黑名单");
		initPanel_panel=new JPanel(new GridLayout(3,1));
		
		initPanel_panel.add(initPanel_Button1);
		initPanel_panel.add(initPanel_Button2);
		initPanel_panel.add(initPanel_Button3);
		
		initPanel=new JPanel(new BorderLayout());
		initPanel.add(initPanel_panel,"North");
	}
	
	private void initFriendPanel(){
		friendPanel_Button1=new JButton("好友列表");
		friendPanel_Button2=new JButton("陌生人");
		friendPanel_Button3=new JButton("黑名单");
		friendPanel=new JPanel(new BorderLayout());
		
		friendPanel_panel1=new JPanel(new GridLayout(1,1));
		friendPanel_panel1.add(friendPanel_Button1);
		
		friendPanel.add(friendPanel_panel1,"North");
		
		friendPanel_panel2=new JPanel(new GridLayout(2,1));
		friendPanel_panel2.add(friendPanel_Button2);
		friendPanel_panel2.add(friendPanel_Button3);
		
		friendPanel.add(friendPanel_panel2,"South");
		
		friendPanel_panel3=new JPanel(new GridLayout(50,1,4,4));
		
		friendLabel=new JLabel[50];
		for(int i=0;i<friendLabel.length;i++){
			friendLabel[i]=new JLabel(i+1+"", imageIcon, JLabel.LEFT);
			friendLabel[i].addMouseListener(this);
			friendPanel_panel3.add(friendLabel[i]);
		}
		
		friendPanel_jsp=new JScrollPane(friendPanel_panel3);
		
		friendPanel.add(friendPanel_jsp,"Center");
		
	}
	
	private void initStrangerPanel(){
		strangerPanel_Button1=new JButton("好友列表");
		strangerPanel_Button2=new JButton("陌生人");
		strangerPanel_Button3=new JButton("黑名单");
		strangerPanel=new JPanel(new BorderLayout());
		
		strangerPanel_panel1=new JPanel(new GridLayout(2,1));
		strangerPanel_panel1.add(strangerPanel_Button1);
		strangerPanel_panel1.add(strangerPanel_Button2);
		
		strangerPanel.add(strangerPanel_panel1,"North");
		
		strangerPanel_panel2=new JPanel(new GridLayout(1,1));
		strangerPanel_panel2.add(strangerPanel_Button3);
		
		strangerPanel.add(strangerPanel_panel2,"South");
		
		strangerPanel_panel3=new JPanel(new GridLayout(20,1,4,4));
		
		JLabel[] strangerLabel=new JLabel[20];
		for(int i=0;i<strangerLabel.length;i++){
			strangerLabel[i]=new JLabel(i+1+"", imageIcon, JLabel.LEFT);
			strangerPanel_panel3.add(strangerLabel[i]);
		}
		
		strangerPanel_jsp=new JScrollPane(strangerPanel_panel3);
		
		strangerPanel.add(strangerPanel_jsp,"Center");
		}
	
	private void initBlackListPanel(){
		blackListPanel_Button1=new JButton("好友列表");
		blackListPanel_Button2=new JButton("陌生人");
		blackListPanel_Button3=new JButton("黑名单");
		blackListPanel=new JPanel(new BorderLayout());
		
		blackListPanel_panel1=new JPanel(new GridLayout(3,1));
		blackListPanel_panel1.add(blackListPanel_Button1);
		blackListPanel_panel1.add(blackListPanel_Button2);
		blackListPanel_panel1.add(blackListPanel_Button3);
		
		blackListPanel.add(blackListPanel_panel1,"North");
		
		blackListPanel_panel3=new JPanel(new GridLayout(20,1,4,4));
		
		JLabel[] blackListLabel=new JLabel[20];
		for(int i=0;i<blackListLabel.length;i++){
			blackListLabel[i]=new JLabel(i+1+"", imageIcon, JLabel.LEFT);
			blackListPanel_panel3.add(blackListLabel[i]);
		}
		
		blackListPanel_jsp=new JScrollPane(blackListPanel_panel3);
		//jp1_jsp.add(jp1_panel3);
		
		blackListPanel.add(blackListPanel_jsp,"Center");
	}

	
	@Override
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==friendPanel_Button1||arg0.getSource()==strangerPanel_Button1||arg0.getSource()==blackListPanel_Button1||arg0.getSource()==initPanel_Button1){
			cardLayout.show(this.getContentPane(), "friend");
		}else if(arg0.getSource()==friendPanel_Button2||arg0.getSource()==strangerPanel_Button2||arg0.getSource()==blackListPanel_Button2||arg0.getSource()==initPanel_Button2){
			cardLayout.show(this.getContentPane(), "stranger");
		}else if(arg0.getSource()==friendPanel_Button3||arg0.getSource()==strangerPanel_Button3||arg0.getSource()==blackListPanel_Button3||arg0.getSource()==initPanel_Button3){
			cardLayout.show(this.getContentPane(), "blackList");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==2&&!arg0.isConsumed()){
			arg0.consume();
			for(int i=0;i<friendLabel.length;i++){
				System.out.println("double clicked");
				if(arg0.getSource()==friendLabel[i]){
					String friendID=i+1+"";
					QqChat qqChat=new QqChat(friendID,user.getUserName());
					this.getManageQqChat().addQqChat(friendID, qqChat);
				}
			}
			
		}
		
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public ManageQqChat getManageQqChat() {
		return manageQqChat;
	}

	public void setManageQqChat(ManageQqChat manageQqChat) {
		this.manageQqChat = manageQqChat;
	}
}
