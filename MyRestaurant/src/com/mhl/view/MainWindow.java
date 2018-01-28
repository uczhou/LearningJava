/**
 * Main Window for Administrator level login
 * 
 */
package com.mhl.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.mhl.tools.BackImagePanel;
import com.mhl.tools.MyTools;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class MainWindow extends JFrame implements ActionListener, MouseListener {
	//Declare container
	Container container;
	
	Image titleIcon;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jm1_item1,jm1_item2,jm1_item3,jm1_item4,jm1_item5;
	//ImageIcon jm1_icon1, jm1_icon2, jm1_icon3, jm1_icon4, jm1_icon5;
	
	//Tool bar
	JToolBar jtb;
	JButton jtb_b1,jtb_b2,jtb_b3,jtb_b4,jtb_b5,jtb_b6,jtb_b7,jtb_b8,jtb_b9,jtb_b10;
	ImageIcon jtb_icon1,jtb_icon2,jtb_icon3,jtb_icon4,jtb_icon5,jtb_icon6,jtb_icon7,jtb_icon8,jtb_icon9,jtb_icon10;
	
	//Main Panels
	JPanel jp1,jp2,jp3,jp4,jp5;
	//panel 1: labels and icons;
	JLabel jp1_label1,jp1_label2,jp1_label3,jp1_label4,jp1_label5,jp1_label6,jp1_label7,jp1_label8;
	ImageIcon jp1_icon1,jp1_icon2,jp1_icon3,jp1_icon4,jp1_icon5,jp1_icon6,jp1_icon7,jp1_icon8;
	BackImagePanel jp1_bImg;
	//panel 2,3,4: icons and cardlayout
	ImageIcon jp2_icon1,jp2_icon2;
	JLabel jp2_label1,jp2_label2;
	CardLayout cardLayout;
	BackImagePanel jp3_bImg1;
	
	//split panel
	JSplitPane jsp;
	
	//panel 5: component
	JLabel jp5_timeLabel;
	Timer t;

	private BackImagePanel jp3_bImg2;

	private BackImagePanel jp3_bImg3;
	
	/**
	 * initiate title
	 */
	private void initTitle(){
		//set title icon
				try {
					titleIcon=ImageIO.read(new File("images/title/title.gif"));		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setIconImage(titleIcon);
				
				//set title
				String title="酒店管理系统"+"    "+"当前用户： ";
				this.setTitle(title);
	}
	/**
	 * initiate menu
	 */
	private void initMenu(){
		//set menu
				jm1=new JMenu("系统管理	");
				jm1.setFont(MyTools.f1);
				//set menu items
				jm1_item1=new JMenuItem("切换用户", new ImageIcon("images/menuitem/jm1_icon1.jpg"));
				jm1_item1.setFont(MyTools.f2);
				jm1_item2=new JMenuItem("切换到收款界面", new ImageIcon("images/menuitem/jm1_icon2.jpg"));
				jm1_item2.setFont(MyTools.f2);
				jm1_item3=new JMenuItem("登录管理", new ImageIcon("images/menuitem/jm1_icon3.jpg"));
				jm1_item3.setFont(MyTools.f2);
				jm1_item4=new JMenuItem("万年历", new ImageIcon("images/menuitem/jm1_icon4.jpg"));
				jm1_item4.setFont(MyTools.f2);
				jm1_item5=new JMenuItem("退出", new ImageIcon("images/menuitem/jm1_icon5.jpg"));
				jm1_item5.setFont(MyTools.f2);
				
				jm1.add(jm1_item1);
				jm1.add(jm1_item2);
				jm1.add(jm1_item3);
				jm1.add(jm1_item4);
				jm1.add(jm1_item5);
				
				//
				
				jm2=new JMenu("人事管理	");
				jm2.setFont(MyTools.f1);
				jm3=new JMenu("菜单服务	");
				jm3.setFont(MyTools.f1);
				jm4=new JMenu("报表统计	");
				jm4.setFont(MyTools.f1);
				jm5=new JMenu("成本及库房	");
				jm5.setFont(MyTools.f1);
				jm6=new JMenu("帮助");
				jm6.setFont(MyTools.f1);
				
				
				//set Menu Bar
				jmb=new JMenuBar();
				jmb.add(jm1);
				jmb.add(jm2);
				jmb.add(jm3);
				jmb.add(jm4);
				jmb.add(jm5);
				jmb.add(jm6);
				
				this.setJMenuBar(jmb);
	}
	
	/**
	 * initiate tool bar
	 */
	private void initToolBar(){
		//set tool bar
				jtb=new JToolBar();
				jtb.setFloatable(false);
				//add button 1
				jtb_icon1=new ImageIcon("images/toolbar/jb1.jpg");
				jtb_b1=new JButton(jtb_icon1);
				jtb.add(jtb_b1);
				//add button 2
				jtb_icon2=new ImageIcon("images/toolbar/jb2.jpg");
				jtb_b2=new JButton(jtb_icon2);
				jtb.add(jtb_b2);
				//add button 3
				jtb_icon3=new ImageIcon("images/toolbar/jb3.jpg");
				jtb_b3=new JButton(jtb_icon3);
				jtb.add(jtb_b3);
				//add button 4
				jtb_icon4=new ImageIcon("images/toolbar/jb4.jpg");
				jtb_b4=new JButton(jtb_icon4);
				jtb.add(jtb_b4);
				//add button 5
				jtb_icon5=new ImageIcon("images/toolbar/jb5.jpg");
				jtb_b5=new JButton(jtb_icon5);
				jtb.add(jtb_b5);
				//add button 6
				jtb_icon6=new ImageIcon("images/toolbar/jb6.jpg");
				jtb_b6=new JButton(jtb_icon6);
				jtb.add(jtb_b6);
				//add button 7
				jtb_icon7=new ImageIcon("images/toolbar/jb7.jpg");
				jtb_b7=new JButton(jtb_icon7);
				jtb.add(jtb_b7);
				//add button 8
				jtb_icon8=new ImageIcon("images/toolbar/jb8.jpg");
				jtb_b8=new JButton(jtb_icon8);
				jtb.add(jtb_b8);
				//add button 9
				jtb_icon9=new ImageIcon("images/toolbar/jb9.jpg");
				jtb_b9=new JButton(jtb_icon9);
				jtb.add(jtb_b9);
				//add button 10
				jtb_icon10=new ImageIcon("images/toolbar/jb10.jpg");
				jtb_b10=new JButton(jtb_icon10);
				jtb.add(jtb_b10);
				
				container.add(jtb,"North");
	}
	
	/**
	 * initiate Panel one
	 */	
	private void initPanelOne(){
		//set the panel 1
		Cursor myCursor=new Cursor(Cursor.HAND_CURSOR);
		jp1=new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1_bImg=new BackImagePanel("images/panel/panel1/jp1_bg.jpg");
		jp1_bImg.setLayout(new GridLayout(8,1));
		//add label 1
		jp1_icon1=new ImageIcon("images/panel/panel1/label_1.gif");
		jp1_label1=new JLabel(jp1_icon1);
		jp1_bImg.add(jp1_label1);
		//add label 2
		jp1_icon2=new ImageIcon("images/panel/panel1/label_2.jpg");
		jp1_label2=new JLabel("人 事 管 理",jp1_icon2,0);
		jp1_label2.setFont(MyTools.f1);
		jp1_label2.setEnabled(false);
		jp1_label2.setCursor(myCursor);
		jp1_label2.addMouseListener(this);
		jp1_bImg.add(jp1_label2);
		//add label 3
		jp1_icon3=new ImageIcon("images/panel/panel1/label_3.jpg");
		jp1_label3=new JLabel("登 录 管 理",jp1_icon3,0);
		jp1_label3.setFont(MyTools.f1);
		jp1_label3.setEnabled(false);
		jp1_label3.setCursor(myCursor);
		jp1_label3.addMouseListener(this);
		jp1_bImg.add(jp1_label3);
		//add label 4
		jp1_icon4=new ImageIcon("images/panel/panel1/label_4.jpg");
		jp1_label4=new JLabel("菜 谱 价 格",jp1_icon4,0);
		jp1_label4.setFont(MyTools.f1);
		jp1_label4.setEnabled(false);
		jp1_label4.setCursor(myCursor);
		jp1_label4.addMouseListener(this);
		jp1_bImg.add(jp1_label4);
		//add label 5
		jp1_icon5=new ImageIcon("images/panel/panel1/label_5.jpg");
		jp1_label5=new JLabel("报 表 统 计",jp1_icon5,0);
		jp1_label5.setFont(MyTools.f1);
		jp1_label5.setEnabled(false);
		jp1_label5.setCursor(myCursor);
		jp1_label5.addMouseListener(this);
		jp1_bImg.add(jp1_label5);
		//add label 6
		jp1_icon6=new ImageIcon("images/panel/panel1/label_6.jpg");
		jp1_label6=new JLabel("成本及库房",jp1_icon6,0);
		jp1_label6.setFont(MyTools.f1);
		jp1_label6.setEnabled(false);
		jp1_label6.setCursor(myCursor);
		jp1_label6.addMouseListener(this);
		jp1_bImg.add(jp1_label6);
		//add label 7
		jp1_icon7=new ImageIcon("images/panel/panel1/label_7.jpg");
		jp1_label7=new JLabel("系 统 设 置",jp1_icon7,0);
		jp1_label7.setFont(MyTools.f1);
		jp1_label7.setEnabled(false);
		jp1_label7.setCursor(myCursor);
		jp1_label7.addMouseListener(this);
		jp1_bImg.add(jp1_label7);
		//add label 8
		jp1_icon8=new ImageIcon("images/panel/panel1/label_8.jpg");
		jp1_label8=new JLabel("动 画 帮 助",jp1_icon8,0);
		jp1_label8.setFont(MyTools.f1);
		jp1_label8.setEnabled(false);
		jp1_label8.setCursor(myCursor);
		jp1_label8.addMouseListener(this);
		jp1_bImg.add(jp1_label8);
		
		//add image panel to jp1 and put jp1 into container
		jp1.add(jp1_bImg);
		//ct.add(jp1,"Center");		
	}

	/**
	 * initiate Panel two
	 */	
	private void initPanelTwo(){
		//set panel 2
		jp2=new JPanel();
		jp2.setLayout(cardLayout);
		jp2_icon1=new ImageIcon("images/panel/panel2/jp2_left.jpg");
		jp2_label1=new JLabel(jp2_icon1);
		//jp2_label1.addMouseListener(this);
		
		jp2.add(jp2_label1,"jp2_label1");
		
		jp2_icon2=new ImageIcon("images/panel/panel2/jp2_right.jpg");
		jp2_label2=new JLabel(jp2_icon2);
		jp2.add(jp2_label2,"jp2_label2");
	}

	/**
	 * initiate Panel three
	 */	
	private void initPanelThree(){
		//set panel 3
				
				jp3=new JPanel();
				jp3.setLayout(cardLayout);
				jp3_bImg1=new BackImagePanel("images/panel/panel3/jp1_bg.jpg");
				jp3.add(jp3_bImg1,"jp3_bImg1");
				
				/*jp3_bImg2=new BackImagePanel("images/panel/panel3/jp3_hr.jpg");
				jp3.add(jp3_bImg2, "jp3_bImg2");
				
				jp3_bImg3=new BackImagePanel("images/panel/panel3/jp3_menu.jpg");
				jp3.add(jp3_bImg3, "jp3_bImg3");*/
				
				HumanResourceManagement jp3_humanResourceManagement=new HumanResourceManagement();
				jp3.add(jp3_humanResourceManagement, "jp3_humanResourceManagement");
				
	}

	/**
	 * initiate Panel five
	 */	
	private void initPanelFive(){
		//set the panel 5
				jp5=new JPanel();
				jp5.setLayout(new BorderLayout());
				BackImagePanel jp5_bImg=new BackImagePanel("images/panel/panel5/time_bg.jpg");
				jp5_bImg.setLayout(new BorderLayout());
				jp5_timeLabel = new JLabel("当前时间："+Calendar.getInstance().getTime().toString()+"   ");
				jp5_timeLabel.setFont(MyTools.f1);
				t=new Timer(1000,this);
				t.start();
				jp5_bImg.add(jp5_timeLabel,"East");
				
				jp5.add(jp5_bImg);
				container.add(jp5,"South");
	}
	
	/**
	 * Constructor
	 */
	public MainWindow(){
		//create container
		container=this.getContentPane();
		//create cardlayout
		cardLayout=new CardLayout();
		
		//initiate title
		this.initTitle();
		
		//initiate menu
		this.initMenu();
		
		//initiate toolbar
		this.initToolBar();
		
		//initiate panel 1
		this.initPanelOne();
		
		//initiate panel 2
		this.initPanelTwo();
		
		//initiate panel 3
		this.initPanelThree();
		
		//set panel 4
		jp4=new JPanel();
		jp4.setLayout(new BorderLayout());
		//add panel 2 and 3 to panel 4		
		jp4.add(jp2,"West");
		jp4.add(jp3, "Center");
		
		//set split panel
		jsp= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1,jp4);
		//set left panel size
		jsp.setDividerLocation(180);
		jsp.setDividerSize(0);
		
		container.add(jsp);
		
		//initiate panel 5
		this.initPanelFive();
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width-100, height-100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		MainWindow mainWindow=new MainWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.jp5_timeLabel.setText("当前时间："+Calendar.getInstance().getTime().toString()+"   ");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_label2){
			this.cardLayout.show(jp3, "jp3_humanResourceManagement");
		}
		if(e.getSource()==jp1_label4){
			this.cardLayout.show(jp3, "jp3_bImg3");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_label2){
			this.jp1_label2.setEnabled(true);
		}
		if(e.getSource()==jp1_label3){
			this.jp1_label3.setEnabled(true);
		}
		if(e.getSource()==jp1_label4){
			this.jp1_label4.setEnabled(true);
		}
		if(e.getSource()==jp1_label5){
			this.jp1_label5.setEnabled(true);
		}
		if(e.getSource()==jp1_label6){
			this.jp1_label6.setEnabled(true);
		}
		if(e.getSource()==jp1_label7){
			this.jp1_label7.setEnabled(true);
		}
		if(e.getSource()==jp1_label8){
			this.jp1_label8.setEnabled(true);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_label2){
			this.jp1_label2.setEnabled(false);
		}
		if(e.getSource()==jp1_label3){
			this.jp1_label3.setEnabled(false);
		}
		if(e.getSource()==jp1_label4){
			this.jp1_label4.setEnabled(false);
		}
		if(e.getSource()==jp1_label5){
			this.jp1_label5.setEnabled(false);
		}
		if(e.getSource()==jp1_label6){
			this.jp1_label6.setEnabled(false);
		}
		if(e.getSource()==jp1_label7){
			this.jp1_label7.setEnabled(false);
		}
		if(e.getSource()==jp1_label8){
			this.jp1_label8.setEnabled(false);
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
