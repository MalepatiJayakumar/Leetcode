package com.practice.FileOperations;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/* Child class is serialized , Parent is not serialized. Now we are write child object data into stream by changing value at runtime.
 *  But while getting the output after De-Serialization we will get instance value in origin parent class because as parent is not implemented serialization.
 *   It will just fetches variable values & provides to us.
 */
class Login2 {
	int i = 10;

	Login2() {
		System.out.println("Inside constructor in Login2 class");
	}
}

class Login3 extends Login2 implements Serializable {
	int j = 20;

	Login3() {
		System.out.println("Inside Constructor in Login3 class");
	}
}

public class ChildSerializationTest {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Login3 login = new Login3();
		login.i = 99;
		login.j = 100;

		String filePath = FileHelper.folderPath + "childClassSerialization.ser";

		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(login);
		oos.close();

		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Login3 output = (Login3) ois.readObject();
		ois.close();
		System.out.println("output data :: " + output.i + "====>" + output.j);
	}
}