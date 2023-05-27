package com.practice.MultiThreading;

import java.util.Stack;

public class IllegalMonitorStateExceptionExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		Stack s1= new Stack();
		Stack s2= new Stack();
		
		synchronized(s1) {
			s2.wait();//IllegalMonitorStateException
		}
		synchronized(s1) {
			s1.wait();//valid
		}
		synchronized(s2) {
			s2.wait();//valid
		}
		
	}

}
