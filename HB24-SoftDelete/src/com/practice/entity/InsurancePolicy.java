package com.practice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name= "insurancepolicy")
@SQLDelete(sql = "update insurancepolicy set is_deleted = 1 where policyNo=:id")
@Where(clause="is_deleted = 0")
public class InsurancePolicy implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policyNo")
	private Long id;
	private String policyName;
	private String holderName;
	private Integer tenure;
	@Version
	private Integer versioncount;
	
	@Column(name="is_deleted")
	private Integer isDeleted;
	
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
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", policyName=" + policyName + ", holderName=" + holderName + ", tenure="
				+ tenure + "]";
	}
	
}