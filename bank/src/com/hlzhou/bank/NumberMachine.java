package com.hlzhou.bank;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberMachine {
	
	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized int generateNumber(){
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	
	public synchronized int getServiceNumber(){
		if(queueNumber.isEmpty())
			return -1;
		else return queueNumber.remove(0); 
	}
	
	public abstract void doService(ServiceType type,int windowNumber);

}
