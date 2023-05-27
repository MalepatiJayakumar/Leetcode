package com.practice.Comparable;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator3<T extends Comparable<T>> implements Comparator<T> {
	@Override
	public int compare(T obj1, T obj2) {
		return obj2.compareTo(obj1);
	}
}

public class TestComparatorExe3 {
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
		TreeSet<Integer> ts= new TreeSet<Integer>(new MyComparator3());
		ts.add(10);
		ts.add(20);
		ts.add(30);
		System.out.println(ts);
		
		TreeSet<Character> ts1= new TreeSet<Character>(new MyComparator3());
		ts1.add('A');
		ts1.add('B');
		ts1.add('C');
		System.out.println(ts1);
		
		TreeSet<String> ts2= new TreeSet<String>(new MyComparator3());
		ts2.add("Jai");
		ts2.add("reddy");
		ts2.add("kumar");
		System.out.println(ts2);
	}
}
