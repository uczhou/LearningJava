package com.hlzhou.bank;

public class MachineManager {
	
	private MachineManager(){
		
	}
	
	private static MachineManager machineManager = new MachineManager();
	
	//To be implemented;
	private NumberMachine commonMachine = new CommonNumberMachine();
	private NumberMachine expressMachine = new ExpressNumberMachine();
	private NumberMachine vipMachine = new VipNumberMachine();
	
	public static MachineManager getInstance(){
		return machineManager;
	}
	
	public NumberMachine getCommonMachine(){
		return commonMachine;
	}

	public NumberMachine getExpressMachine() {
		return expressMachine;
	}

	public NumberMachine getVipMachine() {
		return vipMachine;
	}
	
	

}
