package com.mhl.model;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.mhl.db.*;

public class HumanResourceModel extends AbstractTableModel{
	Vector<String>columnNames;
	Vector<Vector<String>> rowData;
	SqlHelper sqlHelper=null;
	ResultSet resultSet=null;
	
	public static void main(String[]args){
		HumanResourceModel hrm=new HumanResourceModel();
		//System.out.println(hrm.getColumnCount());
	}
	
	public void queryHumanResource(String sql, String[] params){
		sqlHelper=new SqlHelper();
		ResultSet resultSet=sqlHelper.query(sql, params);
		
        columnNames = new Vector<String>();
        
        
/*		columnNames.add("员工号");//empid
		columnNames.add("姓名");//empname
//	columnNames.add("照片");//empimage
		columnNames.add("性别");//sex
		columnNames.add("住址");//address
		columnNames.add("生日");//birthday
		columnNames.add("身份证号");//sfzid
		columnNames.add("学历");//xl
		columnNames.add("职位");//zhiwei
		columnNames.add("婚否");//hf
//		columnNames.add("私人电话");//tel1
		columnNames.add("工作电话");//tel2
		columnNames.add("电子邮箱");//mail
		columnNames.add("注册时间");//zctime
		columnNames.add("注册人");//bz
		*/
		
		
		rowData=new Vector<Vector<String>>();
		
		try {
			ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			for(int i=0;i<resultSetMetaData.getColumnCount();i++){
				System.out.println(resultSetMetaData.getColumnName(i+1));
				columnNames.add(resultSetMetaData.getColumnName(i+1));
			}
			while(resultSet.next()){
				Vector<String> row=new Vector<String>();
				for(int i=0;i<resultSetMetaData.getColumnCount();i++){
					row.add(resultSet.getString(i+1));
				}
				rowData.add(row);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlHelper.close();
		}
		
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return rowData.get(arg0).get(arg1);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames.get(column);
		//return super.getColumnName(column);
	}
	
	
	

}
