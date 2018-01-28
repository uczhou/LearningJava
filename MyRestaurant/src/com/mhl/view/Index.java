/*
 * 闪屏效果
 * 
 */
package com.mhl.view;

import javax.sound.midi.SysexMessage;
import javax.swing.*;

import com.mhl.tools.BackImagePanel;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Index extends JWindow implements Runnable{

	//加入闪屏效果
	BackImagePanel bImg=new BackImagePanel("images//indeximage//index.gif");
	JProgressBar progressBar=new JProgressBar();
	Container ct;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index index= new Index();
		Thread t=new Thread(index);
		t.start();
		
	}
	
	public Index(){
		
		this.setSize(400, 260);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	
		this.setLocation(width/2-200, height/2-125);
		ct=this.getContentPane();
		
		//set up progressBar
				progressBar.setMinimum(0);
				progressBar.setMaximum(100);
				progressBar.setValue(0);
				progressBar.setStringPainted(true);
				
				//set jpanel
				bImg.setLayout(null);
				//bImg.add(new JLabel("test"),"1");
				ct.add(progressBar,"South");
				ct.add(bImg, "Center");
				//ct.add(new JLabel("test"), "Center");
			
				this.setVisible(true);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String[] wordToDisplay={
				"满","汉","楼","餐","饮","管","理","系","统"
		};
		String[] localNames={
				"费","城","店"
		};
		//JLabel jl1=new JLabel("test");
		
		Font f1=new Font("宋体", Font.PLAIN, 16);
		Font f2=new Font("宋体", Font.PLAIN, 12);
		System.out.println(wordToDisplay.length);
			try {
				//Let thread wait until loading bar finish loading, then relocate to login window
				int lengthOfTask=wordToDisplay.length+localNames.length;
				for(int i=0;i<lengthOfTask;i++){
					if(i<wordToDisplay.length){
						Thread.sleep(500);
					}else{
						//ct.add(new JLabel(localNames[i-wordToDisplay.length]));
						Thread.sleep(500);
					}
					Thread.sleep(500);
					int workLoader=(int) (((i+0.0)/lengthOfTask)*100);
					progressBar.setValue(workLoader);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Jump to login window
			System.out.println("闪屏结束");
			
			new UserLogin();
			//close the current window
			this.dispose();
			//exit the current thread
		}
		
	
	

}
