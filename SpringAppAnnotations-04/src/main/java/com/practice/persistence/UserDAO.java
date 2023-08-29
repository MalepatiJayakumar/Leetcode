package com.practice.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	public UserDAO() {
		System.out.println("Insider UserDAO constructor");
	}
	
}
