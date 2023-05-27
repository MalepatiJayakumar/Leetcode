package com.practice.Collections;
import java.util.LinkedList;
public class LinkedListTest {
	
	public static void main(String[] args) {
		LinkedList list= new LinkedList();
		
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(1,5);
		System.out.println(list);
		
		//May or may not added into collection
		list.offerFirst(2);
		list.offerLast(20);
		System.out.println(list);
		
		//Must add into collections
		list.addFirst(1);
		list.addLast(25);
		System.out.println(list);
		
		//list.peekFirst() || list.peekLast() --> fetches data and gives to programmers without effecting collection
		System.out.println(list.peekFirst());
		System.out.println(list.peekLast());
		System.out.println("List after done with peek fetch :: "+list);
		
		//list.pollFirst() || list.pollLast() --> fetches data and gives to programmers & deletes that data from collection
		System.out.println(list.pollFirst());
		System.out.println(list.pollLast());
		System.out.println("List after done with pool fetch :: "+list);
		
	}

}
