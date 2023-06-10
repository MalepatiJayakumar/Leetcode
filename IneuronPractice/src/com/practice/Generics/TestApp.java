package com.practice.Generics;

import java.util.Arrays;
import java.util.List;

class Response<E> {
	Boolean success = Boolean.FALSE;
	String message;
	E output; // count of values , values , boolean true or false

	Response(Boolean success, String message, E output) {
		this.success = success;
		this.message = message;
		this.output = output;
	}

	public Boolean getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public E getOutput() {
		return output;
	}
}
class Student {
	String name;
	Long id;
	Student(String name,Long id){
		this.name= name;
		this.id= id;
	}
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
}

public class TestApp {
	public static void main(String[] args) {
		Student std= new Student("jai",1l);
		Student std1= new Student("dhanush",2l);
		
		Response<Student> res= new Response<Student>(true,"sucessfully completed",std);
		System.out.println(res.getOutput());
		readResponse(res);
		Student stdData= res.getOutput();
		
		Response<List<Student>> res1= new Response<>(true,"List successfully parsed",Arrays.asList(std,std1));
		System.out.println(res1.getOutput());
		readResponse(res1);
		List<Student> list= res1.getOutput();
	}
	
	public static void readResponse(Response response) {
		System.out.println("type of data in response :: "+response.getOutput().getClass().getName());
	}
}
