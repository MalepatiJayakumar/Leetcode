package com.practice.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.Utils.HibernateUtil;
import com.practice.entity.Employee;
/**
 * Generated query : When we use GenerationType.IDENTITY 
Hibernate:  
    create table org_employee (
       pk_id bigint not null auto_increment,
        location varchar(255),
        name varchar(255),
        organization varchar(255),
        salary double precision,
        primary key (pk_id)
    ) engine=InnoDB
    
    
    Generated query : When we use GenerationType.AUTO (As these is not working as expected for AUTO , we will always prefer to use IDENTITY for MYSQL)
    {
    	Hibernate: \
    	create table hibernate_sequence (next_val bigint) engine=InnoDB
    	insert into hibernate_sequence values ( 1 )
		
		create table org_employee (
       pk_id bigint not null,
        location varchar(255),
        name varchar(255),
        organization varchar(255),
        salary double precision,
        primary key (pk_id)
    ) engine=InnoDB

	
    
    
    }
 * 
 * @author malep
 *
 */
public class TestApp {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		if(session != null) {
			Transaction transaction = session.beginTransaction();
			try {
				Employee emp = new Employee();
				emp.setName("jayakumar");
				emp.setOrganization("HRC");
				emp.setLocation("HYD");
				emp.setSalary(1000d);
				id = (Long)session.save(emp);
				System.out.println("Employee record has been added with id :: "+id);
			}catch(Exception e) {
				transaction.commit();
				System.out.println("Exception occurred :: "+e);
			}finally {
				transaction.commit();
				HibernateUtil.closeSession();
				HibernateUtil.closeSessionFactory();
			}
		}
	}
}