package util;

import java.awt.Graphics;

import application.Tank;

public class DrawTank {
	
	public static void draw(Tank tank, Graphics g){
		int x=tank.getLocation().getX();
		int y=tank.getLocation().getY();
		g.setColor(tank.getColor());
		switch(tank.getDirection()){
		case Parameters.UP:
			drawUpTank(x,y,g);
			break;
		case Parameters.RIGHT:
			drawRightTank(x,y,g);
			break;
		case Parameters.DOWN:
			drawDownTank(x,y,g);
			break;
		case Parameters.LEFT:
			drawLeftTank(x,y,g);
			break;
		}
	}
	
	
//	public void drawTank(Graphics g) {
//		
//		g.setColor(Color.CYAN);
//		switch(this.getDirection()){
//		case Parameters.UP:
//			drawUpTank(g);
//			break;
//		case Parameters.RIGHT:
//			drawRightTank(g);
//			break;
//		case Parameters.DOWN:
//			drawDownTank(g);
//			break;
//		case Parameters.LEFT:
//			drawLeftTank(g);
//			break;
//		}
//		
//		if(!bullets.isEmpty()){
//			for(Bullet bullet: bullets){
//				if(bullet.isValid()){
//					if(bullet.isPlayer())
//						bullet.drawBullet(g, Color.YELLOW);
//					else
//						bullet.drawBullet(g, Color.CYAN);
//				}
//					
//			}
//		}
//	}
	
	private static void drawLeftTank(int x,int y,Graphics g) {
		
		g.fill3DRect(x, y, 30, 5, false);
		g.fill3DRect(x, y+15, 30, 5, false);
		g.fill3DRect(x+5, y+5, 20, 10, false);
		g.fillOval(x+10, y+5, 10, 10);
		g.drawLine(x+15, y+10, x, y+10);
	}
	
	private static void drawDownTank(int x,int y,Graphics g) {
		
		g.fill3DRect(x, y, 5, 30, false);
		g.fill3DRect(x+15, y, 5, 30, false);
		g.fill3DRect(x+5, y+5, 10, 20, false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15, x+10, y+30);
		
	}
	
	private static void drawRightTank(int x,int y,Graphics g) {
		
		g.fill3DRect(x, y, 30, 5, false);
		g.fill3DRect(x, y+15, 30, 5, false);
		g.fill3DRect(x+5, y+5, 20, 10, false);
		g.fillOval(x+10, y+5, 10, 10);
		g.drawLine(x+15, y+10, x+30, y+10);
		
	}
	
	private static void drawUpTank(int x,int y,Graphics g) {
	
		g.fill3DRect(x, y, 5, 30, false);
		g.fill3DRect(x+15, y, 5, 30, false);
		g.fill3DRect(x+5, y+5, 10, 20, false);
		g.fillOval(x+5, y+10, 10, 10);
		g.drawLine(x+10, y+15, x+10, y);
	}

}
