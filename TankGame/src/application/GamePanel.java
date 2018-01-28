package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import util.Parameters;

public class GamePanel extends JPanel implements KeyListener, Runnable{
	
	Tank tank;
	
	public GamePanel(Tank tank){
		this.tank=tank;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fill3DRect(0, 0, Parameters.getWidth(), Parameters.getHeight(), false);
		paintTank(g);
		
	}

	private void paintTank(Graphics g) {
		tank.drawTank(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Action");
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			tank.setDirection(Parameters.UP);
			tank.move();
			break;
		case KeyEvent.VK_RIGHT:
			tank.setDirection(Parameters.RIGHT);
			tank.move();
			break;
		case KeyEvent.VK_DOWN:
			tank.setDirection(Parameters.DOWN);
			tank.move();
			break;
		case KeyEvent.VK_LEFT:
			tank.setDirection(Parameters.LEFT);
			tank.move();
			break;
		case KeyEvent.VK_J:
			tank.fire();
			break;
		}
		
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	
	
	
	

}
