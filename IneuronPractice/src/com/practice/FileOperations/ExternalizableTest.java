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
	String userName = "JaiKumar";
	String password = "password";
	Long year = 2001L;

	public Login4() {
		System.out.println("No-args constructor in Login4 class");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Inside writeExternal method in Login4");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Inside readExternal method in Login4");
	}
}

public class ExternalizableTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String filePath = FileHelper.folderPath + "testExternalizable.ser";

		Login4 login = new Login4();

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