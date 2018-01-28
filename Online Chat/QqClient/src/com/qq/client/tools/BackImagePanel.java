package com.qq.client.tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BackImagePanel extends JPanel{
	Image img;
	
	public BackImagePanel(String url){
		
		try {
			img=ImageIO.read(new File(url));
			int width=Toolkit.getDefaultToolkit().getScreenSize().width;
			int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			this.setSize(width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
	}
	
}
