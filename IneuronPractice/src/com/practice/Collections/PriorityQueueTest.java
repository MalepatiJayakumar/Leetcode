package com.practice.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue pq= new PriorityQueue();
		pq.add(100);
		pq.add(50);
		pq.add(150);
		pq.add(25);
		pq.add(75);
		pq.add(125);
		pq.add(175);
		System.out.println(pq);
	}

}
/* 25,50,125,100,75,150,175 */