package com.practice.Comparable;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator5<T extends Comparable<T>> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class TestComparatorExe5 {
	public static void main(String[] args) {
		TreeSet<Integer> ts = new TreeSet<>();
	}
}
