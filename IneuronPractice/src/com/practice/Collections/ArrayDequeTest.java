package com.practice.Collections;
import java.util.ArrayDeque; // implements deque so all the methods are methods are available from deque

public class ArrayDequeTest {
	public static void main(String[] args) {
		ArrayDeque ad= new ArrayDeque();
		ad.add(5);
		ad.add(10);
		ad.add(10);//duplicates are allowed in ArrayDeque
		System.out.println(ad);
		
		//we don't have index based data fetching & insertion in java. we can only add at first or last using addFirst() & addLast() methods		
		ad.addFirst(2);
		ad.addLast(15);
		System.out.println(ad);
	}
}
