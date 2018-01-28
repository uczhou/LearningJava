package com.mhl.db;

import java.sql.*;

/**
 * @author shshlx
 *
 */
public class SqlHelper {
	
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=Restaurant";
	String userName="honglei";
	String password="314429";
	
	public SqlHelper(){
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,userName,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param sql  sql query sequence
	 * @param params  parameters set
	 * @return resultset 
	 */
	public ResultSet query(String sql, String[] params){
		try {
			ps=ct.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setString(i+1, params[i]);
				}
			}
			
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
