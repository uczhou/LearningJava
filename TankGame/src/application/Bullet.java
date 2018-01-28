package application;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import util.Parameters;
import util.TankCollection;
import util.UtilTools;

public abstract class Bullet implements Runnable{
	private Point2D location;
	private int direction;
	private int speed;
	private boolean isPlayer=false;
	private boolean isValid;
	private Color color;
	
	public Bullet(int x, int y,int direction,Color color){
		location=new Point2D(x, y);
		this.direction=direction;
		speed=1;
		isValid=location.isValid();
		this.color=color;
	}
	

	public Point2D getLocation() {
		return location;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!location.isValid())
				break;
			switch(direction){
			case Parameters.UP:
				location.setY(location.getY()-speed);
				break;
			case Parameters.RIGHT:
				location.setX(location.getX()+speed);
				break;
			case Parameters.DOWN:
				location.setY(location.getY()+speed);
				break;
			case Parameters.LEFT:
				location.setX(location.getX()-speed);
				break;
			}
			//Check if tanks are shot by the bullet
			int size=TankCollection.size();
			for(int i=0;i<size;i++){
				Tank tank=TankCollection.getTanks().peek();
				if(UtilTools.attacked(tank, this)){
					bomb();
					tank.setValid(false);
					setValid(false);
				}
					
			}
			
		}
		
	}
	
	public abstract void bomb();
	
	public boolean isValid() {
		return isValid&&location.isValid();
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
}
