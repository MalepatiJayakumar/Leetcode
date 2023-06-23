package com.practice.FileOperations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.practice.bean.College;

public class SerialVersionUIDTest{

	public static void main(String[] args) throws IOException {
		String filePath = FileHelper.folderPath+"serialVersionUID.ser";
		College clg = new College();
		FileOutputStream   fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(clg);
		oos.close();
	}
}