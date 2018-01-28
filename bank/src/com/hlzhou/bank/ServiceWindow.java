package com.hlzhou.bank;

import java.util.concurrent.Executors;

public class ServiceWindow {
	
	private ServiceType type;
	private int windowNumber;
	
	public ServiceWindow(ServiceType type, int windowNumber){
		this.type = type;
		this.windowNumber = windowNumber;
	};
	
	public void start(){
		Executors.newSingleThreadExecutor().execute(
				new Runnable(){

					@Override
					public void run() {
						while(true){
							NumberMachine numberMachine = null;
							switch (type) {
							case COMMON:
								numberMachine = MachineManager.getInstance()
								.getCommonMachine();
								break;
							case EXPRESS:
								numberMachine = MachineManager.getInstance()
								.getExpressMachine();
								break;
							case VIP:
								numberMachine = MachineManager.getInstance()
								.getVipMachine();
								break;
							}

							numberMachine.doService(type, windowNumber);
						}
						
					}
					
				}
				);
	}

}
