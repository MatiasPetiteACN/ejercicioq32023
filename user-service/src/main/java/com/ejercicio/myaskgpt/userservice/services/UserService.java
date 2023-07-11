package com.ejercicio.myaskgpt.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.userservice.entities.User;
import com.ejercicio.myaskgpt.userservice.repositories.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User userRequest(long userID) {
		
		return userRepository.findByUserID(userID);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
