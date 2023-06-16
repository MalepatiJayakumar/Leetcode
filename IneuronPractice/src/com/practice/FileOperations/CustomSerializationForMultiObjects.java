package com.practice.FileOperations;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class Login1 implements Serializable {

	String userName = "JaiKumar";
	transient String password = "password";
	transient int pin = 1111;
	transient Long data = 123456L;

	private void writeObject(ObjectOutputStream oos) throws Exception {
		System.out.println("Inside readObject in Login");
		oos.defaultWriteObject();
		oos.writeObject("123" + password);
		oos.writeInt(1111 + 1111);
		oos.writeLong(data);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		System.out.println("Inside readObject in Login");
		ois.defaultReadObject();
		String ePWD = (String) ois.readObject();
		password = ePWD.substring(3);
		int ePin = ois.readInt();
		pin = ePin - 1112;
	}
}
	
public class CustomSerializationForMultiObjects {
	public static void main(String[] args) throws Exception {
		String filePath = FileHelper.folderPath + "encryCustom.ser";
		Login1 login = new Login1();
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(login);
		oos.close();
		
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Login1 output = (Login1)ois.readObject();
		System.out.println("UserName :: "+output.userName+" >> password :: "+output.password+" >> pin :: "+output.pin);
		ois.close();
	}
}
