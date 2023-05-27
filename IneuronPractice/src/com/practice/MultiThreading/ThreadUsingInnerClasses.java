package com.practice.MultiThreading;

//Anonymous inner classes 
public class ThreadUsingInnerClasses {
	// Two .class files will be generated as we are using inner classes. classes
	// will be generated like
	// :: ThreadUsingInnerClasses.class && ThreadUsingInnerClasses$1.class
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Child Thread");
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		t.join();
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread");
		}
	}
}
