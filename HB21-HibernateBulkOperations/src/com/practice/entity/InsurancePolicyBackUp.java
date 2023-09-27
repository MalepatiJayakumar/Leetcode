package com.practice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "is_deleted = 0")
@SQLDelete(sql = "update InsurancePolicyBackUp set isDeleted = 1 where id=:id")
@NamedQuery(name = "INSURANCE_POLICY_COPY_QUERY", query = "insert into InsurancePolicyBackUp(id,policyName,holderName,tenure,versioncount) select ip.id,ip.policyName,ip.holderName,ip.tenure,ip.versioncount from InsurancePolicy as ip")
public class InsurancePolicyBackUp implements Serializable{

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