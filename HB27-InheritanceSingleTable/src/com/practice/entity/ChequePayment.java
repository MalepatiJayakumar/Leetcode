package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cheqNo;
	private String chequeType;
	private LocalDate date;
	public Integer getCheqNo() {
		return cheqNo;
	}
	public void setCheqNo(Integer cheqNo) {
		this.cheqNo = cheqNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ChequePayment [cheqNo=" + cheqNo + ", chequeType=" + chequeType + ", date=" + date + "]";
	}
}