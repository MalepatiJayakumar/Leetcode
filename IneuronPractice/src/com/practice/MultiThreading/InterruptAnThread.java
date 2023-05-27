package com.practice.MultiThreading;

class ChildThread2 implements Runnable {
	
	@Override
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("Child Thread executed :: "+i);
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Exception occurred while executing child thread");
		}
	}
}

public class InterruptAnThread {
	
	public static void main(String[] args) throws InterruptedException {
		ChildThread2 ch = new ChildThread2();
		Thread t = new Thread(ch);
		t.start();
		t.interrupt(); // whenever t thread goes into sleep/waiting state it throws an InterruptedException
		System.out.println("Main Thread");
	}

}
