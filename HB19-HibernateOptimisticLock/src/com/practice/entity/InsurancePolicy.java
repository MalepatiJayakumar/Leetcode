package com.practice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class InsurancePolicy implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String policyName;
	private String holderName;
	private Integer tenure;
	@Version
	private Integer versioncount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Integer getVersioncount() {
		return versioncount;
	}
	public void setVersioncount(Integer versioncount) {
		this.versioncount = versioncount;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", policyName=" + policyName + ", holderName=" + holderName + ", tenure="
				+ tenure + "]";
	}
	
}