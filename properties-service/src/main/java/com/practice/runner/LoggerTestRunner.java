package com.practice.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class LoggerTestRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(LoggerTestRunner.class);

	@Autowired
	Environment environment;

	@Override
	public void run(org.springframework.boot.ApplicationArguments args) throws Exception {
		logger.info("Logger Test: INFO level message");
		logger.debug("Logger Test: DEBUG level message");
		logger.warn("Logger Test: WARN level message");
		logger.error("Logger Test: ERROR level message");

		System.out.println("custom.property1 : " + environment.getProperty("custom.property1"));

		System.out.println("Logger test completed. Check the logs to see the output.");
	}
}