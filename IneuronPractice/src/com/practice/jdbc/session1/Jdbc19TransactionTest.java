package com.practice.jdbc.session1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author JaiKumar
 *
 *Application to provide an hike for employees , calculating and saving hikes in same transaction for all the employees single transaction.
 */
public class Jdbc19TransactionTest {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		Scanner scan = new Scanner(System.in);
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				stmt = connection.createStatement();

				/* Data in DB before performing any operation */
				System.out.println("Salaries before hike ");
				resultSet = stmt.executeQuery("SELECT `name`,salary FROM employee");
				System.out.println("Name\tSalary");
				List<Employee> employees = new ArrayList<>();
				while (resultSet.next()) {
					String name = resultSet.getString(1);
					Double salary = resultSet.getDouble(2);
					System.out.println(name + "\t" + salary);
					employees.add(new Employee(name, null, null, salary));
				}
				System.out.println("Do you want to give hike[Yes/No]:");
				String toContinue = scan.next();
				if ("yes".equalsIgnoreCase(toContinue)) {
					connection.setAutoCommit(false);
					for (Employee emp : employees) {
						System.out.println("Please enter percentage of hike for " + emp.getName());
						Double hike = scan.nextDouble();
						if (hike == null || hike < 0) {
							System.out.println("provided hike is not an valid , please enter for next person");
							continue;
						}
						stmt.executeUpdate("UPDATE `employee` SET salary = salary+"
								+ getTotalAmount(emp.getSalary(), hike) + " WHERE `name`='" + emp.getName() + "'");
					}
					System.out.println("Can we proceed to save hike[Yes/No]");
					String saveHike = scan.next();
					if ("yes".equalsIgnoreCase(saveHike)) {
						connection.commit();
					} else {
						connection.rollback();
					}

					System.out.println("Salaries after hike ");
					ResultSet rs = stmt.executeQuery("SELECT `name`,salary FROM employee");
					System.out.println("Name\tSalary");
					while (rs.next()) {
						String name = rs.getString(1);
						Double salary = rs.getDouble(2);
						System.out.println(name + "\t" + salary);
					}
					rs.close();
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

	public static Double getTotalAmount(Double salary, Double hike) {
		if (salary == null || hike == null) {
			return 0d;
		}
		return (salary * hike) / 100;
	}
}