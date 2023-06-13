package com.practice.FileOperations;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class Login implements Serializable {
	String userName = "JaiKumar";
	String password = "password";

	private void writeObject(ObjectOutputStream oos) throws Exception {
		System.out.println("Inside writeObject method in Login class");
		oos.defaultWriteObject();
		String ePWD = "123" + password;
		oos.writeObject(ePWD);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		System.out.println("Inside readObject method in Login class");
		ois.defaultReadObject();
		String ePWD = (String) ois.readObject();
		password = ePWD.substring(3);
		System.out.println("Inside readObject in Login class >> password :: " + password);
	}
}

public class CustomSerializationTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Login login = new Login();
		String filePath = FileHelper.folderPath + "custom.ser";
		/* serialization of object */
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(login);
		oos.close();
		/* writing deserialization object */
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ois.readObject();
		ois.close();
	}
}