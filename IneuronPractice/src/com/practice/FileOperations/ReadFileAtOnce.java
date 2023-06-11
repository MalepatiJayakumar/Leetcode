package com.practice.FileOperations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
Reading the whole file at once & storing data in character Array, so that we don't need to read for every character. Performance will be improved
*/
public class ReadFileAtOnce {	
	public static void main(String[] args) throws IOException{
		File file = new File("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		FileReader fr = new FileReader(file);
		/*creating character array to read data by getting the file size */
		char[] ch = new char[(int)file.length()];
		fr.read(ch);
		for(char data : ch) {
			System.out.println(data);
		}
		fr.close();
	}
}