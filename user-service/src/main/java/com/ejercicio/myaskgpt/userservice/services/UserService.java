package com.ejercicio.myaskgpt.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.userservice.entities.User;
import com.ejercicio.myaskgpt.userservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String askUsername(long userID) {
		
		List<User> allUsers = userRepository.findAll();
		System.out.println("service: " + allUsers);
		
		String username = "";
		
		for(User acc:allUsers) {
			if(acc.getUserID()== userID){
				username= acc.getUsername();
				break;
			}
			else {continue;}
		}
		System.out.println("service: " + username);
		return username;
		
	}
}
