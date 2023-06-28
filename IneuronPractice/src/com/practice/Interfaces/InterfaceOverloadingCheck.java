package com.practice.Interfaces;

interface Left{
	public void m1();
}
interface Right{
	public int m1();
}
/*
class TestImpl implements Left, Right {

	// Compiler only checks for method signature(m1()) so, implementing same method
	// twice is not possible. Results in compile time error

	@Override
	public int m1() {
		return 0;
	}

	@Override
	public void m1() {
	}

}

*/

public class InterfaceOverloadingCheck {
	
	public static void main(String[] args) {
		
	}
}
