package com.practice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* Using BufferedReader we can read the whole line at one go */
public class BufferedReaderTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		BufferedReader br = new BufferedReader(fr);
		/* Read the whole the at once */
		String line = br.readLine();
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		br.close();
	}
}