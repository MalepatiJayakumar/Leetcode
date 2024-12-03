package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ValidatorsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ValidatorsApplication.class, args);
		context.close();
	}

}
