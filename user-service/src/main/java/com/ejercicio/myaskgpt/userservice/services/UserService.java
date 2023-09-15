package com.ejercicio.myaskgpt.userservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.userservice.entities.User;
import com.ejercicio.myaskgpt.userservice.repositories.UserRepository;

@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final Marker marker = MarkerFactory.getMarker("marker");

	@Autowired
	UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User userRequest(long userID) {
		
		return userRepository.findByUserID(userID);
	}
	
	public User findByUsername(String username) {
		logger.debug(marker, "user-service returning user: {}", username);
		return userRepository.findByUsername(username);
	}
}
