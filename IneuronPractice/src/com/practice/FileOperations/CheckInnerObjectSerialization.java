package com.practice.FileOperations;

import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.practice.Utilities.Constants;
import com.practice.Utilities.Response;

/* Reading List of objects from serialized file */

class Animal implements Serializable{
	String  name;
	Integer age;
	Animal(String name , Integer age){
		this.name = name;
		this.age  = age;
	}
}

public class CheckInnerObjectSerialization {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		String filePath = FileHelper.folderPath+"inner_list_object.ser";
		
		Animal dog = new Animal("Tommy",2);
		Animal cat = new Animal("jimmy",1);
		Response<List<Animal>> response = new Response<List<Animal>>(Boolean.TRUE,Constants.SUCCESS,Arrays.asList(dog,cat));
		
		/* Serialization */
		FileOutputStream   fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(response);
		oos.close();
		
		/* De-Serialization */
		FileInputStream   fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Response<List<Animal>> output = (Response<List<Animal>>)ois.readObject();
		System.out.println(output);
		ois.close();
	}
}
