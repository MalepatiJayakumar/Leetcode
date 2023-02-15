package com.practice.InnerClass;

//Defining ram method but no body.
abstract class Computer1{
	public abstract void ram();
}

// If we want body in ram method we should inherit and make an ram method body
// But we have an alternative to implement in anonymous class

public class AnonymousClassForAbstract {
	
	public static void main(String[] args) {
		
		Computer1 com= new Computer1() {
			public void ram() {
				System.out.println("8GB ram has been added to computer");
			}
		};
		com.ram();
	}

}
