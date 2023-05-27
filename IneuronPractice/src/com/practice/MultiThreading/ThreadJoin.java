package com.practice.MultiThreading;

class ChildThread implements Runnable {

	public void run() {
		try {
			Thread.sleep(5000); // Thread sleep for 2sec
			for (int i = 0; i < 5; i++) {
				System.out.println("Jai working on dev Task");
			}
		} catch (InterruptedException e) {
			System.out.println("Exception occured while executing child thread");
		}
	}
}

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException{
		ChildThread ch= new ChildThread();
		Thread t= new Thread(ch);
		t.start();
		t.join(); // Here main thread waiting until execution of thread t.
//		t.join(1000); Main thread waits only for 1 Sec and then it will be in don't wait for child thread , so whenever TS gives chances it will go for execution
//		t.join(1000,50); // Main thread waits for 1 sec 50 nano sec.
		for(int i=0;i<5;i++) {
			System.out.println("Main thread is getting executed");
		}
	}
}
