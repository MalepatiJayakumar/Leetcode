package com.practice.FileOperations;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/*Using bufferedWriter so that we can overcome nextLine issue (\n won't work in some systems)*/
public class BufferedWriterTest {
	public static void main(String[] args) throws IOException{
		/* Reading the File */
		File file = new File("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
		/*Creating an FileWriter Object so that we can write into that object , true to append data into the same file without overriding */
		FileWriter fw = new FileWriter(file,true);
		/* creating an buffered writer object to use functionalities of BW */
		BufferedWriter bw = new BufferedWriter(fw);
		/* Enters into next line , we don't need to user /n */
		bw.newLine();
		bw.write("The End");
		/* BufferedReader internally using file reader , so it will close both with these line*/
		bw.close();
	}
}