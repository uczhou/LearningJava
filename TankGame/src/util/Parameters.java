package util;

import java.awt.Color;
import java.awt.Toolkit;

public class Parameters {
	
	private static int DEFAULT_SCREEN_WIDTH=400;
	private static int DEFAULT_SCREEN_HEIGHT=300;
	public static final int UP=0;
	public static final int RIGHT=1;
	public static final int DOWN=2;
	public static final int LEFT=3;
	public static final int DEFAULT_BULLET_NUM=5;
	public static final Color PLAYER_COLOR=Color.YELLOW;
	public static final Color DEFAULT_COLOR=Color.CYAN;
	
	public static int getWidth(){
		return DEFAULT_SCREEN_WIDTH;
	}
	
	public static int getHeight(){
		return DEFAULT_SCREEN_HEIGHT;
	}
	
	public void setMaximum(){
		DEFAULT_SCREEN_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width;
		DEFAULT_SCREEN_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	public void setDefault(){
		DEFAULT_SCREEN_WIDTH=400;
		DEFAULT_SCREEN_HEIGHT=300;
	}

}
