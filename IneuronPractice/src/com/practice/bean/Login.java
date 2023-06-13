package com.practice.bean;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* These object is created to test customized serialization --> impl is in CustomSerializationTest */
public class Login implements Serializable{
	String userName = "JaiKumar";
	String password = "password";
	
	public void writeObject(ObjectOutputStream oos) throws Exception{
		System.out.println("Inside writeObject method in Login class");
	}
	
	public void readObject(ObjectInputStream ois) throws Exception{
		System.out.println("Inside readObject method in Login class");
	}
}