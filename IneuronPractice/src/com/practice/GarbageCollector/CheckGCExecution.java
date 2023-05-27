package com.practice.GarbageCollector;
import java.util.HashMap;

class Student {
	private Long id;
	private String name;
	private String school;
	
	public Student(Long id,String name,String school) {
		this.id=id;
		this.name=name;
		this.school=school;
		System.out.println("id : "+id+"   >> name : "+name+"   >>  school : "+school);
	}
	@Override
	public void finalize() {
		System.out.println("Collected GC object");
	}
}

public class CheckGCExecution {
	public static void main(String[] args) {
		Student std= new Student(1L,"Jai","Master's High school");
		HashMap map= new HashMap(); //no relation of std object with hasmap
		std=null;
		System.gc(); //calling garbage collector ,internally jvm calls finalize() method , we overrided that method so it should call finalize() in Student class
 	}
}

//Output :: Collected GC object

