package com.practice.jdbc.session1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Jdbc3DynamicValueInsertion {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		
		String url      = "jdbc:mysql://localhost:3306/localhost";
		String userName = "root";
		String password = "Reddy@3816";
		connection = DriverManager.getConnection(url,userName,password);
		Statement statement = connection.createStatement();
		//INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES(1066,'Hari',NULL,'Krishnaiah',36,'BLR');
		
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
		
		String query = "INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES("+rollNumber+",'"+firstName+"','"+middleName+"','"+lastName+"',"+age+",'"+city+"')";
		System.out.println("query to be executed :: "+query);
		
		int rowsAffected = statement.executeUpdate(query);
		System.out.println(rowsAffected+" rows affected");
		
		scan.close();
		statement.close();
		connection.close();
	}
}