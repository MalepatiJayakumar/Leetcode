package com.highradius.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("com/highradius/properties/application.properties")
@ComponentScan(value= {"com.highradius"})
public class Configuration1 {
	
	static {
		System.out.println("Configuration1.class file is getting loaded");
	}
	
	public Configuration1() {
		System.out.println("Configuration1 object is being instantited");
	}
	
	@Autowired
	private Environment env;
	
	@Bean("datasource")
	public DataSource getDataSource() {
		System.out.println("Configuration1.getDataSource()");
		HikariDataSource hikari = new HikariDataSource();
		hikari.setDriverClassName(env.getProperty("driverClass"));
		hikari.setJdbcUrl(env.getProperty("jdbcUrl"));
		hikari.setUsername(env.getProperty("user"));
		hikari.setPassword(env.getProperty("password"));
		return hikari;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
}