package com.hrc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.hrc.dto.EmployeeDTO;

@Repository
@Profile("dev")
public class EmployeeDAOImpl implements IEmployeeDAO {

	static {
		System.out.println("EmployeeDAOImpl.class file is being loaded");
	}

	public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl object is being instantiated");
	}

	@Autowired
	private DataSource dataSource;
	
	private static final String FETCH_EMPLOYEE_FROM_ADDRESS="SELECT * FROM employee WHERE address=?";

	@Override
	public List<EmployeeDTO> getEmployeesFromAddress(String address) {
		List<EmployeeDTO> employees = new ArrayList<>();
		try (Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(FETCH_EMPLOYEE_FROM_ADDRESS)) {
			pstmt.setString(1, address);
			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				// String name, Integer age, String address, Double salary
				EmployeeDTO emp = new EmployeeDTO(resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getDouble(5));
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}