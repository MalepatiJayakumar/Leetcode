package com.practice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
	
	/**
	 * @UserConfiguration constructor 
	 */
	public UserConfiguration() {
		System.out.println("Inside UserConfiguration contructor");
	}
	
	/**
	 * 
	 * Here user is creating an bean , so spring won't manage these bean. To inform
	 * spring to manage these bean we use @Bean annotation
	 */
	@Bean 
	public EncPassword getInstance() {
		EncPassword config = new EncPassword();
		return config;
	}
	
}
