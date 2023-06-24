package com.practice.jdbc.session1;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/* From JDBC4.X version onwards,there is a facility of "autoloading" */
public class Jdbc1AutoDriverLoading {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = null;

		/* Step 1 :- loading an driver */
		/*
		 * Loading and register the driver is done automatically,based on the url
		 * supplied by the user. Behind the scenes 
		 * a. check the url 
		 * b. based on the url supplied, go to classpath environmental variable 
		 * c. open the relevant jar 
		 * d. go to META-INF/services folder 
		 * e. open java.sql.Driver file 
		 * f. read the file and load the class supplied in the file
		 */

		/* Step 2 :- creating an connection */
		/*
		 * when JVM & Database is on same environment no need to provide as localhost. &
		 * if DB is working on default port then no need to provide port number as well
		 * we can provide url as below
		 */
		String url = "jdbc:mysql:///localhost";
		String userName = "root";
		String password = "Reddy@3816";
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection has been created successfully ... ");

		/*Step 3:- Create an query and get execute to get ResultSet */
		String query = "SELECT roll_number,first_name,middle_name,last_name,age,city FROM student";
		Statement statement = connection.createStatement();
		System.out.println("Statement has been created successfully ... ");
		ResultSet resultSet = statement.executeQuery(query);
		System.out.println("ResultSet has been created successfully ... ");

		/*Step 4:- process the ResultSet */
		System.out.println("Id\tfName\tmName\tlName\tAge\tCity");
		while (resultSet.next()) {
			Long rollNumber = resultSet.getLong(1);
			// Long rollNumber = resultSet.getLong("roll_number"); // we can also use column
			// name to get the value
			String firstName = resultSet.getString(2);
			String middleName = resultSet.getString(3);
			String lastName = resultSet.getString(4);
			Long age = resultSet.getLong(5);
			String city = resultSet.getString(6);
			System.out.println(
					rollNumber + "\t" + firstName + "\t" + middleName + "\t" + lastName + "\t" + age + "\t" + city);
		}
		System.out.println("Completed execution for getting data");
		resultSet.close();
		statement.close();
		connection.close();
		System.out.println("closed connections successfully...");
	}

}
