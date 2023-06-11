package com.practice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.ArrayList;

public class FileHelper {
	
	public static String folderPath = "C:\\Users\\malep\\OneDrive\\Desktop\\IOOperations\\";
	
	public static void readAndWriteData(String path, PrintWriter printWriter) throws IOException {
		try (FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String line = bufferedReader.readLine();
			while (line != null) {
				printWriter.println(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Exception occured in readAndWriteData in Helper class");
		}
	}
	
	public static void writeOnlyUniqueLines(String path, PrintWriter printWriter) {
		List<String> data = new ArrayList<>();
		try (FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			String line = bufferedReader.readLine();
			while (line != null) {
				readNextLine: {
					if (data.contains(line)) {
						break readNextLine;
					}
					printWriter.println(line);
					data.add(line);
				}
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Exception occured in writeOnlyUniqueLines in Helper class");
		}
	}
	
	public static void writeOutputFileByIgnoringDeletedData(String inputFilePath, String deleteFilePath,PrintWriter printWriter) {
		List<String> inputFileData = getDataFromFile(inputFilePath);
		List<String> deletedFileData = getDataFromFile(deleteFilePath);
		for (String data : inputFileData) {
			if (deletedFileData.contains(data)) {
				continue;
			}
			printWriter.println(data);
		}
	}

	public static List<String> getDataFromFile(String filePath) {
		List<String> data = new ArrayList<>();
		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line = bufferedReader.readLine();
			while (line != null) {
				data.add(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Exception occured in getDataFromFile in Helper class");
		}
		return data;
	}
	
	public static String getMaxLengthLine(String filePath) {
		String output = "";
		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			Integer maxLength = 0;
			String line = bufferedReader.readLine();
			while (line != null) {
				if (maxLength > line.length()) {
					continue;
				}
				maxLength = line.length();
				output = line;
				line = bufferedReader.readLine();
			}
		}catch(IOException e) {
			System.out.println("Exception occurred in getMaxLengthLine in Helper class");
		}
		return output;
	}
}