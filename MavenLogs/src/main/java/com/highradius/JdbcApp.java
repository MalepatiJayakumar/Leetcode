package com.highradius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class JdbcApp {
	private static Logger logger = Logger.getLogger(JdbcApp.class);
	static {
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		logger.addAppender(appender);
		logger.setLevel(Level.ALL);
	}

	public static void main(String[] args) {
		logger.debug("start of main method...");
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.debug("Driver class loaded succesfully...");
			String url = "jdbc:mysql:///localhost";
			String user = "root";
			String password = "Reddy@3816";
			connection = DriverManager.getConnection(url, user, password);
			logger.info("connection established");
			statement = connection.createStatement();
			logger.debug("statement object created...");
			String sqlSelectQuery = "SELECT * FROM employee WHERE address='HYD'";
			resultSet = statement.executeQuery(sqlSelectQuery);
			logger.info("Query is executed and ResultSet object is created");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("pk_id") + "\t" +

						resultSet.getString("name") + "\t"

						+ resultSet.getInt("age") + "\t" +

						resultSet.getString("address"));
			}
		} catch (ClassNotFoundException c) {
			logger.error("Failed to load the driver");
		} catch (SQLException se) {
			logger.error("Some db problem " + se.getMessage() + "----> " +

					se.getErrorCode());

		} catch (Exception e) {
			logger.fatal("Some unknown exception occured...");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				logger.error("Problem in closing resultSet");
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				logger.error("Problem in closing statement");
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Problem in closing connection");

			}
		}
		logger.debug("end of main method");
	}
}