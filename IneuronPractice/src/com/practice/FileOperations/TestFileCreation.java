package com.practice.FileOperations;

import java.io.File;

public class TestFileCreation {

	public static void main(String[] args) {

		String fileName = "C:\\Users\\malep\\files\\test.txt";
		File file = new File(fileName);
		System.out.println(file.exists());
	}

}
