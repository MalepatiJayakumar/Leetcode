package com.practice.controller;

import com.practice.DTO.UserDTO;
import com.practice.service.User;

public class AddUsers {
	
	private User user;
	
	public AddUsers(User user) {
		this.user = user;
	}
	
	public void addEmployee(UserDTO userDTO) {
		boolean sucess = user.addUser(userDTO);
		if(sucess) {
			System.out.println("User has been added successfully.");
		}else {
			System.out.println("Adding user has been failed due to above issue");
		}
	}

}
