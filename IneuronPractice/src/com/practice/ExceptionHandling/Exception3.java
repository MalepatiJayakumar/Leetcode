package com.practice.ExceptionHandling;

class Alpha {
	public void alpha() throws ArithmeticException {
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			System.out.println("Throwing exception from catch block");
			throw e; // try catch is first preference even throws & throw both are present
		}
	}
}

public class Exception3 {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		try {
			Alpha a = new Alpha();
			a.alpha();
		} catch (Exception e) {
			System.out.println("Exception caught in Main method");
		}
	}
}