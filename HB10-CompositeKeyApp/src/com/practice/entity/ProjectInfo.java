package com.practice.entity;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProjectInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProjectId projectId;
	private String pName;
	private String pDept;
	
	public ProjectInfo() {
		System.out.println("Inside zero args constructor in ProjectInfo");
	}
	
	public ProjectId getProjectId() {
		return projectId;
	}
	public void setProjectId(ProjectId projectId) {
		this.projectId = projectId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDept() {
		return pDept;
	}
	public void setpDept(String pDept) {
		this.pDept = pDept;
	}
	@Override
	public String toString() {
		return "ProjetcInfo [projectId=" + projectId + ", pName=" + pName + ", pDept=" + pDept + "]";
	}
	
}
