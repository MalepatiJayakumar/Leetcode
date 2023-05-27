package com.practice.MultiThreading;

class MyRunnable2 implements Runnable {
	public static Integer total = 0;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("acquired lock for computation");
			for (int i = 0; i < 10; i++) {
				total = +i;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("releasing lock from computation");
			this.notify();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Number of active thread alive in run method :: " + Thread.activeCount());
	}
}

public class WaitAndNotifyThread1 {
	public static void main(String[] args) throws InterruptedException {

		MyRunnable2 r = new MyRunnable2();
		Thread t = new Thread(r);
		t.start();
		// t.join(); --> if we just use join also does same work but join waits until
		// whole execution completes, but here we are waiting will synchronized block
		// execution in run method implementation
		synchronized (r) {
			System.out.println("Entered into synchronized block before calling wait");
			// main thread waits till completion of synchronized block in MyRunnable thread
			// and once it notifies
			// main thread with releasing lock then main thread execution will start
			r.wait(); // once the
			System.out.println("Number of active thread alive in main method :: " + Thread.activeCount());
			System.out.println("complete wait method execution");
		}
	}
}
