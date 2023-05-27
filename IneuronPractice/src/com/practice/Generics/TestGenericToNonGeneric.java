package com.practice.Generics;
import java.util.ArrayList;

public class TestGenericToNonGeneric {
	
	public static void main(String[] args) {
		//from JDK1.5
		ArrayList<String> list= new ArrayList<String>();
		list.add("JaiKumar");
		list.add("Reddy");
//		list.add(new Integer(10)) --> CE because of dataType
		System.out.println(list);
		//output --> [JaiKumar, Reddy]
		
		ArrayList<String> list1= new ArrayList<String>();
		list1.add("JaiKumar");
		list1.add("Reddy");
		test(list1);
		System.out.println(list1); // so here generic will be gone away which we are passing in place of raw parameter
		//output --> [JaiKumar, Reddy, 10, true]
	}
	//JDK 1.4--> provided because of backward compatibility for code which wrote for version from & blow JDK 1.4(Also known as compromise)
	public static void test(ArrayList list) {
		list.add(10L);
		list.add(new Boolean(true));
	}
}
