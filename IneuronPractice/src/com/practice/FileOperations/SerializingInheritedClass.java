package com.practice.FileOperations;

import com.practice.bean.Branch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* Not using FileHelper for serialization & DeSerialization , just for practice */

/* Branch class implemented Serialization */
class Student1 extends Branch {

	String name = "Jai";
	Long id = 110031L;

	@Override
	public String toString() {
		return "Student1 [name=" + name + ", id=" + id + "]";
	}
}

public class SerializingInheritedClass {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String filePath = FileHelper.folderPath + "inherit.ser";

		Student1 std = new Student1();

		/* Serialization */
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(std);
		oos.close();

		/* De - Serialization */
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student1 output = (Student1) ois.readObject();
		System.out.println("Output :: " + output);
		ois.close();
	}
}
/*
 * 
 * Output :: Student1 [name=Jai, id=110031] Even if haven't implemented
 * serialization for Student1 class , Student1 class got Serialized . Because
 * Parent class Branch have implemented Serializable so it inherited from
 * parent.
 * 
 */
