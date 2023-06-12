package com.practice.bean;

import java.io.Serializable;

public class Dog implements Serializable{

	private static transient Integer age;
	private transient String name;
	private String favorateFood;

	public Dog(Integer age, String name, String favorateFood) {
		this.age = age;
		this.name = name;
		this.favorateFood = favorateFood;
		System.out.println("Inside Dog constructor");
	}

	private void setAge(Integer age) {
		this.age = age;
	}

	private Integer getAge() {
		return this.age;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getName() {
		return this.name;
	}

	private void setFavorateFood(String favorateFood) {
		this.favorateFood = favorateFood;
	}

	private String getFavorateFood() {
		return this.favorateFood;
	}
	
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + ", favorateFood=" + favorateFood + "]";
	}
}