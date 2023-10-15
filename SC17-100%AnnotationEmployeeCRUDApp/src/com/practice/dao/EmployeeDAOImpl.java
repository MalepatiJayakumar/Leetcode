package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.entity.Employee;
import com.zaxxer.hikari.HikariDataSource;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private HikariDataSource dataSource;

	static {
		System.out.println("EmployeeDAOImpl.class file has been loaded");
	}

	public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl object has been instantiated");
	}

	private String INSERT_EMPLOYEE = "INSERT INTO employee(`name`,`age`,`address`,`salary`,`is_deleted`) VALUES (?,?,?,?,?)";
	
	@Override
	public String saveEmployee(Employee emp) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_EMPLOYEE)) {
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, 17);
			pstmt.setString(3, emp.getLocation());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.setInt(5, 0);

			return pstmt.executeUpdate() > 0 ? "success" : "failed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
