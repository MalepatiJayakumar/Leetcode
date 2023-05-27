package com.practice.Comparable;
import java.util.TreeSet;

public class TestComparableExe {
	
	public static void main(String[] args) {
		/*
		 * TreeSet internally uses Comparable interface to sort the elements present in
		 * TreeSet. So values in treeSet is always in sorted order.
		 */
		TreeSet ts= new TreeSet();
		ts.add(30);
		ts.add(20);
		ts.add(10);
		System.out.println(ts); 
		/* output : [10, 20, 30] */
		
		
		
		/*
		 * TreeSet internally uses Comparable interface, where it compares once data to
		 * other which do that comparison it can't compare two values with different
		 * classes.
		 */		
//		TreeSet ts1= new TreeSet();
//		ts1.add("A");
//		ts1.add("B");
//		ts1.add("C");
//		ts1.add(10);
//		System.out.println(ts1);
		/* output:- RE(CE successful)
		 * Exception in thread "main" java.lang.ClassCastException: class
		 * java.lang.String cannot be cast to class java.lang.Integer (java.lang.String
		 * and java.lang.Integer are in module java.base of loader 'bootstrap') at
		 * java.base/java.lang.Integer.compareTo(Integer.java:71) at
		 * java.base/java.util.TreeMap.put(TreeMap.java:806) at
		 * java.base/java.util.TreeMap.put(TreeMap.java:534) at
		 * java.base/java.util.TreeSet.add(TreeSet.java:255) at
		 * com.practice.Comparable.TestComparableExe.main(TestComparableExe.java:21)
		 */
		
		
		/*
		 * Whatever data we are adding to TreeSet should implement comparable internally
		 * otherwise comparable can't compare , where it gives classCastException
		 */		//From JDK 11 StringBuffer & StringBuilder also implements Comparable so we won't get exception.
		TreeSet ts2= new TreeSet();
		ts2.add(new StringBuilder("A"));
		ts2.add(new StringBuilder("B"));
		ts2.add(new StringBuilder("C"));
		System.out.println(ts2);
		/*
		 * output : (Note: tried with below versions) 
		 * Exception in thread "main"
		 * java.lang.ClassCastException: java.lang.StringBuffer cannot be cast to
		 * java.lang.Comparable at java.util.TreeMap.compare(Unknown Source) at
		 * java.util.TreeMap.put(Unknown Source) at java.util.TreeSet.add(Unknown
		 * Source) at CheckStringBufferEx.main(CheckStringBufferEx.java:12)
		 */
	}
}
