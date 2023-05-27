package com.practice.Comparable;
import java.util.Comparator;
import java.util.TreeSet;

class MyComparator4<T extends Comparable<T>> implements Comparator<T> {
	@Override
	public int compare(T t1, T t2) {
		Integer i1= t2.toString().length();
		return i1.compareTo(t1.toString().length());
	}
}
public class TestComparatorExe4 {
	public static void main(String[] args) {
		TreeSet<String> ts= new TreeSet<String>(new MyComparator4());
		ts.add("abc");
		ts.add("ab");
		ts.add("a");
		System.out.println(ts);
	}
}