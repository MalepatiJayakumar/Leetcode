package com.practice.MultiThreading;
import java.util.Arrays;
class A {
	public synchronized void d(B b) {
		System.out.println("Entered into d() method in A class");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Exception occured in d() method in A class");
		}
		System.out.println("Calling last() method in B class");
		b.last();
	}

	public synchronized void last() {
		System.out.println("Entered into last() method in A class");
	}
}

class B {
	public synchronized void d(A a) {
		System.out.println("Entered into d() method in A class");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Exception occured in d() method in B class");
		}
		System.out.println("Calling last() method in A class");
		a.last();
	}

	public synchronized void last() {
		System.out.println("Entered into last() method in B class");
	}
}

public class MultiThreadingDeadLock {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();

		new Thread(() -> {
			a.d(b);
		}).start();

		new Thread(() -> {
			b.d(a);
		}).start();
		
		String text = "Keep calm and code on";
		String[] words= text.split(" ");
		Arrays.sort(words, (str1, str2) -> str1.length()-str2.length());
		
		// As we are having tight coupling of A with B & B with A , both the threads
		// will
		// be waiting for lock from each other , so both threads will be in Waiting
		// state which result in DeadLock
	}
}
