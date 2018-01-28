package application;

import javax.swing.JFrame;

import util.Parameters;

public class Game extends JFrame{
	
	public Game(){
		initiate();
	}

	private void initiate() {
		// TODO Auto-generated method stub
		Tank playerTank=new PlayerTank(10, 10,5);
		GamePanel gamePanel=new GamePanel(playerTank);
		this.add(gamePanel);
		this.addKeyListener(gamePanel);
		Thread panelThread=new Thread(gamePanel);
		panelThread.start();
		this.setSize(Parameters.getWidth(),Parameters.getHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
