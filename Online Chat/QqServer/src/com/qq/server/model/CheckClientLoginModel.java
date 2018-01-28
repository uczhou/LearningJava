package com.qq.server.model;

import com.qq.common.User;
import com.qq.server.db.*;
import java.sql.*;

public class CheckClientLoginModel {
	
	SqlHelper sqlHelper=null;
	ResultSet resultSet=null;
	
	public boolean checkClientUser(User user){
		boolean isValidClientUser=false;
		sqlHelper=new SqlHelper();
		String sql="select clientUserPWD from clientUserLogin where clientUserID=?";
		String[] params={
				user.getUserName()
		};
		resultSet=sqlHelper.query(sql, params);
		
		try {
			if(resultSet.next()){
				isValidClientUser=true;
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
		
		return isValidClientUser;
		
	}

}
