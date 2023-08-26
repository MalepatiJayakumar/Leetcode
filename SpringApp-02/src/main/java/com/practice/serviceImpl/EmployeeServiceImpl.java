package com.practice.serviceImpl;

import com.practice.DTO.UserDTO;
import com.practice.service.User;

public class EmployeeServiceImpl implements User {

	public boolean addUser(UserDTO user) {
		if(user.getAge() < 18) {
			System.out.println("Required user age is less than current user age >> please try later");
			return false;
		}
		return false;
	}
}