package com.practice.constructorInheritance;

public class Student {
	private Long id;
	private String name;
	private Integer age;
	private String college;
	private String location;
	private String dept;
	private Integer universityRank;
	
	public Student(Long id, String name, Integer age, String college, String location, String dept,
			Integer universityRank) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.college = college;
		this.location = location;
		this.dept = dept;
		this.universityRank = universityRank;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String collge) {
		this.college = collge;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getUniversityRank() {
		return universityRank;
	}
	public void setUniversityRank(Integer universityRank) {
		this.universityRank = universityRank;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", collge=" + college + ", location=" + location
				+ ", dept=" + dept + ", universityRank=" + universityRank + "]";
	}
}