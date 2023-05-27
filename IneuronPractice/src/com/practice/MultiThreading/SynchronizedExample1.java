package com.practice.MultiThreading;

class Display2 {

	// requires an class level lock --> if m2 has an lock still you can access m2
	// method from the another thread
	public static synchronized void m1() {
		try {
			System.out.println("inside m1() method before going to sleep");
			Thread.sleep(3000);
			System.out.println("inside m1() method after sleep");
		} catch (Exception e) {

		}
	}

	// requires an class level lock --> if m1 has an lock still you can access m2
	// method from the another thread
	public static synchronized void m2() {
		try {
			System.out.println("inside m2() method before going to sleep");
			Thread.sleep(5000);
			System.out.println("inside m2() method after sleep");
		} catch (Exception e) {

		}
	}

	// no lock is required
	public static void m3() {
		try {
			System.out.println("inside m3() method before going to sleep");
			Thread.sleep(5000);
			System.out.println("inside m3() method after sleep");
		} catch (Exception e) {

		}
	}

	// requires object level lock --> even if there is an class level lock m4 ,
	// object level lock is not present so these method will get execute by taking
	// an object level lock
	public synchronized void m4() {
		try {
			System.out.println("inside m4() method before going to sleep");
			Thread.sleep(5000);
			System.out.println("inside m4() method after sleep");
		} catch (Exception e) {

		}
	}

	// no lock is required
	public void m5() {
		try {
			System.out.println("inside m5() method before going to sleep");
			Thread.sleep(5000);
			System.out.println("inside m5() method after sleep");
		} catch (Exception e) {

		}
	}
}

public class SynchronizedExample1 {
	public static void main(String[] args) {
		Display2 d= new Display2();
		Runnable r = () -> {
			Display2.m1();
		};
		
		Runnable r1 = () -> {
			Display2.m2();
		};
		
		Runnable r2 = () -> {
			Display2.m3();
		};
		
		Runnable r3 = () -> {
			d.m4();
		};
		
		Runnable r4 = () -> {
			d.m5();
		};
		
		new Thread(r).start();
		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();
	}
}
