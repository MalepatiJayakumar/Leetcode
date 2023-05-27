package com.practice.Comparable;
import java.util.Comparator;
import java.util.TreeSet;

class MyComparator implements Comparator{
	@Override //writing for descending order sorting of Integer values
	public int compare(Object obj1, Object obj2) {
		System.out.println("Overrided compare method, for customized sorting");
		Integer i1= (Integer) obj1;
		Integer i2= (Integer) obj2;
		if(i1 > i2) 
			return -1;
		else if(i1 < i2)
			return +1;
		else
			return 1;
	}
}

public class TestComparatorExe1 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyComparator());
		/*
		 * As we provided MyComparator, JVM calls overrided compare method in
		 * MyComparator class.We provided logic for sorting in descending order output
		 * will be in descending order
		 */		
		ts.add(10);
		ts.add(0);
		ts.add(20);
		ts.add(5);
		ts.add(15);
		System.out.println(ts);
	}
}
