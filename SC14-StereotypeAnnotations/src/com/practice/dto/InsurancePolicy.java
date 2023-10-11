package com.practice.dto;

public class InsurancePolicy {
	private Long policyNo;
	private String policyName;
	private String companyName;
	private String holderName;
	private Integer tenure;

	public InsurancePolicy() {
		System.out.println("Zero args constructor in InsurancePolicy");
	}

	public Long getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Long policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Override
	public String toString() {
		return "InsurancePolicy [policyNo=" + policyNo + ", policyName=" + policyName + ", companyName=" + companyName
				+ ", holderName=" + holderName + ", tenure=" + tenure + "]";
	}

}
