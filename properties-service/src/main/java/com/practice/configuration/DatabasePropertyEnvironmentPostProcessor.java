package com.practice.configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

public class DatabasePropertyEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		System.out.println("DatabasePropertyEnvironmentPostProcessor.postProcessEnvironment()");
		Map<String, Object> propertyMap = new HashMap<>();

		try (Connection connection = getDataSource(environment).getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT property_key, property_value FROM app_properties")) {
			
			while (resultSet.next()) {
				String key = resultSet.getString("property_key");
				String value = resultSet.getString("property_value");
				propertyMap.put(key, value);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to load properties from the database", e);
		}
		MapPropertySource propertySource = new MapPropertySource("externalProperties", propertyMap);
		environment.getPropertySources().addFirst(propertySource);
	}

	private DataSource getDataSource(ConfigurableEnvironment environment) {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}
}
