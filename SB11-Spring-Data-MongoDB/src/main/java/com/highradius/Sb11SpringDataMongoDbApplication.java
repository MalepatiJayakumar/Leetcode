package com.highradius;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb11SpringDataMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication();
		application.setBannerMode(Mode.CONSOLE);
		application.run(Sb11SpringDataMongoDbApplication.class, args);
	}
}