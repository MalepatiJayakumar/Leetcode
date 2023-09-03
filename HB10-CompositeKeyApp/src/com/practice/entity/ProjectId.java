package com.practice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer deptNo;
	
	public ProjectId() {
		System.out.println("Zero args ProjectId constructor");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return "ProjectId [id=" + id + ", deptNo=" + deptNo + "]";
	}
	
}
