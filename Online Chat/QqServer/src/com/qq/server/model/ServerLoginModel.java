package com.qq.server.model;

import com.qq.common.User;
import com.qq.server.db.SqlHelper;
import java.sql.*;

public class ServerLoginModel {
	
	SqlHelper sqlHelper=null;
	ResultSet resultSet=null;
	
	
	public boolean checkUser(User user){
			boolean isValidUser=false;
			sqlHelper=new SqlHelper();
			String sql="select userPwd from userLogin where userID=?";
			String[] params={
					user.getUserName()
			};
			
			resultSet=sqlHelper.query(sql, params);
			
			try {
				if(resultSet.next()){
					isValidUser=resultSet.getString(1).equals(user.getPassword());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(resultSet!=null)
					try {
						resultSet.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				sqlHelper.close();
			}
			
			return isValidUser;
			
	}

}
