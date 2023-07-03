package com.practice.jdbc.session1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class Jdbc32WebRowSet {
	
	public static void main(String[] args) throws SQLException, IOException {
		RowSetFactory rsf = RowSetProvider.newFactory();
		WebRowSet wrs = rsf.createWebRowSet();
		wrs.setUrl("jdbc:mysql:///localhost");
		wrs.setUsername("root");
		wrs.setPassword("Reddy@3816");
		
		wrs.setCommand("SELECT * FROM employee WHERE is_deleted = 0");
		wrs.execute();
		
		//Creates an XML files with employee data 
		FileWriter fw = new FileWriter("emp.xml");
		wrs.writeXml(fw);
		System.out.println("Employee data transfer has been successfully completed...");
		fw.close();
	}
	
}
