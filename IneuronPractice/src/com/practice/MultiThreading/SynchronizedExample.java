package com.practice.MultiThreading;
// we use synchronized to achieve dataInconsistency by maintaining object level lock(no other methods can be accessed by other thread as well)

class Display1 {
	
	public synchronized void testMethod1() {
		System.out.println("Inside testMethod1 to check synchronized behavioud");
	}
	
	public synchronized void testSynchronized() {
		try {
			System.out.println("Inside testSynchronized method before going to sleep");
			Thread.sleep(4000);
			System.out.println("Inside testSynchronized method after sleep");
		}
		catch(Exception e) {
			
		}
	}
}

class MyThread2 implements Runnable {
	
	Display1 display;
	MyThread2(Display1 display){
		this.display=display;
	}
	@Override
	public void run() {
		display.testMethod1();
	}
}

class MyThread3 implements Runnable {
	
	Display1 display;
	MyThread3(Display1 display){
		this.display=display;
	}
	@Override
	public void run() {
		display.testSynchronized(); // These will take a lock of whole Display object, so that MyThread2 is also calling 
									//synchronized method where to execute it requires an lock which is not available with that so it will wait till 
									//testSynchronized method execution and lock release
	}
}

public class SynchronizedExample {
	public static void main(String[] args) {
		Display1 d= new Display1();
		MyThread2 m1= new MyThread2(d);
		MyThread3 m2= new MyThread3(d);
		new Thread(m2).start();
		new Thread(m1).start();
	}
}
