package com.practice.jdbc.session1;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;

/**
 * @author JaiKumar 
 * 
 * Get all the values from DB & print using jbdc Util class,
 *         remove redunant code from main method
 */
public class Jdbc5GetValues {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtil.getConnection();

			if (connection != null) {
				statement = connection.createStatement();
			}
			if (statement != null) {
				String query = "SELECT roll_number,first_name,middle_name,last_name,age,city FROM student";
				resultSet = statement.executeQuery(query);
				readResultSet(resultSet);
			}
		}catch (IOException e) {
			System.out.println("Inside main in jdbc5GetValues >> exception occured " + e);
		} catch (SQLException e) {
			System.out.println("Inside main in jdbc5GetValues >> exception occured " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, statement, resultSet);
			} catch (Exception e) {
				System.out.println("Inside main in jdbc5GetValues >> exception occured while closing connections " + e);
			}
		}
	}

	public static void readResultSet(ResultSet resultSet) throws SQLException {
		System.out.println("Id\tfName\tmName\tlName\tAge\tCity");
		while (resultSet.next()) {
			System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
					+ "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5) + "\t" + resultSet.getString(6));
		}
	}
}
