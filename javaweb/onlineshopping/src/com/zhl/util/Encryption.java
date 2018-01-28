package com.zhl.util;

import java.security.*;

public class Encryption {
	
//	public static void main(String[] args){
//		for(int i=10;i>0;i--){
//		System.out.println(Encryption.getEncrypedPWD("1234"));
//		}
//	}
	
	public static String getEncrypedPWD(String password){
		byte[] resultData=null;
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(password.getBytes("utf-8"));
			resultData=md.digest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strBuffer=new StringBuffer();
	
		for(int i=0;i<resultData.length;i++){
			strBuffer.append(Integer.toHexString(0xff&resultData[i]));
		}
		
		return strBuffer.toString();
		
	}
	
	public static String getEncrypedPWD(String password, String algorithm){
		byte[] resultData=null;
		try {
			MessageDigest md=MessageDigest.getInstance(algorithm);
			md.update(password.getBytes("utf-8"));
			resultData=md.digest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strBuffer=new StringBuffer();
	
		for(int i=0;i<resultData.length;i++){
			strBuffer.append(Integer.toHexString(0xff&resultData[i]));
		}
		
		return strBuffer.toString();
		
		
	}

}
