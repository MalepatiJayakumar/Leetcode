package com.practice.Interfaces;

interface ISample{
	
	// 100% abstraction
	public void m1();
	public void m2(); // methods are abstract and public by default in interfaces
}

class SampleImpl implements ISample{
	
	@Override  // indicates these method is an implementation to compiler 
	public void m1() {
		System.out.println("M1 method implementation");
	}
	public void m2() {
		System.out.println("M2 method implementation");
	}
}

public class TestApp {
	public static void main(String[] args) {
		
		ISample obj= new SampleImpl(); //loosely coupling
		obj.m1();
		obj.m2();
	}
}
