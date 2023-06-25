package com.practice.jdbc.session1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/* 
 * 1. Develop a console based application in the following manner
a. Create a menu for the user to perform CRUD operation as shown below

1. Press 1 for Insert operation
2. Press 2 for select operation
3. Press 3 for Update operation
4. Press 4 for Delete operation
5. Press 5 for exit
Note: anything above 5 tell invalid operation

b. If user presses 1
a. Take inputs from the user to accept the data like
1. sid(pk) 2. sname 3. sage 4. saddress
b. perform insertion operation
c. display suitable message as
	a. record inserted succesfully
	b. record insertion failed

c. If user presses 2
a. Take inputs from the user to accept the data like
	1. sid(pk)
b. perform select operation
c. display suitable message as
	a. display the details in table format.
	b. record not available for the given id.
	
d. b. If user presses 3
a. Take inputs from the user to accept the data like
	1. sid(pk)
b. for the entered id display the details first
	sid : XXXXX (no change becoz it is pk)
	sname : XXXXX enter new sname :: XXXXX
	sage : XXXXX enter new sage :: YYYYY
	saddr : XXXXX enter new saddr :: YYYYY
c. display suitable message as
	a. record updated succesfully
	b. record updation failed
	
	
e. If user presses 4
a. Take inputs from the user to accept the data like
	1. sid(pk)
b. perform delete operation
c. display suitable message as
	a. record deleted succesfully.
	b. record not available for the given id.
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jdbc7ConsoleApplication {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, IOException {
		System.out.println("Press 1 for Insert operation");
		System.out.println("Press 2 for select operation");
		System.out.println("Press 3 for Update operation");
		System.out.println("Press 4 for Delete operation");
		System.out.println("Press 5 for exit");
		System.out.println("Note: anything above 5 tell invalid operation");

		int menu = scan.nextInt();
		System.out.println(menu);
		if (menu == 5) {
			System.out.println("system exited");
			System.exit(1);
		}
		if (menu > 5) {
			System.out.println("Invalid operation");
			System.exit(1);
		}
		Connection connection = null;
		PreparedStatement pstmt = null;
		connection = JdbcUtil.getConnection();
		if (menu == 1) {
			pstmt = connection.prepareStatement(
					"INSERT INTO student(roll_number,first_name,middle_name,last_name,age,city) VALUES(?,?,?,?,?,?)");
			insertData(pstmt);
		}
		if (menu == 2) {
			String query = "SELECT roll_number,first_name,middle_name,last_name,age,city FROM student where is_deleted = 0";
			pstmt = connection.prepareStatement(query);
			readData(pstmt);
		}
		if (menu == 3) {
			pstmt = connection.prepareStatement(
					"SELECT roll_number,first_name,middle_name,last_name,age,city FROM student where roll_number in (1061) where is_deleted = 0");
			List<Student> students = getData(pstmt);
			pstmt = connection.prepareStatement("UPDATE `student` SET city = ? WHERE roll_number = ?");
			updateData(pstmt, students);
		}
		if (menu == 4) {
			pstmt = connection.prepareStatement("UPDATE student SET is_deleted = 1 WHERE roll_number = ?");
			softDelete(pstmt);
		}

		scan.close();

		JdbcUtil.cleanUp(connection, pstmt, null);
	}

	public static void insertData(PreparedStatement pstmt) throws SQLException {
		System.out.println("Enter roll number :: ");
		Long rollNumber = scan.nextLong();

		System.out.println("Enter first name :: ");
		String firstName = scan.next();

		System.out.println("Enter middle name :: ");
		String middleName = scan.next();

		System.out.println("Enter last name :: ");
		String lastName = scan.next();

		System.out.println("Enter age :: ");
		Long age = scan.nextLong();

		System.out.println("Enter city :: ");
		String city = scan.next();

		pstmt.setLong(1, rollNumber);
		pstmt.setString(2, firstName);
		pstmt.setString(3, middleName);
		pstmt.setString(4, lastName);
		pstmt.setLong(5, age);
		pstmt.setString(6, city);

		int rowsAffected = pstmt.executeUpdate();
		System.out.println(rowsAffected + " rows affected");
	}

	public static void readData(PreparedStatement pstmt) throws SQLException {
		ResultSet resultSet = pstmt.executeQuery();
		System.out.println("Id\tfName\tmName\tlName\tAge\tCity");
		while (resultSet.next()) {
			Long rollNumber = resultSet.getLong(1);
			String firstName = resultSet.getString(2);
			String middleName = resultSet.getString(3);
			String lastName = resultSet.getString(4);
			Long age = resultSet.getLong(5);
			String city = resultSet.getString(6);
			System.out.println(
					rollNumber + "\t" + firstName + "\t" + middleName + "\t" + lastName + "\t" + age + "\t" + city);
		}
		resultSet.close();
	}

	public static List<Student> getData(PreparedStatement pstmt) throws SQLException {
		ResultSet resultSet = pstmt.executeQuery();
		List<Student> students = new ArrayList<>();
		while (resultSet.next()) {
			Long rollNumber = resultSet.getLong(1);
			String firstName = resultSet.getString(2);
			String middleName = resultSet.getString(3);
			String lastName = resultSet.getString(4);
			Long age = resultSet.getLong(5);
			String city = resultSet.getString(6);
			Student std = new Student(rollNumber, firstName, middleName, lastName, age, city);
			students.add(std);
		}
		resultSet.close();
		System.out.println("Size of student got :: " + students.size());
		return students;
	}

	public static void updateData(PreparedStatement pstmt, List<Student> student) throws SQLException {

		Student std = student.get(0);
		System.out.println("Roll number : " + std.getRollNumber() + " no change because id is fixed");

		System.out.println("city : " + std.getCity() + " enter new city :: ");
		String city = scan.next();
		pstmt.setString(1, city);
		pstmt.setLong(2, 1061L);
		int noOfRowsAffected = pstmt.executeUpdate();
		System.out.println(noOfRowsAffected + " number of rows affected");
	}

	public static void softDelete(PreparedStatement pstmt) throws SQLException {
		System.out.println("please enter student id for deleting");
		Long id = scan.nextLong();
		pstmt.setLong(1, id);
		int noOfRowsAffected = pstmt.executeUpdate();
		System.out.println(noOfRowsAffected + " number of rows affected");
	}
}