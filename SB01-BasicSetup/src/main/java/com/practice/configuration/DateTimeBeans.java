package com.practice.configuration;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateTimeBeans {

	@Bean(value = "localDateTime")
	public LocalDateTime getLocalDateTime() {
		System.out.println("DateTimeBeans.getLocalDateTime() >> creating localDateTime Beans");
		return LocalDateTime.now();
	}
}