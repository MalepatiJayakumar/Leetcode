package com.inf.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			
		}
	}
	
	@SuppressWarnings("resource")
	public static Connection getConnection() throws IOException, SQLException {
		HikariDataSource dataSource = null;
		try {
			HikariConfig config = new HikariConfig("C:\\Users\\malep\\git\\repository\\JDBCCRUDServletAPP\\application.properties");
			dataSource = new HikariDataSource(config);
			return dataSource.getConnection();
//			FileInputStream fis = new FileInputStream("C:\\Users\\malep\\eclipse-workspace\\JDBCCRUDServletAPP\\application.properties");
//			Properties properties = new Properties();
//			properties.load(fis);
//			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
//			dataSource.setURL(properties.getProperty("url"));
//			dataSource.setUser(properties.getProperty("userName"));
//			dataSource.setPassword(properties.getProperty("password"));
//			return dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}
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
	}
}
