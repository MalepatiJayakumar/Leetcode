package com.highradius;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class App {

	private static final String SELECT_COUNT_QUERY = "SELECT COUNT(*) FROM employee";

	static {
		System.out.println("App.class file is getting loaded");
	}
	
	private JdbcTemplate jdbcTemplate;

	public App(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int test() {
		System.out.println(jdbcTemplate);
		return jdbcTemplate.queryForObject(SELECT_COUNT_QUERY,Integer.class);
	}
}