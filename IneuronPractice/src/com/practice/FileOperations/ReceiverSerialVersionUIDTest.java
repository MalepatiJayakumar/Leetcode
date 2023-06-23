package com.practice.FileOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.practice.bean.College;


public class ReceiverSerialVersionUIDTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String filePath = FileHelper.folderPath + "serialVersionUID.ser";
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		College d = (College) ois.readObject();
		System.out.println(d);
		ois.close();
	}
}