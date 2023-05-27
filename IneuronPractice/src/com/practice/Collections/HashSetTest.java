package com.practice.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSetTest {
	public static void main(String[] args) {
		
		//Order of insertion is not preserved
		HashSet set= new HashSet();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		System.out.println(set);
		
		//To work on insertion order we use LinkedHashSet which is subclass of HashSet. Insertion order is preserved
		LinkedHashSet lhs= new LinkedHashSet();
		lhs.add(10);
		lhs.add(20);
		lhs.add(30);
		lhs.add(40);
		System.out.println(lhs);
	}
}
