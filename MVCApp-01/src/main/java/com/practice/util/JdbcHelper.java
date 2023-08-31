package com.practice.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcHelper {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {

		}
	}

	public static Connection getConnection() throws SQLException {
		HikariDataSource dataSource = null;
		try {
			HikariConfig config = new HikariConfig("C:\\Users\\malep\\git\\repository\\MVCApp-01\\application.properties");
			dataSource = new HikariDataSource(config);
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void cleanUp(Connection connection , Statement stmt , ResultSet resultSet) throws SQLException {
		if(stmt != null) {
			stmt.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
	
}
