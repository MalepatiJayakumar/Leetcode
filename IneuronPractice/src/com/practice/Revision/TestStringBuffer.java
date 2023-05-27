package com.practice.Revision;

public class TestStringBuffer {
	
	private String var;
	
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
		System.out.println(sb.capacity()); // default capacity is 16, if data exceeds then capacity will increase by ((oldCapacity+1)*2)
		TestStringBuffer obj= new TestStringBuffer();
		obj.checkInstanceAndLocalVariable();
	}
	
	public void checkInstanceAndLocalVariable() {
		String var;
		this.var= "jai";
		System.out.println("Instance variable value :: "+this.var);
	}
}
