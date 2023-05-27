package com.practice.Revision;

class Test {
	public static void test() {
		System.out.println("Inside test method in Test class");
	}
}

class Test1 extends Test {
	public static void test() {
		System.out.println("Inside test method in Test1 class");
	}
}

public class CheckPolymorphism {
	public static void main(String[] args) {
		Test t = new Test1();
		t.test();
	}
}
