package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {


	static {
		System.out.println("EmployeeDAOImpl.class file has been loaded");
	}
	
	public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl object has been instantiated");
	}
	
	@Autowired
	private DataSource dataSource;
	
	private static final String EMP_INSERT_QUERY = "INSERT INTO employee(`name`,`age`,`address`,`salary`,`is_deleted`) VALUES (?,?,?,?,?)";

	@Override
	public String saveEmployee(EmployeeDTO emp) {
		System.out.println("EmployeeDAOImpl.saveEmployee() >> dataSource impl class :: " + dataSource.getClass().getName());
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(EMP_INSERT_QUERY)) {
			pstmt.setString(1, emp.getName());
			pstmt.setInt(2, 25);
			pstmt.setString(3, emp.getLocation());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.setInt(5, 0);
			return pstmt.executeUpdate() > 0 ? "success" : "failed";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}

}
