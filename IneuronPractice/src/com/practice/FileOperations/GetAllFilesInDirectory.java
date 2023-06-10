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
				/* Increment dirCount if it an directory */
				dirCount++;
			}
			else if(f.isFile()) {
				/* Increment fileCount if it is an File object */
				fileCount++;
			}
			/* Printing file or directory names */
			System.out.println(name);
		}
		/* printing count of files & directories count seperately */
		System.out.println(fileCount+" files & "+dirCount+" directories present in Desktop");
	}
}