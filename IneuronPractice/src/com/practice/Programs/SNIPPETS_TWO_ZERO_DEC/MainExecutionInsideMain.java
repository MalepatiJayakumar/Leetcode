package com.practice.Programs.SNIPPETS_TWO_ZERO_DEC;

public class MainExecutionInsideMain {
	
	public static void main(String[] args) {
		try {
			main(args);
		}
		catch(Exception e) {
			System.out.println("Catch");
		}
		System.out.println("OUT");
	}

}
