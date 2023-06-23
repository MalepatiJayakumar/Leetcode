package com.practice.FileOperations;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Externalizable;

class Login4 implements Externalizable {
	
	public static Long serialVersionUID = 1L;
	
	String userName;
	String password;
	Long year;

	public Login4(String userName , String password , Long year) {
		System.out.println("args constructor in Login4 class");
		this.userName = userName;
		this.password = password;
		this.year     = year;  
	}
	public Login4() {
		System.out.println("No-args constructor in Login4 class");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Inside writeExternal method in Login4");
		out.writeObject(userName);
		out.writeObject(year);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Inside readExternal method in Login4");
		userName = (String)in.readObject();
		year     = (Long)in.readObject();
	}
}

public class ExternalizableTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String filePath = FileHelper.folderPath + "testExternalizable.ser";

		Login4 login = new Login4("jaikumar","password",2001L);

		/* Serialization Started */
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(login);
		oos.close();
		/* Serialization ended */

		/* De-Serialization started */
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Login4 output = (Login4) ois.readObject();
		System.out.println(output.userName + " ---> " + output.password + " ---> " + output.year);
		ois.close();
		/* De-Serialization ended */
	}
}