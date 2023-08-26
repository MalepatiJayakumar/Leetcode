package com.practice.serviceImpl;

import com.practice.DTO.UserDTO;
import com.practice.service.User;

public class StudentServiceImpl implements User {

	public boolean addUser(UserDTO user) {
		if(user.getAge() > 18) {
			System.out.println("User age is more than expected , we can't provide admission");
			return false;
		}
		return true;
	}

}
