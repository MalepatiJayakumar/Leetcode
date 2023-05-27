package com.practice.MultiThreading;

class MyRunnable implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("Inside child Thread using Runnable interface");
		}
		System.out.println("Child Method Current Thread Name :: "+Thread.currentThread().getName());
		System.out.println("Child Thread priority :: "+Thread.currentThread().getPriority());
	}
}

public class ThreadWithRunnable {
	public static void main(String[] args) {

		MyRunnable r = new MyRunnable();

		Thread thread = new Thread(r); // creates an thread object for MyRunnable, so that run method will be picked up
										// from here
		thread.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Inside main Thread");
		}
		System.out.println("Main method Current Thread Name :: " + Thread.currentThread().getName());
		System.out.println("Main Thread priority :: "+Thread.currentThread().getPriority());

	}	

}
