package com.practice.Programs;

class Test {
	public void testEllipse(int... x) {
		int length = x.length;
		System.out.println(x);
	}
	//now it will accept 2d array
	public void checkTwoDimensionalArrayAcceptance(int[]... x) {
		System.out.println(x);
	}
}

public class VarArgs {
	public static void main(String[] args) {
		int[] arr= new int[] {10,20};
		int[] arr1= new int[] {10,20,30};
		
 		Test obj= new Test();
		obj.testEllipse();
		obj.testEllipse(10);
		obj.testEllipse(10,20);

		obj.checkTwoDimensionalArrayAcceptance(arr,arr1);
	
	}
}
