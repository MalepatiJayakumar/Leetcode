package com.practice.StreamAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class TestPredicates {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		task.setId(1L);
		task.setName("test");
		task.setStatus("New");
		testPredicate(getPredicatesForTask(),task);
		List<Task> list = new ArrayList<>();
		list.add(task);
//		testPredicate(getPredicatesForTask(),list); Not accepting list
	}

	public static <T> List<T> testPredicate(Predicate<T> predicate , T... values){
		System.out.println(values.getClass().getSimpleName());
		for(T value : values) {
			System.out.println(value);
		}
		return null;
	}
	
	public static Predicate<Task> getPredicatesForTask(){
		return t->t.getId()!=null && t.getName() != null && t.getStatus() != null; 
	}

}

class Task
{
	private Long id;
	private String name;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
