package util;

import application.Bullet;
import application.Tank;

public class UtilTools {
	
	public static boolean attacked(Tank tank, Bullet bullet){
		int bullet_x=bullet.getLocation().getX();
		int bullet_y=bullet.getLocation().getY();
		int tank_x=tank.getLocation().getX();
		int tank_y=tank.getLocation().getY();
		boolean attacked=false;
		switch(tank.getDirection()){
		case Parameters.UP:
		case Parameters.DOWN:
			if(bullet_x>tank_x&&bullet_x<tank_x+20&&bullet_y>tank_y&&bullet_y<tank_y+30)
				attacked=true;
			break;
		case Parameters.RIGHT:
		case Parameters.LEFT:
			if(bullet_x>tank_x&&bullet_x<tank_x+30&&bullet_y>tank_y&&bullet_y<tank_y+20)
				attacked=true;
			break;
		}
		return attacked;
	}

}
