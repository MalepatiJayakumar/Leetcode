package com.practice.jdbc.session1;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc4DynamicValueInsertion1 {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		String url = "jdbc:mysql://localhost:3306/localhost";
		String userName = "root";
		String password = "Reddy@3816";
		connection = DriverManager.getConnection(url, userName, password);

		Statement statement = connection.createStatement();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter roll number :: ");
		Long rollNumber = scan.nextLong();

		System.out.println("Enter first name :: ");
		String firstName = scan.next();

		System.out.println("Enter middle name :: ");
		String middleName = scan.next();

		System.out.println("Enter last name :: ");
		String lastName = scan.next();

		System.out.println("Enter age :: ");
		Long age = scan.nextLong();

		System.out.println("Enter city :: ");
		String city = scan.next();

		String query = String.format(
				"INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES(%d,'%s','%s','%s',%d,'%s')",
				rollNumber, firstName, middleName, lastName, age, city);
		System.out.println("query to be executed :: " + query);

		int rowsAffected = statement.executeUpdate(query);
		System.out.println(rowsAffected + " rows Affected");
		
		
		scan.close();
		statement.close();
		connection.close();
	}
}