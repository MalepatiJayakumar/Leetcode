package com.practice.Collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentTest {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList c= new CopyOnWriteArrayList();
		c.add(10);
		c.add(20);
		c.add(30);
		c.add(40);
		
		Iterator itr= c.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			c.add(15);
		}
		System.out.println(c.size());
	}

}
