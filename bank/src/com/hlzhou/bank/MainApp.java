package com.hlzhou.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
	
	public static void main(String[] args){
		ServiceWindow commonWindow = new ServiceWindow(ServiceType.COMMON, 1);
		ServiceWindow vipWindow = new ServiceWindow(ServiceType.VIP, 1);
		ServiceWindow expressWindow = new ServiceWindow(ServiceType.EXPRESS, 1);
		
		commonWindow.start();
		vipWindow.start();
		expressWindow.start();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable(){

					@Override
					public void run() {
						int count = 0;
						while(true){
							try {
								Thread.sleep(1000);
								count++;
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							switch(count){
							case 3:
								MachineManager.getInstance().getExpressMachine().generateNumber();
								break;
							case 6:
								MachineManager.getInstance().getVipMachine().generateNumber();
								count = 0;
								break;
							default:
								MachineManager.getInstance().getCommonMachine().generateNumber();
								
								break;
							}
						}
						
					}
					
				}, 
				1,
				1, 
				TimeUnit.SECONDS
				);
	}

}
