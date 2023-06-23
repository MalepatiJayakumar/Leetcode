package com.practice.FileOperations;

import java.util.StringTokenizer;

/* StringTokenizer is used to split string based on provided delimeter & default delimeter will be empty space */
public class StringTokenizerTest {
	
	public static void main(String[] args) {
		StringTokenizer stk = new StringTokenizer("jaya$kumar$reddy","$");
		System.out.println(stk.countTokens());
		while(stk.hasMoreTokens()) {
			String data = stk.nextToken();
			System.out.println(data);
		}
	}
}