package application;

import java.awt.Color;
import java.awt.Graphics;

public class RegularBullet extends Bullet{

	public RegularBullet(int x, int y, int direction, Color color) {
		super(x, y, direction, color);
		// TODO Auto-generated constructor stub
	}

	public void drawBullet(Graphics g, Color color) {
		
		int x=this.getLocation().getX();
		int y=this.getLocation().getY();
		g.setColor(color);
		g.fillOval(x, y, 5, 5);
		
	}

	@Override
	public void bomb() {
		// TODO Auto-generated method stub
		
	}

}
