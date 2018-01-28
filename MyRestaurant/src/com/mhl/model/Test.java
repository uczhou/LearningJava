package com.mhl.model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Test extends JFrame{

	HumanResourceModel hrModel;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
	}
	
	public Test(){
		
		JTable jt=new JTable();
		hrModel=new HumanResourceModel();
		String sql="select empid,empname,sex,address,birthday,sfzid,xl,zhiwei,hf,tel2,mail,zctime,bz from hrinfo where empid=?";
		String params[]={
				"20102803"
		};
		hrModel.queryHumanResource(sql, params);
		jt.setModel(hrModel);
		
		
		this.add(jt);
		this.add(new JLabel("人事管理表"),"North");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}

}
