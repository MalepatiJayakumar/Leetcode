package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Jdbc28HikariCPTest {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String configFile = "db.properties";
		try {
			HikariConfig config = new HikariConfig(configFile);
			try(HikariDataSource dataSource = new HikariDataSource(config)){
				connection = dataSource.getConnection();
				if (connection != null) {
					String query = "SELECT * FROM employee WHERE is_deleted = 0";
					pstmt = connection.prepareStatement(query);
					resultSet = pstmt.executeQuery();
					if (resultSet != null) {
						System.out.println("Emp_ID\tEMP_NAME\tEMP_AGE\tEMP_CITY\tEMP_SALARY");
						while (resultSet.next()) {
							System.out.println(resultSet.getLong(1) + "\t" + resultSet.getString(2) + "\t\t"
									+ resultSet.getInt(3) + "\t" + resultSet.getString(4) + "\t\t" + resultSet.getDouble(5));
						}
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing the resource :: " + e);
			}
		}
	}
}

/* Output
=========
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
Emp_ID	EMP_NAME	EMP_AGE	EMP_CITY	EMP_SALARY
1		jai				21		HYD			6000.0
2		dhanush			19		CTR			5500.0
3		hari			37		BLR			6000.0
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown initiated...
[main] INFO com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Shutdown completed.
Connections has been closed successfully.
*/