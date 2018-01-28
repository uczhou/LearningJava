package application;

public class GameTank extends Tank implements Runnable{
	
	public GameTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			fire();
			for(int i=0;i<30;i++){
				move();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.setDirection((int)Math.random()*4);
			if(!this.isValid()){
				break;
			}
			
		}
		
	}

}
