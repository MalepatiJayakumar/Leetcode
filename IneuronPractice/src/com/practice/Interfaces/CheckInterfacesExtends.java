package com.practice.Interfaces;

interface A1 {
	public String value="abc";
	public void test();
}

interface B1{
	
}

interface C1 extends A1,B1 {
	public void test1();
}

public class CheckInterfacesExtends {
	public static void main(String[] args) {
		System.out.println("Valid declarations");
	}
}
