package com.hlzhou;

public enum Lamp {
	S2N("N2S","S2W",false),S2W("N2E","W2E",false),W2E("E2W","W2N",false),W2N("E2S","S2N",false),
	N2S(null,null,false),N2E(null,null,false),E2W(null,null,false),E2S(null,null,false),
	S2E(null,null,true),N2W(null,null,true),W2S(null,null,true),E2N(null,null,true);
	
	private Lamp(String opposite,String next,boolean isGreen){
		this.opposite=opposite;
		this.next=next;
		green=isGreen;
	}
	
	private Lamp(){
		
	}
	
	private boolean green;
	private String opposite;
	private String next;
	
	
	public boolean isGreen(){
		return this.green;
	}
	
	public Lamp turnRed(){
		this.green=false;
		if(this.opposite!=null){
			Lamp.valueOf(this.opposite).turnRed();
		}
		Lamp nextLamp=null;
		if(this.next!=null){
			nextLamp=Lamp.valueOf(this.next);
			nextLamp.turnGreen();		
		}
		return nextLamp;
	}
	
	public void turnGreen(){
		this.green=true;
		System.out.println("********"+this.name()+" is Green*******");
		if(this.opposite!=null){
			Lamp.valueOf(this.opposite).turnGreen();
		}
		
	}

}
