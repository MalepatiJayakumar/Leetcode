package com.practice.jdbc.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	public static Connection getConnection() throws SQLException, IOException {
		/* Take url , userName & password from application.properties file */
		FileInputStream fis = new FileInputStream("C:\\Users\\malep\\git\\repository\\IneuronPractice\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		return DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("userName"),properties.getProperty("password"));
	}
	
	public static void cleanUp(Connection connection , Statement statement , ResultSet resultSet) throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(statement != null) {
			statement.close(); 
		}
		if(resultSet != null) {
			resultSet.close(); 
		}
		System.out.println("Connections has been closed successfully.");
	}
}
