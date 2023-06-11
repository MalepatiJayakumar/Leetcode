package com.practice.FileOperations;

import java.io.PrintWriter;

/* input.txt , delete.txt are two files which are present , now get the data from input to output , ignore data which is present in delete file */
public class WriteValuesWhichAreNotPresentInDeleteFile {
	public static void main(String[] args) {
		String sourceInput = FileHelper.folderPath+"inputFile.txt";
		String sourceDelete = FileHelper.folderPath+"deleteFile.txt";
		try(PrintWriter printWriter = new PrintWriter(FileHelper.folderPath+"outputFile.txt")){
			FileHelper.writeOutputFileByIgnoringDeletedData(sourceInput,sourceDelete,printWriter);
		}catch(Exception e) {
			System.out.println("Exception occurred in main method in WriteValuesWhichAreNotPresentInDeleteFile class");
		}
	}
}