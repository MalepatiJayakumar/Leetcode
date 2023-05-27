package com.practice.MultiThreading;

public class ThreadUsingInnerClass1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t= new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.println("Inside child Thread");
				}
			}
		});
		t.start();
		t.join();
		for(int i=0;i<5;i++) {
			System.out.println("Inside Main Thread");
		}
	}

}
