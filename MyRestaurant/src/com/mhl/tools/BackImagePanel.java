package com.mhl.tools;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BackImagePanel extends JPanel {
	Image img;
	//int width,height;
	
	/*public BackImagePanel(String imageUrl, int width, int height){
		try {
			img=ImageIO.read(new File(imageUrl));
			this.setSize(width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public BackImagePanel(String imageUrl){
		try {
			img=ImageIO.read(new File(imageUrl));
			int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			this.setSize(width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img,0,0, this.getWidth(), this.getHeight(), this);
		
	}

	
	
	
}
