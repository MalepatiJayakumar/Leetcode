package com.practice.Interfaces;

class Alpha {
	public void foo() {
		System.out.println("Inside method foo in Alpha class");
	}
}

public class Beta extends Alpha{
	
	public void foo() {
		System.out.println("Inside method foo in Beta class");
	}
	
	public static void main(String[] args) {
		Alpha a= new Beta();
		Beta b= (Beta)a;
		a.foo();
		b.foo();
	}
}
