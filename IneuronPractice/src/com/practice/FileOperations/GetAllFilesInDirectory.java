package com.practice.FileOperations;

import java.io.File;

/*Get all the files from provided folder or directory , & differentiate between file & Directory*/
public class GetAllFilesInDirectory {
	public static void main(String[] args) {
		String location = "C:\\Users\\malep\\OneDrive\\Desktop";
		File file = new File(location);
		String[] names = file.list();
		Integer dirCount = 0;
		Integer fileCount = 0;
		for (String name : names) {
			File f = new File(file,name);
			if(f.isDirectory()) {
				dirCount++;
			}
			else if(f.isFile()) {
				fileCount++;
			}
			System.out.println(name);
		}
		System.out.println(fileCount+" files & "+dirCount+" directories present in Desktop");
	}
}