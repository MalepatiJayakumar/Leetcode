package com.practice.Comparable;

import java.util.Comparator;
import java.util.TreeSet;

class MyComparator1 implements Comparator {
	@Override
	public int compare(Object obj1, Object obj2) {
		Integer i1 = (Integer) obj1;
		Integer i2 = (Integer) obj2;

		return -(i1.compareTo(i2));
		/*
		 * calling comparable compareTo() which give return in ascending order, where as
		 * we are converting into opposite and returining
		 */
		
//		public int compare(Object obj1, Object obj2) {
//			Integer I1 = (Integer)obj1;
//			Integer I2 = (Integer)obj2;
//			return I1.compareTo(I2);
//			return -I1.compareTo(I2);
//			return I2.compareTo(I1);
//			return -I2.compareTo(I1);
//			return +1;
//			return -1;
//			return 0;
//			}
//			Output:
//			1. Ascending order
//			2. Descending order
//			3. Descending order
//			4. Ascending order
//			5. insertion order
//			6. reverse of insertion order
//			7. only first element will be inserted.
	}
}

public class TestComparatorExe2 {

	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyComparator());
		ts.add(10);
		ts.add(0);
		ts.add(20);
		ts.add(15);
		ts.add(5);
		System.out.println(ts);
	}

}
