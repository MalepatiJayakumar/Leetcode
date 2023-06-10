package com.practice.FileOperations;

import java.io.File;

/*jav.io API has been build on standards of Linux / Unix os*/
/*In Linux / Unix OS there is no any difference between File & Directory same for JVM as well*/
public class TestDirectoryCreation {
	public static void main(String[] args) {
		String directoryName = "C:\\Users\\malep\\files\\IPLTeams";
		File f = new File(directoryName);
		System.out.println(f.exists()); /* first run it will be false */
		f.mkdir(); /* creates new directory, if directory is not present with same name */
		System.out.println(f.exists()); /* true */
	}
}