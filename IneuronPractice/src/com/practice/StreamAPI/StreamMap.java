package com.practice.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(0, 5, 10, 15, 20, 25));

		/* double of existing values till JDK1.7v */
		List<Integer> data = new ArrayList<>();
		for (Integer i : list) {
			data.add(i * 2);
		}
		System.out.println(data);

		/* double of existing values from JDK 1.8v */
		List<Integer> data1 = list.stream().map(i -> i * 2).collect(Collectors.toList());
		System.out.println(data1);

		
		Project project = new Project();
		project.setId(1L);
		Project project1 = new Project();
		project1.setId(2L);
		List<Project> projectList = new ArrayList<>(Arrays.asList(project,project1));
		List<Long> dataList = projectList.stream().map(p -> p.getId()!=null?p.getId():null).collect(Collectors.toList());
		System.out.println(dataList);
	}
}

class Project {
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