package com.practice.Comparable;

/*
internally all the wrapper classes and Treeset & few other methods implements Comparable interface where it uses compareTo method for by default sorting.
As return type of compareTo method is integer it return in -ve or +ve or 0 based on validation
ex:- 
	obj1.compareTo(obj2);
			|-> return +ve, value if obj1 has to come before obj2
			|-> return -ve, value if obj1 has to come after obj2
			|-> return 0, if both the objects are equal 


@FunctionalInterface
interface Comparable {
	public abstract int compareTo(T);
}
*/

public class TestComparable1 {
	public static void main(String[] args){
		System.out.println("z".compareTo("a")); // +ve value
		System.out.println("a".compareTo("z")); // -ve value
		System.out.println("a".compareTo("a")); // 0
		System.out.println("a".compareTo(null)); // NullPointerException  
	}
}