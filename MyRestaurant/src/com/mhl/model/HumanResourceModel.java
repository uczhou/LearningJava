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
        
        
/*		columnNames.add("Ա����");//empid
		columnNames.add("����");//empname
//	columnNames.add("��Ƭ");//empimage
		columnNames.add("�Ա�");//sex
		columnNames.add("סַ");//address
		columnNames.add("����");//birthday
		columnNames.add("���֤��");//sfzid
		columnNames.add("ѧ��");//xl
		columnNames.add("ְλ");//zhiwei
		columnNames.add("���");//hf
//		columnNames.add("˽�˵绰");//tel1
		columnNames.add("�����绰");//tel2
		columnNames.add("��������");//mail
		columnNames.add("ע��ʱ��");//zctime
		columnNames.add("ע����");//bz
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
