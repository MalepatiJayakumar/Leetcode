package com.practice.Collections;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.LinkedList;

public class IteratorTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		System.out.println("Accessing elements in forward direction using iterator");
		//Available in all the collection classes
		Iterator itr = list.iterator(); // creates an cursor and waits at door step of list data. once we access
										// hasNext() method it check weather next data is available or not . if
										// available we call next() method where it moves cursor to next data and
										// fetches data at the same time
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println("Accessing element in reverse direction using ListIterator");
		//Available only for ArrayList & LinkedList
		ListIterator itr1= list.listIterator(list.size());
		while(itr1.hasPrevious()) {
			System.out.println(itr1.previous());
		}
		
		
		System.out.println("Accessing element in reverse direction using DescendingIterator");
		//Available only for LinkedList, ArrayDeque & TreeSet
		LinkedList ll= new LinkedList();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		Iterator itr2= ll.descendingIterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}
