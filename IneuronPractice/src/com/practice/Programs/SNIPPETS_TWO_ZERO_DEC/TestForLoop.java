package com.practice.Programs.SNIPPETS_TWO_ZERO_DEC;

public class TestForLoop {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); // capacity= 16
		try {
			for (;;) {
				sb.append("OCA"); // memory in heap area(OutOfMemoryError) ==> child or Error class
			}
		} catch (Exception e) { // If we handle Error then error block will be executed
			System.out.println("Exception!!");
		}
		System.out.println("Main Ends!!!");
	}
}



//What will be the result of compiling and executing Test class?
//A. "Main ends!!!" printed on the console and program terminates successfully.
//B. "Exception!!!" and "Main ends!!!" printed on the console and program terminates successfully.
//C. "Exception!!!" is printed on the console and program terminates successfully.
//D. "Exception!!!" is printed on the console and program terminates abnormally.
//E. Program terminates abruptly.


//Answer :: E


//output :- Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//at java.base/java.util.Arrays.copyOf(Arrays.java:3536)
//at java.base/java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:228)
//at java.base/java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:582)
//at java.base/java.lang.StringBuilder.append(StringBuilder.java:175)
//at com.practice.Programs.SNIPPETS_TWO_ZERO_DEC.TestForLoop.main(TestForLoop.java:8)