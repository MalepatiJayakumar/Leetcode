package com.practice.Programs.SNIPPETS_TWO_ZERO_DEC;

public class CheckUnHandledExceptionInStaticBlock {
	static {
		System.out.println(1/0);
	}
	public static void main(String[] args) {
		System.out.println("Inside main method");
	}
}

/*
 * output :-
 * 
 * Exception in thread "main" java.lang.ExceptionInInitializerError Caused by:
 * java.lang.ArithmeticException: / by zero at
 * com.practice.Programs.SNIPPETS_TWO_ZERO_DEC.
 * CheckUnHandledExceptionInStaticBlock.<clinit>(
 * CheckUnHandledExceptionInStaticBlock.java:6)
 * 
 */