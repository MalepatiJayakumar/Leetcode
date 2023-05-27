package com.practice.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;

class Student {
	private String name;
	private Long id;
	Student(String name, Long id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
}
public class ArrayListTestApp {
	public static void main(String[] args) {
		Student std = new Student("jai", 1l);
		Student std1 = new Student("dhanush", 2l);
		Response<List<Student>> res = new Response<List<Student>>(Boolean.TRUE, "succcessfully completed",
				Arrays.asList(std, std1));
		//Iterating in forward direction --> Available in all collections
		Iterator<Student> itr = res.getData().iterator();
		while (itr.hasNext()) {
			System.out.println("student object " + itr.next());
		}
		
		// Iterating in Reverse direction --> Available in ArrayList & LinkedList
		ListIterator<Student> itr1= res.getData().listIterator(res.getData().size());
		while(itr1.hasPrevious()) {
			System.out.println(itr1.previous());
		}
		
		LinkedList<Student> list= new LinkedList<>();
		list.add(std);
		list.add(std1);
		Response<LinkedList<Student>> res1 = new Response<LinkedList<Student>>(Boolean.TRUE, "succcessfully completed",list);
		// Iterating through decending order--> useful if we want to iterate through list of intergers
		Iterator<Student> itr2= res1.getData().descendingIterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}