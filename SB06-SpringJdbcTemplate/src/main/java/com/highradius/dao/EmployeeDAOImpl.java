package com.highradius.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECT_ALL_EMPLOYEES="SELECT `name`,`age`,`address`,`salary` FROM employee";
	
	@Override
	public List<Map<String, Object>> getAllEmployees() {
		return jdbcTemplate.queryForList(SELECT_ALL_EMPLOYEES);
	}
}