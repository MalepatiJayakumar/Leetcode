package com.practice.jdbc.session1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author JaiKumar
 * 
 *         Maximum insertions allowed is 2 at a time , So if user is trying to
 *         save more than 2 we will rollback queries to SavePoint and we will
 *         save 2 record.
 *
 */
public class Jdbc20SavePointTest {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		Scanner scan = new Scanner(System.in);
		Savepoint sp = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();
				if (stmt != null) {
					System.out.println("How many entries do you wanna insert[max 5 can be saved]");
					Integer count = scan.nextInt();
					connection.setAutoCommit(false);
					for (int i = 1; i <= count; i++) {
						System.out.println("Enter name :: ");
						String name = scan.next();
						System.out.println("Enter age :: ");
						Integer age = scan.nextInt();
						System.out.println("Enter location :: ");
						String location = scan.next();
						System.out.println("Enter salary :: ");
						Double salary = scan.nextDouble();
						stmt.executeUpdate("INSERT INTO employee(`name`,age,address,salary) VALUES('" + name + "',"
								+ age + ",'" + location + "'," + salary + ")");
						if (i == 2) {
							sp = connection.setSavepoint();
						}
					}
					if (sp != null && count >= 2) {
						connection.rollback(sp);
					} else {
						connection.releaseSavepoint(sp);
					}
					connection.commit();
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Exception occured while performing JDBC operations :: " + e);
		} finally {
			try {
				JdbcUtil.cleanUp(connection, stmt, resultSet);
				scan.close();
			} catch (SQLException e) {
				System.out.println("Exception occurred while closing resource.. " + e);
			}
		}
	}
}