package com.practice.Revision;

public class CheckInstanceVariableAccess {
	private Integer a = 10;
	public static void main(String[] args) {
//		System.out.println(a); Instance variables are available only when we create object of class with new keyword, but static methods will be called without creating object where there is an possibility of not having an instance variable it will result in compile time exception
		CheckInstanceVariableAccess obj= new CheckInstanceVariableAccess();
		System.out.println(obj.a); // In static area/methods also we can get instance variables using object reference
		
		
		// Check variable access in Switch case
		int i= 20;
		final int j= 20;
		switch(i) {
		case 10: 
			System.out.println("Matched with 10 variable");
			break;
		case j: // y value is not known at compile time as compiler only checks for datatypes at Compile time
			System.out.println("Matched with 20 variable");
			break;
		}
		
	}

	public void accessInstanceVariable() {
		System.out.println(a);
	}

}
