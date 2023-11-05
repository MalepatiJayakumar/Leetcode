package com.highradius;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb06SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb06SpringJdbcTemplateApplication.class, args);
		PropertyConfigurator.configure("src\\main\\resources\\logs.properties");
	}
}