package com.practice.GarbageCollector;
import java.util.WeakHashMap;

public class WeakHashMapForGCUsage {
	public static void main(String[] args) {
		Student std = new Student(1L, "Jai", "Master's High school");
		WeakHashMap map= new WeakHashMap();
		map.put(std,"jai");
		std=null;
		System.gc();
	}
}

// output :: id : 1   >> name : Jai   >>  school : Master's High school
//		     Collected GC object