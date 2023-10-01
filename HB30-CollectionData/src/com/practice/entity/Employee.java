package com.practice.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

@Entity
@Table(name="employee_collection")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String organization;
	
	@ElementCollection   /* To enable the value as collection object */
	@Column(name="friend_name") /* Column name of friend names in new table */
	@CollectionTable(name="EMP_FRNDS",joinColumns=@JoinColumn(name="emp_id",referencedColumnName="id")) /* new table with name emp_frnds and having an employee table fkMapping */
	@OrderColumn(name="friend_no") /* PK id in new friends table with name  friend_no and given @ListIndexBase to start sequence or pk from 1 */
	@ListIndexBase(value=1)
	private List<String> friendsList;
	
	@ElementCollection
	@Column(name="phone_no") /* Column name of friend names in new table */
	@CollectionTable(name="EMP_PHONE",joinColumns=@JoinColumn(name="emp_id",referencedColumnName="id")) /* new table with name emp_frnds and having an employee table fkMapping */
	private Set<Long> phones;
	
	@ElementCollection
	@Column(name="account_number") /* Column name of friend names in new table */
	@CollectionTable(name="EMP_BANK_ACCOUNT",joinColumns=@JoinColumn(name="emp_id",referencedColumnName="id")) /* new table with name emp_frnds and having an employee table fkMapping */
	@MapKeyColumn(name="bankName",length=20)
	private Map<String,Long> bankAccounts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public List<String> getFriendsList() {
		return friendsList;
	}
	public void setFriendsList(List<String> friendsList) {
		this.friendsList = friendsList;
	}
	public Set<Long> getPhones() {
		return phones;
	}
	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}
	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", organization=" + organization + ", friendsList="
				+ friendsList + ", phones=" + phones + ", bankAccounts=" + bankAccounts + "]";
	}
}
