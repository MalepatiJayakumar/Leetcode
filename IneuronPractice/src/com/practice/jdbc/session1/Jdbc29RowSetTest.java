package com.practice.jdbc.session1;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Jdbc29RowSetTest {
	public static void main(String[] args) throws SQLException {
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet(); //Same as ResultSet but it is scrollable and updatable
		
		//Setting url,userName & password to connect to db
		jrs.setUrl("jdbc:mysql:///localhost");
		jrs.setUsername("root");
		jrs.setPassword("Reddy@3816");
		
		//Setting the command for execution
		jrs.setCommand("select * from employee");
		jrs.execute();
		
		//Retrieving in Forward direction
		System.out.println("Retrieving in Forward direction");
		System.out.println("Emp_ID\tEMP_NAME\tEMP_AGE\tEMP_CITY\tEMP_SALARY");
		while (jrs.next()) {
			System.out.println(jrs.getLong(1) + "\t" + jrs.getString(2) + "\t\t"
					+ jrs.getInt(3) + "\t" + jrs.getString(4) + "\t\t" + jrs.getDouble(5));
		}
		
		System.out.println("Retrieving in Backward direction");
		System.out.println("Emp_ID\tEMP_NAME\tEMP_AGE\tEMP_CITY\tEMP_SALARY");
		while (jrs.previous()) {
			System.out.println(jrs.getLong(1) + "\t" + jrs.getString(2) + "\t\t"
					+ jrs.getInt(3) + "\t" + jrs.getString(4) + "\t\t" + jrs.getDouble(5));
		}
	}
}


/* Output 
=========
Retrieving in Forward direction
Emp_ID	EMP_NAME	EMP_AGE	EMP_CITY	EMP_SALARY
1	jai		21	HYD		6000.0
2	dhanush		19	CTR		5500.0
3	hari		37	BLR		6000.0
Retrieving in Backward direction
Emp_ID	EMP_NAME	EMP_AGE	EMP_CITY	EMP_SALARY
3	hari		37	BLR		6000.0
2	dhanush		19	CTR		5500.0
1	jai		21	HYD		6000.0
*/
