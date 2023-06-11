package com.practice.FileOperations;

public class GetMaxLengthString {
	public static void main(String[] args) {
		String filePath = FileHelper.folderPath + "abc.txt";
		String largeData = FileHelper.getMaxLengthLine(filePath);
		System.out.println("Max Length string is :: "+largeData+ " >>  size is :: "+largeData.length());
	}
}