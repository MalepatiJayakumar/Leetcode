package com.practice.jdbc.session1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\malep\\git\\repository\\IneuronPractice\\application.properties");

		Properties properties = new Properties();
		properties.load(fis);

		System.out.println("url :: " + properties.getProperty("url"));
		System.out.println("userName :: " + properties.getProperty("userName"));
		System.out.println("password :: " + properties.getProperty("password"));
	}
}