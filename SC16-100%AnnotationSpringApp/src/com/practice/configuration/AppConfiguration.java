package com.practice.configuration;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration helps to inform container configurations of the App.
 * 
 * @author malep
 */

@Configuration
@ComponentScan(basePackages = { "com.practice" })
public class AppConfiguration {
	/**
	 * Bean will be create with the method name , @Bean will be used to create beans
	 * for the inbuild classes. As we can't use @Compoenent to create spring bean
	 * for inbuilt classes.
	 */
	@Bean("date")
	public LocalDateTime generateDateTime() {
		System.out.println("AppConfiguration.generateDateTime()");
		return LocalDateTime.now();
	}

}