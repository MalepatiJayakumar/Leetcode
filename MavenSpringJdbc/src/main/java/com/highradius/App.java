package com.highradius;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class App {

	private static final String SELECT_COUNT_QUERY = "SELECT COUNT(*) FROM employee";
	private static final String SELECT_NAME_BY_ID = "select `name` from employee where pk_id=?";
	private static final String SELECT_EMPLOYEE_FIELDS_BY_ID = "SELECT `name`,`age`,`address`,`salary` FROM employee WHERE pk_id=?";
	private static final String SELECT_EMPLOYEES_BY_LOCATION="SELECT `name`,`age`,`address`,`salary` FROM employee WHERE address IN (?,?)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO employee(`name`,`age`,`address`,`salary`,`is_deleted`) VALUES (?,?,?,?,0)";
	private static final String UPDATE_EMPLOYEE_SALARY = "UPDATE employee SET salary=salary+? WHERE `address`=?";
	
	
	static {
		System.out.println("App.class file is getting loaded");
	}
	
	private JdbcTemplate jdbcTemplate;

	public App(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getEmployeeCount() {
		System.out.println(jdbcTemplate);
		return jdbcTemplate.queryForObject(SELECT_COUNT_QUERY,Integer.class);
	}
	
	public String getEmployeeNameById(Integer eId) {
		return jdbcTemplate.queryForObject(SELECT_NAME_BY_ID,String.class,eId);
	}
	
	public Map<String,Object> getEmployeeById(Integer eId){
		return jdbcTemplate.queryForMap(SELECT_EMPLOYEE_FIELDS_BY_ID,eId);
	}
	
	public List<Map<String,Object>> getEmployeesByLocation(String loc1,String loc2){
		return jdbcTemplate.queryForList(SELECT_EMPLOYEES_BY_LOCATION,loc1,loc2);
	}

	public Integer insertEmployee(String name, Integer age, String address, Double salary) {
		return jdbcTemplate.update(INSERT_EMPLOYEE, name, age, address, salary);
	}
	
	public Integer updateSalary(String location , Double bonus) {
		return jdbcTemplate.update(UPDATE_EMPLOYEE_SALARY,bonus,location);
	}
	
}