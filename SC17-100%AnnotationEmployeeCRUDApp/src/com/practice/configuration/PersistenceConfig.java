package com.practice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = { "com/practice/properties/application.properties" })
public class PersistenceConfig {

	/**
	 * Reads all the property variables from the application
	 */
	@Autowired
	private Environment env;

	@Bean(value = "dataSource")
	public HikariDataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		System.out.println("Implementation class of Environment interface :: " + env.getClass().getName());
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setMinimumIdle(Integer.parseInt(env.getProperty("jdbc.minimumIdle")));
		dataSource.setMaximumPoolSize(Integer.parseInt(env.getProperty("jdbc.maximumPoolSize")));
		return dataSource;
	}
}