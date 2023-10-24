package com.hrc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class Sb05ProfilesApplication {

	@Autowired
	private Environment env;
	
	@Bean
	@Profile("dev") // If we want to use this for multiple environments then we need to use @Profile({"prod","uat"})
	public DataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		System.out.println("Getting Custom dataSource");
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		return dataSource;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Sb05ProfilesApplication.class, args);
	}
}