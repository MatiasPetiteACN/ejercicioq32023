package com.ejercicio.myaskgpt.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.myaskgpt.userservice.entities.User;
import com.ejercicio.myaskgpt.userservice.services.UserService;

@RestController
@RequestMapping("/api/accounts/")
public class UserEndpoints {
	
	@Autowired
	UserService userService;

	@GetMapping("/user/{userID}")
	public User userRequest(@PathVariable long userID) {
		
		User output = new User();
		output.setUserID(userID);
		output.setUsername(userService.askUsername(userID));
		output.setPassword("[REDACTED]");
		System.out.println("endp: " + output.getUsername() + " ID " + output.getUserID());
		return output;
	}
	
}
