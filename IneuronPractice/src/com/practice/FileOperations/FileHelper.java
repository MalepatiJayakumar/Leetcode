package com.practice.FileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.List;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;

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
		} catch (IOException e) {
			System.out.println("Exception occurred in getMaxLengthLine in Helper class");
		}
		return output;
	}
	
	/**
	 * @param <T>
	 * @param fileName
	 * @param object
	 * @throws IOException
	 */
	/**
	 * saving an object into file in provided file path first we need to get
	 * FileOutputStream object which is close to file so that outputStream will be
	 * created for that object, we use writeObject method to write object into file.
	 * if provided object is not implemented Serializable then it will throw
	 * exception as below Exception in thread "main"
	 * java.io.NotSerializableException: com.practice.bean.Dog
	 */
	public static <T> void saveObjectInFile(String fileName, List<T> objects) throws IOException {
		System.out.println("Inside saveObjectInFile in FileHelper class >> fileName :: " + fileName);
		FileOutputStream fileStream = new FileOutputStream(fileName);
		ObjectOutputStream outputStream = new ObjectOutputStream(fileStream);
		for(T obj : objects)
			outputStream.writeObject(obj);
		outputStream.close();
		System.out.println("Inside saveObjectInFile in FileHelper class >> completed execution");
	}

	/**
	 * @param <T>
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	/**
	 * In these method we expect an filePath , where that file will be stored as an
	 * file.ser (an serialized object). we read that file data so sends response in
	 * List<Object> format. so that based on requirement we will typecast that
	 * object.
	 * 
	 * readObject() --> method internally creates an object where as it won't call
	 * any constructors or static blocks inside that class, Not sure how it will
	 * create an object internally.
	 * 
	 * if there is multiple object in File it will read & sends as List<Objects>
	 * format, so user need to typecast based on he classType
	 */
	public static Response<List<Object>> readObjectFromFile(String filePath)
			throws IOException, ClassNotFoundException {
		System.out.println("Inside readObjectFromFile in FileHelper class >> filePath :: " + filePath);
		FileInputStream fileStream = new FileInputStream(filePath);
		ObjectInputStream objectStream = new ObjectInputStream(fileStream);
		Object obj = null;
		List<Object> output = new ArrayList<>();
		objectFilter: {
			try {
				while ((obj = objectStream.readObject()) != null) {
					output.add(obj);
				}
			} catch (Exception e) {
				if (e instanceof java.io.EOFException) {
					System.out.println("All objects read and displayed");
					break objectFilter;
				} else {
					System.out.println("Some Exception Occured.");
					e.printStackTrace();
				}
			}
		}
		objectStream.close();
		return new Response<List<Object>>(Boolean.TRUE, Constants.SUCCESS, output);
	}
}