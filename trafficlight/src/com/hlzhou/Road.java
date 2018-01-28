package com.hlzhou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Road {
	private List<String> vehicles;
	private String name;
	
	public Road(String name){
		this.name=name;
		vehicles = new ArrayList<String>();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(
				new Runnable(){		
					@Override
					public void run() {

							for(int i=1;i<1000;i++){
								try {
									Thread.sleep(((new Random()).nextInt(10)+1)*1000);
								} catch (InterruptedException e) {

									e.printStackTrace();
								}
								vehicles.add(Road.this.name+" NO. "+i+" Vehicle.");
						}		
					}
				}
				);
		
		ScheduledExecutorService timer= Executors.newScheduledThreadPool(1);
		timer.scheduleAtFixedRate(
				new Runnable(){

					@Override
					public void run() {
						String name=Road.this.name;
						if(Lamp.valueOf(name).isGreen())
							if(!vehicles.isEmpty()){
								String vehicle=vehicles.remove(0);
								System.out.println(vehicle);
							}
					}
					
				}, 
				1,
				1,
				TimeUnit.SECONDS);
		
	}

}
