package com.practice.jdbc.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	public static Connection getConnection() throws SQLException, IOException {
		/* Take url , userName & password from application.properties file */
		FileInputStream fis = new FileInputStream("application.properties");
		Properties properties = new Properties();
		properties.load(fis);

		// For every request new connection object will be created which impacts
		// performance
//		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"),
//				properties.getProperty("password"));

		// Here certain number of connections will be predefined where connection will
		// be reused with creating and deleting
		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
		dataSource.setURL(properties.getProperty("url"));
		dataSource.setUser(properties.getProperty("userName"));
		dataSource.setPassword(properties.getProperty("password"));
		return dataSource.getConnection();
	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		System.out.println("Connections has been closed successfully.");
	}

	public static Connection getHikariCPConnection() throws SQLException, IOException {
		String configFile = "db.properties";
		HikariConfig config = new HikariConfig(configFile);
		HikariDataSource dataSource = null;
		try {
			dataSource = new HikariDataSource(config);
			return dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Exception occurred while creating an Hikari-CP connection");
		} finally {
			if (dataSource != null) {
				dataSource.close();
			}
		}
		return null;
	}
}
