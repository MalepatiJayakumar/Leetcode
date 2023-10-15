package com.practice.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"com.practice"})
@Import(value = { PersistenceConfig.class })
public class AppConfig {
	
}