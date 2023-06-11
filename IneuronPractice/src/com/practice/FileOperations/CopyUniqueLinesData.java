package com.practice.FileOperations;

import java.io.IOException;
import java.io.PrintWriter;

public class CopyUniqueLinesData {
	public static void main(String[] args) throws IOException {
		String source = FileHelper.folderPath + "file1.txt";
		String target = FileHelper.folderPath + "output.txt";
		try (PrintWriter printWriter = new PrintWriter(target)) {
			FileHelper.writeOnlyUniqueLines(source, printWriter);
		} catch (IOException e) {
			System.out.println("Exception occurred in main method in CopyUniqueLinesData class");
		}
	}
}