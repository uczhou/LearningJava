package com.qq.server.db;

import java.sql.*;

public class SqlHelper {

	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=QQLogin";
	String dbName="honglei";
	String dbPassword="314429";
	
	public SqlHelper(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,dbName,dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			if(resultSet!=null) resultSet.close();
			if(preparedStatement!=null) preparedStatement.close();
			if(connection!=null) connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String sql, String[] params){
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				preparedStatement.setString(i+1, params[i]);
			}
			
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
		
	}
	
	
	
}
