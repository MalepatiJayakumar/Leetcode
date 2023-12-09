package com.highradius.runners;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * In CommandLineRunner implementation we get everything as String objects,
 * whereas using ApplicationRunner we get values in key value pair if we provide
 * in --key=value format
 * 
 * @author malep
 */
@Component
public class ExportPdfRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Args :: " + Arrays.asList(args));
	}
}