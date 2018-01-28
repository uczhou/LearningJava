package com.zhl.model;


import com.zhl.util.SqlHelper;

import java.sql.*;
import java.util.*;

public class UserService {
	
	public boolean checkUser(User user){
		boolean isValidUser=false;
		String sql="select * from onlineshopping where userid=? and password=?";
		String params[]={
				user.getUserid(),user.getPassword()
		};
		
		ResultSet resultSet=SqlHelper.executeQuery(sql, params);
		try {
			if(resultSet.next()){
				isValidUser=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), resultSet);
		}
		
		return isValidUser;
	}
	
	public ArrayList<User> queryUsers(int pageNow,int pageSize){
		String sql="select userid,password,email,username from ( select *,Row_Number() "
				+ "over ( order by userid ) as RowNumber from onlineshopping ) as PagedTable "
				+ "where RowNumber between ? and ?";
		String params[]={
				(pageSize*(pageNow-1)+1)+"", (pageSize*pageNow)+""
		};
		ResultSet resultSet=SqlHelper.executeQuery(sql, params);
		ArrayList<User> users=new ArrayList<User>();
		
		try {
			while(resultSet.next()){
				User user=new User();
				user.setUserid(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setUsername(resultSet.getString(4));
				users.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), resultSet);
		}
		
		return users;
		
	}
	
	public int countPages(int pageSize){
		String sql="select count(*) from onlineshopping";
		ResultSet resultSet=SqlHelper.executeQuery(sql, null);
		int rowCount=0;
		try {
			resultSet.next();
			rowCount=Integer.parseInt(resultSet.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), resultSet);
		}
		
		return (rowCount-1)/pageSize+1;
	}
	
	public boolean delUser(String userid){
		boolean isSuccess=false;
		String sql="delete from onlineshopping where userid=?";
		String params[]={
				userid
		};
		
		isSuccess=SqlHelper.executeUpdate(sql, params);
		
		SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), SqlHelper.getResultSet());
		
		return isSuccess;
	}
	
	public boolean addUser(User user){
		boolean isSuccess=false;
		String sql="insert into onlineshopping values(?,?,?,?)";
		String params[]={
				user.getUserid(),user.getPassword(),user.getEmail(),user.getUsername()
		};
		System.out.println(user.getPassword());
		isSuccess=SqlHelper.executeUpdate(sql, params);
		
		SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), SqlHelper.getResultSet());
		
		return isSuccess;
	}
	
	public boolean updateUser(User user){
		boolean isSuccess=false;
		String sql="update onlineshopping set password=?,email=?,username=?"
				+ "where userid=?";
		String params[]={
				user.getPassword(),user.getEmail(),user.getUsername(),user.getUserid()
		};

		isSuccess=SqlHelper.executeUpdate(sql, params);
		
		SqlHelper.close(SqlHelper.getConnection(), SqlHelper.getPreparedStatement(), SqlHelper.getResultSet());
		
		return isSuccess;
	}

}