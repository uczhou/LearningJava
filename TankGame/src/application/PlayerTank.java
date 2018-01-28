package application;

import java.util.ArrayList;

public class PlayerTank extends Tank{
	
	ArrayList<Bullet> bullets;
	int bulletNumber=5;

	public PlayerTank(int x, int y,int bulletNumber) {
		super(x, y);
		this.bulletNumber=bulletNumber;
		
	}
	
}
