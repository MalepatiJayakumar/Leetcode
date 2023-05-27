package com.practice.MultiThreading;

public class ThreadUsingLambdaExpression {

	public static void main(String[] args) throws InterruptedException {
		// using lambda expressions only one .class file will be generated
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Child Thread");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread");
			if (i == 1) {
				t.join();
			}
		}
	}
}