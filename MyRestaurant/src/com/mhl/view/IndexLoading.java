package com.mhl.view;

import javax.swing.*;
import java.awt.*;

public class IndexLoading extends JFrame implements Runnable {
	
	JProgressBar progressBar=new JProgressBar();
	JPanel jp=new JPanel();
	
	public static void main(String[] args){
		IndexLoading indexLoading=new IndexLoading();
	}
	
	public IndexLoading(){
		//�����������ڴ�С
		this.setSize(400, 250);
		this.setUndecorated(true);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-125);
		
		//set up progressBar
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		//set jpanel
		jp.setSize(400,200);
		jp.setLayout(new GridLayout(10,10));
		
		this.add(progressBar,"South");
		this.add(jp, "Center");
		
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String[] wordToDisplay={
				"��","��","¥","��","��","��","��","ϵ","ͳ"
		};
		String[] localNames={
				"��","��","��"
		};
		
		Font f1=new Font("����", Font.PLAIN, 16);
		Font f2=new Font("����", Font.PLAIN, 12);
		
		for(int i=0;i<wordToDisplay.length;i++){
			
		}
	}

}
