package com.practice.FileOperations;

import java.io.File;
import java.io.FileWriter;

public class WriteDataInFile {

	public static void main(String[] args) throws Exception {
		File f1 = new File("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		/* Everytime file will be overriden with updated data */
		/* FileWriter f2 = new FileWriter(f1); */
		
		/*
		 * Everytime file data will be appended to existing file data, if file doesn't
		 * exist at first go then it will create new file
		 */
		FileWriter f2 = new FileWriter(f1,true);
		f2.write("Hi all");
		f2.write("\n");
		f2.write("Good Morning");
		f2.write("\n");
		f2.write("I am Jayakumar , working in Highradius");
		f2.write("\n");

		f2.close();
	}
}