package util;

import java.util.concurrent.ConcurrentLinkedQueue;

import application.Tank;

public class TankCollection {
	
	private static ConcurrentLinkedQueue<Tank> tanks;
	
	static {
		tanks=new ConcurrentLinkedQueue<Tank>();
	}
	
	public static boolean isEmpty(){
		return tanks.size()==0;
	}
	
	public static int size(){
		return tanks.size();
	}
	
	public static boolean addTank(Tank tank){
		if(tank==null)
			throw new java.lang.NullPointerException();
		tanks.add(tank);
		return true;
	}
	
	public static boolean removeTank(Tank tank){
		if(tank==null)
			throw new java.lang.NullPointerException();
		if(!tanks.contains(tank))
			return false;
		else return tanks.remove(tank);
	}
	
	public static ConcurrentLinkedQueue<Tank> getTanks(){
		return tanks;
	}

}
