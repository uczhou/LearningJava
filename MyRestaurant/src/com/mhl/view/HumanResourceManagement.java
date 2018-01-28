package com.mhl.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.mhl.model.HumanResourceModel;
import com.mhl.tools.MyTools;

public class HumanResourceManagement extends JPanel {
	//Declare Human Resource Model
	HumanResourceModel humanResourceModel;
	
	//declare Panel 1
	JPanel jp1;
	JLabel jp1_label;
	JTextField jp1_textField;
	JButton jp1_button;
	
	//declare Panel 2
	//JPanel jp2;
	JScrollPane jp2_jsp;
	JLabel jp2_label;
	JTable jp2_table;
	
	
	//declare Panel 3
	JPanel jp3, jp3_panel;
	JLabel jp3_label;
	JButton jp3_button1, jp3_button2, jp3_button3, jp3_button4;
	
	//set up sql sequence and parameters
	String sql;
	String[] params;
	
	//number of lines shown
	int lineNumber;
	public HumanResourceManagement(){
		this.setLayout(new BorderLayout());
		//set up panel 1
		this.initPanelOne();
		
		//set up panel 2
		
		this.initPanelTwo();
		
		//set up panel 3
		this.initPanelThree();
	
		
	}
	
	private void initPanelOne(){
		//set Panel 1
		jp1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp1_label=new JLabel("请输入姓名（员工号或职位）:");
		jp1_label.setFont(MyTools.f1);
		
		jp1.add(jp1_label);
		
		jp1_textField=new JTextField(20);
		jp1_textField.setFont(MyTools.f1);
		
		jp1.add(jp1_textField);
		
		jp1_button=new JButton("查询");
		jp1_button.setFont(MyTools.f1);
		
		jp1.add(jp1_button);
		
		this.add(jp1,"North");		
	}
	private void initPanelTwo(){
		//jp2=new JPanel();
		
		jp2_table=new JTable();
		humanResourceModel= new HumanResourceModel();
		sql="select empid,empname,sex,address from hrinfo";
		params=null;
		humanResourceModel.queryHumanResource(sql, params);
		jp2_table.setModel(humanResourceModel);
		jp2_jsp=new JScrollPane(jp2_table);
		jp2_jsp.setBorder(BorderFactory.createLoweredBevelBorder());
		lineNumber=humanResourceModel.getRowCount();
		//jp2_jsp.setCorner(ScrollPaneConstants.UPPER_LEFT_CORNER , new JLabel("人事管理"));
		
		this.add(jp2_jsp);
	}
	private void initPanelThree(){
		jp3=new JPanel(new BorderLayout());
		jp3_label=new JLabel("共有"+lineNumber+"条记录");//!!!!!!!!!
		jp3_label.setFont(MyTools.f1);
		
		jp3.add(jp3_label,"West");
		
		jp3_panel=new JPanel();
		jp3_button1=new JButton("详细信息");
		jp3_button2=new JButton("添加");
		jp3_button3=new JButton("修改");
		jp3_button4=new JButton("删除");
		
		jp3_panel.add(jp3_button1);
		jp3_panel.add(jp3_button2);
		jp3_panel.add(jp3_button3);
		jp3_panel.add(jp3_button4);
		
		jp3.add(jp3_panel,"East");
		
		this.add(jp3,"South");
	}
/*
	public static void main(String[] args){
		HumanResourceManagement hrmv=new HumanResourceManagement();
	}
	*/
}
