package com.practice.jdbc.session1;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc30InsertUsingRowSet {
	public static void main(String[] args) throws SQLException {
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();

		// Setting url,userName & password to connect to db
		jrs.setUrl("jdbc:mysql:///localhost");
		jrs.setUsername("root");
		jrs.setPassword("Reddy@3816");

		// Setting the command for execution
		jrs.setCommand("select * from employee");
		jrs.execute();
		//Emp_ID\tEMP_NAME\tEMP_AGE\tEMP_CITY\tEMP_SALARY
		Scanner scan = new Scanner(System.in);
		jrs.moveToInsertRow();
		while(true) {
			
			System.out.println("Enter name of employee");
			String name = scan.next();
			System.out.println("Enter age of employee");
			Integer age = scan.nextInt();
			System.out.println("Enter city of employee");
			String city = scan.next();
			System.out.println("Enter salary of employee");
			Double salary = scan.nextDouble();
			
			jrs.updateString(2,name);
			jrs.updateInt(3,age);
			jrs.updateString(4,city);
			jrs.updateDouble(5,salary);
			
			jrs.insertRow();
			
			System.out.print("Do you want to insert one more record[yes/no] :: ");
			String option = scan.next();
			if("yes".equalsIgnoreCase(option)) {
				continue;
			}
			else {
				System.out.println("Records has been inserted successfully");
				break;
			}
		}
		
		jrs.beforeFirst();
		System.out.println("Emp_ID\tEMP_NAME\tEMP_AGE\tEMP_CITY\tEMP_SALARY");
		while (jrs.next()) {
			System.out.println(jrs.getLong(1) + "\t" + jrs.getString(2) + "\t\t"
					+ jrs.getInt(3) + "\t" + jrs.getString(4) + "\t\t" + jrs.getDouble(5));
		}
		jrs.close();
		scan.close();
	}
}
