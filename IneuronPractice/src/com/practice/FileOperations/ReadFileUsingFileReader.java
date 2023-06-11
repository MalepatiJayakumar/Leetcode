package com.practice.FileOperations;

import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		int i = fr.read();
		while(i != -1) {
			System.out.println((char)i);
			i = fr.read();
		}
		fr.close();
	}
}