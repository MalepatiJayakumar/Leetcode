package com.practice.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CARD")
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cardNo;
	private String holderName;
	private String cardType;
	private String paymentGatway;
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGatway() {
		return paymentGatway;
	}
	public void setPaymentGatway(String paymentGatway) {
		this.paymentGatway = paymentGatway;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", holderName=" + holderName + ", cardType=" + cardType
				+ ", paymentGatway=" + paymentGatway + "]";
	}
}