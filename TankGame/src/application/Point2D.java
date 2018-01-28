package application;

import util.Parameters;

public class Point2D {
	
	private int x;
	private int y;
	
	public Point2D(int x, int y){
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isValid(){
		if (x < 0 || x > Parameters.getWidth() || y < 0
				|| y > Parameters.getHeight())
			return false;
		else
			return true;
	}
	
	

}
