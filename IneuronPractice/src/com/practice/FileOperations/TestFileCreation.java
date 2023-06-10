package com.practice.FileOperations;

import java.io.File;

public class TestFileCreation {
	public static void main(String[] args) {
		try {
			String fileName = "C:\\Users\\malep\\files\\test.txt";
			File file = new File(fileName);
			System.out.println(file.exists());
			file.createNewFile(); // create New file , if files doesn't exists
			System.out.println(file.exists());
		} catch (Exception e) {
			System.out.println("Exception occurred while doing file operations");
		}
	}
}