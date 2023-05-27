package com.practice.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student {
	private String name;
	private Integer age;
	private String city;
	
	Student(String name,Integer age,String city) {
		this.name=name;
		this.age=age;
		this.city=city;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "name : "+name+" >> age : "+age+" >> city "+city;
	}
}

public class MapPractice1 {
	public static void main(String[] args) {
		Student std= new Student("Jai",21,"Hyderabad");
		Student std1= new Student("dhanush",19,"Chittoor");
		Student std2= new Student("mahesh",24,"Bengaluru");
		
		Map map= new HashMap();	
		map.put(1,std);
		map.put(2,std1);
		map.put(3,std2);
		System.out.println(map);
		
		//Accessing only values 
		Collection values =map.values();
		Iterator itr= values.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());// Here value is toString method output of student class
		}
		
		Set keys= map.keySet();
		Iterator itr1= keys.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());// keys of an hashmap
		}
		
		Set data=map.entrySet();
		Iterator itr2= data.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());// keys of an hashmap
		}
		
		//accessing datat using entry 
		Set data1=map.entrySet();
		Iterator itr3= data.iterator();
		while(itr3.hasNext()) {
			Map.Entry entry= (Entry)itr3.next();
			System.out.println("key :: "+entry.getKey()+">>> value ::"+entry.getValue());
		}
		
	}
}
