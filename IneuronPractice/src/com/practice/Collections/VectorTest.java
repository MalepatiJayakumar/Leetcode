package com.practice.Collections;

import java.util.Vector;
import java.util.Enumeration;

public class VectorTest {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add(10);
		v.add(20);
		v.add(30);
		v.add(40);

		// In vector we don't have iterator , we have enumeration for iteration in
		// vector
		Enumeration em = v.elements();
		while (em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
	}
}