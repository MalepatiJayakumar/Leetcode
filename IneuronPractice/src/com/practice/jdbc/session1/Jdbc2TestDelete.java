package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc2TestDelete {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;

		/* Step 1 :- Loading an Driver */
		// Driver will be auto loaded

		/* Step 2 :- Create an connection */
		String url = "jdbc:mysql:///localhost";
		String userName = "root";
		String password = "Reddy@3816";
		connection = DriverManager.getConnection(url, userName, password);
		Statement statement = connection.createStatement();

		/* Step 3 :- execute the query */
		String query = "UPDATE `student` SET is_deleted = 1 WHERE roll_number = 1061";
		int rowsAffected = statement.executeUpdate(query);
		System.out.println(rowsAffected + " row(s) affected");

		String insertQuery = "INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES(1066,'Hari',NULL,'Krishnaiah',36,'BLR');";
		int rowsAffectedInsertion = statement.executeUpdate(insertQuery);
		System.out.println(rowsAffectedInsertion + " row(s) affected for insertion");

		statement.close();
		connection.close();
	}
}
