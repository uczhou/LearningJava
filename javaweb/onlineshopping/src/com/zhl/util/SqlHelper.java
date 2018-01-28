package com.zhl.util;

import java.util.*;
import java.sql.*;
import java.io.*;

public class SqlHelper {
	
	private static String url;
	private static String driver;
	private static String dbUsername;
	private static String dbPassword;
	
	private static Properties properties=null;
	private static InputStream inputStream=null;
	
	private static Connection connection=null;
	private static PreparedStatement preparedStatement=null;
	private static ResultSet resultSet=null;
	
	static{
		properties=new Properties();
		inputStream=SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		System.out.println(inputStream);
		try {
			properties.load(inputStream);
			url=properties.getProperty("url");
			driver=properties.getProperty("driver");
			dbUsername=properties.getProperty("dbUsername");
			dbPassword=properties.getProperty("dbPassword");
			System.out.println("url= "+url);
			
			
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * @return Connection
	 */
	public static Connection getConnection(){
		return connection;
	}
	
	/**
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(){
		return preparedStatement;
	}
	
	/**
	 * @return
	 */
	public static ResultSet getResultSet(){
		return resultSet;
	}
	
	
	/**
	 * @param sql
	 * @param params
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, String[] params){
		try {
			connection=DriverManager.getConnection(url,dbUsername,dbPassword);
			preparedStatement=connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			System.out.println(sql);
			resultSet=preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * @param sql
	 * @param params
	 * @return boolean
	 */
	public static boolean executeUpdate(String sql,String[] params){
		boolean isSuccess=false;
		try {
			connection=DriverManager.getConnection(url,dbUsername,dbPassword);
			preparedStatement=connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			
			int i=preparedStatement.executeUpdate();
			isSuccess=i>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	public static boolean executeMultiUpdate(String[] sql,String[][] params){
		boolean isSuccess=true;
		for(int i=0;i<sql.length;i++){
			if(!executeUpdate(sql[i],params[i])){
				return isSuccess=false;
				//throw exception
			}
		}
		
		return isSuccess;
	}
	
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
		if(connection!=null){
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(preparedStatement!=null){
			try {
				preparedStatement.close();
				preparedStatement=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(resultSet!=null){
			try {
				resultSet.close();
				resultSet=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}