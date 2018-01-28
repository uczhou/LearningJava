package com.hlzhou.bank;

public class VipNumberMachine extends NumberMachine{

	@Override
	public void doService(ServiceType type, int windowNumber) {
		int number = this.getServiceNumber();
		if(number == -1){
			System.out.println("No."+windowNumber+" "+type+" window rests for 1 second!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MachineManager.getInstance().getCommonMachine().doService(type,windowNumber);
		}else{
			System.out.println("No."+windowNumber+" "+type+" window is serving No."
					+number+" VIP customer! "+(Constants.VIP_CUSTORMER_SERVICE_TIME/1000)+" s");
			try {
				Thread.sleep(Constants.VIP_CUSTORMER_SERVICE_TIME);
				System.out.println("No."+windowNumber+" "+type+" window is waiting for next customer!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}
		
	}

	

}
