package com.practice.DTO;

import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("")
public class Company {
	
	private String title;
	private String location;
	private Integer size;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getTitle() {
		return title;
	}
	public String getLocation() {
		return location;
	}
	public Integer getSize() {
		return size;
	}
	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", size=" + size + "]";
	}
	
}