package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

public class Jdbc22DeleteFromResultSet {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				String query = "select * from employee where is_deleted = 0";
				pstmt = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				resultSet = pstmt.executeQuery();
				if (resultSet != null) {
					System.out.println("Data before deleting");
					System.out.println("id\tname\tage\taddress\tsalary");
					while (resultSet.next()) {
						System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
					}
					System.out.println();
					resultSet.last();
					resultSet.deleteRow();
					resultSet.beforeFirst();
					System.out.println("Data post deleting the last Row");
					System.out.println("id\tname\tage\taddress\tsalary");
					while (resultSet.next()) {
						System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getLong(5));
					}
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occurred :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occured while closing the resource");
			}
		}
	}
}