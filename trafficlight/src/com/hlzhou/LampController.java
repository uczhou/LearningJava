package com.hlzhou;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LampController {
	
	private Lamp currentLamp;
	
	public LampController(Lamp currentLamp){
		this.currentLamp=currentLamp;
		this.currentLamp.turnGreen();
		ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
		timer.scheduleAtFixedRate(
				new Runnable(){

					@Override
					public void run() {
						LampController.this.currentLamp
							=LampController.this.currentLamp.turnRed();
					}
					
				}, 
				10,
				10, 
				TimeUnit.SECONDS);
	}

}
