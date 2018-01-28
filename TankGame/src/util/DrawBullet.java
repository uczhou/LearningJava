package util;

import java.awt.Graphics;

import application.Bullet;

public class DrawBullet {
	public void drawBullet(Bullet bullet, Graphics g) {

		int x = bullet.getLocation().getX();
		int y = bullet.getLocation().getY();
		g.setColor(bullet.getColor());
		g.fillOval(x, y, 5, 5);

	}
}
