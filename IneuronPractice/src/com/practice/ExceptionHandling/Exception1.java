package com.practice.ExceptionHandling;

//class Alpha{
//	public void alpha() {
//		System.out.println("Inside alpha method in Alpha class");
//	}
//}

public class Exception1 {
	public static void main(String[] args) {
		try {
			System.out.println("Inside try block before exception occured");
			int a = 100 / 0; // Arithmetic Exception
			System.out.println("Inside try block after exception occured");
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		System.out.println("Checking program execution after catching exception");
	}
}