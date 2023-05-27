package com.practice.MultiThreading;

class MyThread extends Thread{
	
	@Override
	public void run() {
		int sum=0;
		for(int i=0;i<10;i++) {
			sum= sum+i;
		}
		System.out.println("Inside MyThread class "+sum);
	}
	
}

public class ThreadExecution1 {
	
	public static void main(String[] args) {
		MyThread thread= new MyThread();
		thread.start();
		int sum=0;
		for(int i=0;i<10;i++) {
			sum= sum+i;
		}
		System.out.println("Inside main method "+sum);
		
	}
}
