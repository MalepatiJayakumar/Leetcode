package com.practice.FileOperations;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/* Create new File with two files data */
public class CopyFileData {
	
	public static void main(String[] args) throws IOException {
		
		File newFile = new File("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\finalFile.txt");
		PrintWriter pw = new PrintWriter(newFile);
//		
//		FileReader fr =new FileReader("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String line = br.readLine();
//		while(line != null ) {
//			pw.println(line);
//			line = br.readLine();
//		}
//		
//		fr = new FileReader("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\test.txt");
//		br = new BufferedReader(fr);
//		line = br.readLine();
//		while(line != null ) {
//			pw.println(line);
//			line = br.readLine();
//		}
		FileHelper.readAndWriteData("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\abc.txt",pw);
		FileHelper.readAndWriteData("C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\test.txt",pw);
		pw.close();
	}
}