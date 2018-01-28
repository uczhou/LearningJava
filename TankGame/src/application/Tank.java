package application;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ConcurrentLinkedQueue;
import util.Parameters;

public  class Tank {
	
	private Point2D location;
	private int direction;
	private int speed;
	private boolean isValid=true;
	private Color color;
	private ConcurrentLinkedQueue<Bullet> bullets;
	private int bulletNumber=Parameters.DEFAULT_BULLET_NUM;
	
	public Tank(int x, int y, int direction,Color color){
		setLocation(new Point2D(x, y));
		this.direction=direction;
		this.speed=1;
		bullets=new ConcurrentLinkedQueue<Bullet>();
		this.color=color;
	}
	
	public Tank(int x, int y){
		this(x,y,0,Parameters.DEFAULT_COLOR);
	}
	
	public void fire() {
		
		if(bullets.size()==bulletNumber)
			removeInvalidBullets();
		if(bullets.size()<bulletNumber){
			int x=this.getLocation().getX();
			int y=this.getLocation().getY();
			Bullet bullet;
			if(this.getDirection()==Parameters.UP||this.getDirection()==Parameters.DOWN)
				bullet=new RegularBullet(x+8, y+15, this.getDirection(), color);
			else 
				bullet=new RegularBullet(x+15, y+8, this.getDirection(), color);
			bullets.add(bullet);
			Thread bulletThread=new Thread(bullet);
			bulletThread.start();
		}
	}
	
	private void removeInvalidBullets() {
		int size=bullets.size();
		for(int i=0;i<size;i++){
			Bullet bullet=bullets.peek();
			if(!bullet.getLocation().isValid())
				bullets.remove(bullet);
		}
		
	}
	
	public void move(){
		synchronized(this){
			switch (direction) {
			case Parameters.UP:
				if (location.getY() > 0)
					location.setY(location.getY() - speed);
				break;
			case Parameters.DOWN:
				if (location.getY() < Parameters.getHeight())
					location.setY(location.getY() + speed);
				break;
			case Parameters.RIGHT:
				if (location.getX() < Parameters.getWidth())
					location.setX(location.getX() + speed);
				break;
			case Parameters.LEFT:
				if (location.getX() > 0)
					location.setX(location.getX() - speed);
				break;
			}
		}
			
	}
	
	public Point2D getLocation() {
		return location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void drawTank(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
