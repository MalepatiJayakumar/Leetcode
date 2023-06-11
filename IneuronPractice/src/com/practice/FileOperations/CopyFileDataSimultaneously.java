package com.practice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Read 1 line from first file & second line from 2nd file and so on. Read only one file if first file is already read or not data */
public class CopyFileDataSimultaneously {
	
	public static void main(String[] args) throws IOException{
		FileWriter fileWriter = new FileWriter(FileHelper.folderPath+"Copied Line By Line.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		FileReader fileReader1 = new FileReader(FileHelper.folderPath+"abc.txt");
		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		
		FileReader fileReader2 = new FileReader(FileHelper.folderPath+"test.txt");
		BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
		
		String line1 = bufferedReader1.readLine();
		String line2 = bufferedReader2.readLine();
		
		while(line1 != null || line2 != null) {
			if(line1 != null) {
				printWriter.println(line1);
				line1 = bufferedReader1.readLine();
			}
			if(line2 != null) {
				printWriter.println(line2);
				line2 = bufferedReader2.readLine();
			}
		}
		bufferedReader1.close();
		bufferedReader2.close();
		printWriter.flush();
		printWriter.close();
	}

}
