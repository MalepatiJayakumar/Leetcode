package com.practice.Interfaces;

interface Test{
	void m1();
	void m2();
	void m3();
}

abstract class AdapterClass implements Test{
	public void m1() {}
	public void m2() {}
	public void m3() {}
}
class TestImpl1 extends AdapterClass{
	//By using above adapter class implementation we are only providing implementation to single method which is required,
	//otherwise we have provide implementation for all the methods
	public void m3() {
		System.out.println("In m3 method");
	}
}
public class TestAdapter {
	public static void main(String[] args) {
		TestImpl1 obj= new TestImpl1();
		obj.m3();
	}
}
