package com.hlzhou;

public class Starter {

	public static void main(String[] agrs){
		
		String[] directions=new String[]{
				"S2N","S2W","W2E","W2N",
				"N2S","N2E","E2W","E2S",
				"S2E","N2W","W2S","E2N"
		};
		
		new LampController(Lamp.S2N);
		
		for(int i=0;i<directions.length;i++){
			new Road(directions[i]);
		}
		
		
		
	}
}
