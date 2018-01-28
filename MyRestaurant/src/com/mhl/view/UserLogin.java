package com.mhl.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.mhl.model.UserModel;
import com.mhl.tools.BackImagePanel;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.*;

public class UserLogin extends JDialog implements ActionListener{
	
	JLabel jl1,jl2,jl3;
	JTextField jName;
	JPasswordField jPasswd;
	JButton jConfirm,jCancel;
	Font f1=new Font("����",Font.PLAIN, 16);
	Font f2=new Font("����", Font.PLAIN, 14);
	
	public static void main(String[] args){
		UserLogin userLogin=new UserLogin();
	}
	
	public UserLogin(){
		Container ct=this.getContentPane();
		this.setLayout(null);
		
		//Add jl1
		jl1=new JLabel("�������û���:");
		jl1.setFont(f1);
		jl1.setBounds(60,190,150,30);
		
		ct.add(jl1);
		
		//Add jl2
		jl2=new JLabel("����������:");
		jl2.setFont(f1);
		jl2.setBounds(60,240,150,30);
		
		ct.add(jl2);
		
		//add jName
		jName=new JTextField(20);
		jName.setFont(f1);
		jName.setBounds(180, 190, 120, 30);
		//set lowered border
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		ct.add(jName);
		
		//employee id
		jl3=new JLabel("(Ա����)");
		jl3.setFont(f2);
		//set front color
		jl3.setForeground(Color.red);
		jl3.setBounds(100,210,100,30);
		
		ct.add(jl3);
		
		//
		jPasswd=new JPasswordField(20);
		//jName.setFont(f1);
		jPasswd.setBounds(180, 240, 120, 30);
		//set lowered border
		jPasswd.setBorder(BorderFactory.createLoweredBevelBorder());
		
		ct.add(jPasswd);
		
		//add JButton
		jConfirm=new JButton("ȷ��");
		jConfirm.addActionListener(this);
		jConfirm.setFont(f1);
		jConfirm.setBounds(110, 300, 70, 30);
		
		ct.add(jConfirm);
		
		jCancel=new JButton("ȡ��");
		jCancel.addActionListener(this);
		jCancel.setFont(f1);
		jCancel.setBounds(220, 300, 70, 30);
		
		ct.add(jCancel);
		
		//create BackImage instance
		BackImagePanel bImage=new BackImagePanel("images//login//login.gif");
		//set image location
		bImage.setBounds(0, 0, 360, 360);
		//this.add(bImage);
		//Ҳ����������
		
		ct.add(bImage);
		//��ʹ�����¿�
		
		this.setUndecorated(true);
		this.setSize(360,360);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-180, height/2-180);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jConfirm){
			UserModel userModel=new UserModel();
			String userName=jName.getText().trim();
			String password=new String(jPasswd.getPassword());
			String administrativeTitle=userModel.checkUser(userName, password);
			
			//System.out.println(administrativeTitle);
			if(administrativeTitle.isEmpty()){
				JOptionPane.showMessageDialog(this, "�û��������벻��ȷ");
			}else if(administrativeTitle.equals("����")|| administrativeTitle.equals("�ϰ�")){
				//System.out.println(administrativeTitle);
				new MainWindow();
				this.dispose();
			}else if(administrativeTitle.equals("����")){
				//Jump to checkout window
				System.out.println("Check out");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "���Ϸ��û�");
			}
		}else if(arg0.getSource()==jCancel){
			this.dispose();
		}
		
	}
	
	/*//inner class
	class BackImage extends JPanel{
		Image img;
		public BackImage(){
			try {
				img=ImageIO.read(new File("images//login//login.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void paintComponent(Graphics g){
			g.drawImage(img, 0, 0, 360,360,this);
		}
	}*/
}
