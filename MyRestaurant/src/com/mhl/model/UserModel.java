package com.mhl.model;
import com.mhl.db.*;
import java.sql.*;

public class UserModel {
	
	SqlHelper sqlHelper=null;
	ResultSet rs=null;
			
	/**
	 * @param userName 
	 * @param password
	 * @return return user position if both userName and password matches data in database, else return empty string;
	 */
	public String checkUser(String userName, String password){
		String sql="select hrinfo.zhiwei from login, hrinfo where login.empid=hrinfo.empid and login.empid=? and login.passwd=?";
		String params[]={
				userName, password
		};
		String administrativeTitle="";
		sqlHelper=new SqlHelper();
		rs=sqlHelper.query(sql, params);
		try {
			if(rs.next()){
				administrativeTitle=rs.getString(1).trim();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlHelper.close();
		return administrativeTitle;
		
	}

}
