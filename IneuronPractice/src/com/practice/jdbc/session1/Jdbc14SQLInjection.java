package com.practice.jdbc.session1;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.util.Scanner;

public class Jdbc14SQLInjection {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement   = null;
		ResultSet resultSet   = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JdbcUtil.getConnection();
			if(connection != null) {
				statement = connection.createStatement();
				System.out.println("Enter first name to search");
				String firstName = scan.next();
				System.out.println("Enter last name to search");
				String lastName = scan.next();
				String query = "SELECT COUNT(*) FROM student WHERE first_name = '"+firstName+"' AND last_name = '"+lastName+"'";
				resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					Integer count = resultSet.getInt(1);
					System.out.println(count+" students found from provided details");
				}
				else {
					System.out.println("Didn't found any user with provided details");
				}
			}
		}catch(SQLException|IOException e) {
			System.out.println("Exception occured >> "+e);
		}finally {
			try {
				JdbcUtil.cleanUp(connection,statement,resultSet);
				scan.close();
			}catch(SQLException e) {
				
			}
		}
	}
}
