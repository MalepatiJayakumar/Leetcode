package com.practice.GarbageCollector;

import java.util.HashMap;

public class HashMapDominatingGC {
	public static void main(String[] args) {
		Student std = new Student(1L, "Jai", "Master's High school");
		HashMap map = new HashMap();
		map.put(std,"jai");
		std = null;
		System.gc(); // calling garbage collector ,internally jvm calls finalize() method , we
						// overrided that method so it should call finalize() in Student class, but here
						// we added std object into hashmap where it will only clears where there is an
						// jvm memory requirement so now it won't go into finalize() in Student class

	}
}
// Output :: empty