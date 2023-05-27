package com.practice.MultiThreading;

import java.io.InputStream;

class Display3 {
	public static synchronized void m1() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
				System.out.println("Inside m1 method");
			} catch (Exception e) {

			}
		}
	}
	public static synchronized void m2() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
				System.out.println("Inside m2 method");
			} catch (Exception e) {

			}
			InputStreamSource input= new InputStreamSource();
		}
	}
}

public class StaticSynchronizedExample {
	public static void main(String[] args) {
		Display3 d1= new Display3();
		Display3 d2= new Display3();
		
		
		Runnable r = () -> {
			d1.m1();
		};
		
		Runnable r1 = () -> {
			d2.m2();
		};
		
		new Thread(r).start();
		new Thread(r1).start();
		
	}
}
