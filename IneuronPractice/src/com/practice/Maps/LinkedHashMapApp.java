package com.practice.Maps;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Details {
	private Integer id;
	private String name;
	private String fatherName;
	private String city;

	public Details(Integer id,String name,String fatherName, String city) {
		this.id= id;
		this.name= name;
		this.fatherName= fatherName;
		this.city= city;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getCity() {
		return city;
	}
	@Override
	public String toString() {
		return "name: "+name+"   >> fatherName: "+fatherName+"   >> city: "+city;
	}
}
public class LinkedHashMapApp {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter count of user details to be entered :: ");
		Integer count= scan.nextInt();//AutoBoxing
		String name="";
		String fatherName= "";
		String city= "";
		HashMap map= new HashMap();
		for(int i=0;i<count;i++) {
			System.out.println("Enter details for user "+(i+1));
			System.out.println("Enter name of :: ");
			name=scan.next();
			System.out.println("Enter father name :: ");
			fatherName=scan.next();
			System.out.println("Enter city :: ");
			city=scan.next();
			Details details= new Details(i+1,name,fatherName,city);
			map.put(i+1,details);
		}
		
		Boolean isPresent= Boolean.FALSE;
		
		System.out.println("Entere id to search for user details");
		Integer key= scan.nextInt();
		Set set= map.entrySet();
		Iterator itr= set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry= (Entry)itr.next();
			if(entry.getKey() == key) {
				System.out.println(entry.getValue());
				isPresent= Boolean.TRUE;
			}
		}
		if(!isPresent) {
			System.out.println("User with provided id is not present");
		}
	}
}
