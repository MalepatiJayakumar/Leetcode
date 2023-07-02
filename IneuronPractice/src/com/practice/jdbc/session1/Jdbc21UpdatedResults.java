package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

public class Jdbc21UpdatedResults {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			String query = "select * from employee where is_deleted = 0";
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				// TO make any changes in result set we need to have resultSet of Type scroll sensitive
				pstmt = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				resultSet = pstmt.executeQuery();
				System.out.println("Current data in DB");
				System.out.println("id\tname\tage\taddress\tsalary");
				while (resultSet.next()) {
					System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
				}
				System.out.println("Program paused , please update something in DB");
				System.in.read();
				resultSet.beforeFirst(); // Need to move pointer to first row of resultSet
				System.out.println("id\tname\tage\taddress\tsalary");
				while (resultSet.next()) {
					// resultSet.refreshRow() --> refreshes the row with db data
					resultSet.refreshRow();
					System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
				}
			}
		} catch (SQLException | IOException e) {

		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resources :: " + e);
			}
		}
	}
}