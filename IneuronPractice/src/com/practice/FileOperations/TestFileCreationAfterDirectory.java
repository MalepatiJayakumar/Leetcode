package com.practice.FileOperations;

import java.io.File;

public class TestFileCreationAfterDirectory {
	
	public static void main(String[] args) throws Exception {
		String directoryName = "C:\\Users\\malep\\files\\IPLTeams";
		String fileName = "abc.txt";
		
		File f1 = new File(directoryName);
		f1.mkdir();
		
		System.out.println("is F1 pointing to an directory :: "+f1.isDirectory());
		
		File f2 = new File(f1,fileName);
		f2.createNewFile();
		
		System.out.println("is F2 pointing to an File :: "+f2.isFile());
	}
}