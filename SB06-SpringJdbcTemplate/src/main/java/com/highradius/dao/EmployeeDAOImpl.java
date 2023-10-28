package com.highradius.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrc.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String SELECT_ALL_EMPLOYEES="SELECT `name`,`age`,`address`,`salary` FROM employee where is_deleted=0";

	private static final String UPDATE_EMPLOYEE = "UPDATE employee SET salary=?,`name`=?,age=?,address=? WHERE `pk_id`=?";
	
	private static final String SELECT_EMPLOYEE_FIELDS_BY_ID = "SELECT `name`,`age`,`address`,`salary` FROM employee WHERE pk_id=?";
	
	@Override
	public List<Map<String, Object>> getAllEmployees() {
		return jdbcTemplate.queryForList(SELECT_ALL_EMPLOYEES);
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getSalary(), employee.getName(), employee.getAge(),
				employee.getAddress(), employee.getId());
	}
	
	@Override
	public Map<String,Object> getEmployee(Long id) {
		return jdbcTemplate.queryForMap(SELECT_EMPLOYEE_FIELDS_BY_ID,id);
	}
}