package com.practice.MultiThreading;

class ChildThread1 implements Runnable {

	static Thread mainThread;

	@Override
	public void run() {
		try {
			mainThread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child thread is getting executed");
		}
	}
}

public class ChildThreadWaitForParentThread {
	public static void main(String[] args) throws InterruptedException{
		ChildThread1.mainThread= Thread.currentThread();
		
		ChildThread1 ct= new ChildThread1();
		Thread t= new Thread(ct);
		t.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("Main thread is getting executed");
		}
	}
}
