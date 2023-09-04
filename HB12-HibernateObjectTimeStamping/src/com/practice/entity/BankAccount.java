package com.practice.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accId;
	private String holderName;
	private Double balance;
	
	@Version
	private Integer versionCount;
	
	@CreationTimestamp
	private LocalDateTime createTime;
	
	@UpdateTimestamp
	private LocalDateTime updateTime;

	static {
		System.out.println("BankAccount.class has been loaded");
	}
	
	public BankAccount() {
		System.out.println("Zero argument constructor in BankAccount.class");
	}
	
	public BankAccount(String holderName , Double balance) {
		this.holderName = holderName;
		this.balance = balance;
	}
	
	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", holderName=" + holderName + ", balance=" + balance + ", versionCount="
				+ versionCount + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
