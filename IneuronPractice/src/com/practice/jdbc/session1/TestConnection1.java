package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection1 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement  statement  = null;
		ResultSet  resultSet  = null;
		try {
			/* Step 1:- Load and register the Driver */
//			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully .. ");

			/*Step 2 :- Establish the Connection with database */
			String url = "jdbc:mysql://localhost:3306/localhost";
			String userName = "root";
			String password = "Reddy@3816";
			/* promoting Impl class Abstraction & loosely coupling(storing impl object in parent interface connection) */
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Implementation class of connection :: "+connection.getClass().getName());
			
			/* Step 3 :- create statement object & send the query for execution*/
			String query = "SELECT roll_number,first_name,middle_name,last_name,age,city FROM student";
			statement = connection.createStatement();
			System.out.println("Implementation class of statement :: "+statement.getClass().getName());
			resultSet = statement.executeQuery(query);
			System.out.println("Implementation class of resultSet :: "+resultSet.getClass().getName());
			
			System.out.println(resultSet);
			/* Step 4 :- processing the resultSet */
			System.out.println("Id\tfName\tmName\tlName\tAge\tCity");
			while(resultSet.next()) {
				Long rollNumber   = resultSet.getLong(1);
				//Long rollNumber   = resultSet.getLong("roll_number"); // we can also use column name to get the value
				String firstName  = resultSet.getString(2);
				String middleName = resultSet.getString(3);
				String lastName   = resultSet.getString(4);
				Long age          = resultSet.getLong(5);
				String city       = resultSet.getString(6);
				System.out.println(rollNumber+"\t"+firstName+"\t"+middleName+"\t"+lastName+"\t"+age+"\t"+city);
			}
		}
//		catch(ClassNotFoundException e) {
//			System.out.println("class Not found :: "+e);
//		}
		catch(SQLException e) {
			System.out.println("Sql exception  :: "+e);
		}catch(Exception e) {
			System.out.println("Exception :: "+e);
		}
		finally{
			if(connection != null) {
				try {
					resultSet.close();
					statement.close();
					connection.close();
					System.out.println("Connection has been closed");
				}catch(Exception e) {
					System.out.println("Exception occured while closing connection :: "+e);
				}
			}
		}

	}
}