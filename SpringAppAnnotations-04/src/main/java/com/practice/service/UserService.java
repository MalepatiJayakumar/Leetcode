package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.beans.User;

@Service
public interface UserService {
	
	public boolean addUser(User user);

}
