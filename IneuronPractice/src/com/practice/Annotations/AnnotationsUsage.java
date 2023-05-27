package com.practice.Annotations;

/*Here we provided functionalInterface so we can only write one method in interface,if some other developers directly writes new method in Cricket
interface will get compile time error which is better than runtime exception*/
@FunctionalInterface
interface Cricket {
	void play();
}

class Test {
	void student() {
		System.out.println("Jai kumar writting an exam");
	}
}

class MathTest extends Test {
	/*
	 * By mistake if developer misspelling name of the name of the method that he
	 * wanted to override then method didn't actually overrided method.So if we use
	 * 
	 * @Override annotation the compile time error will be there if there is an
	 * method name mismatch
	 */

	@Override
	void student() {
		System.out.println("Jai kumar writting an maths exam");
	}

}

public class AnnotationsUsage {
	public static void main(String[] args) {
		Cricket c = () -> {
			System.out.println("Jai kumar playing cricket");
		};
		c.play();
	}
}
