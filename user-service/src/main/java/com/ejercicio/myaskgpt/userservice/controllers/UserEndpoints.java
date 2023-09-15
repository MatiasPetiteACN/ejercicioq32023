package com.ejercicio.myaskgpt.userservice.controllers;

import com.ejercicio.myaskgpt.userservice.entities.Role;
import com.ejercicio.myaskgpt.userservice.entities.User;
import com.ejercicio.myaskgpt.userservice.repositories.RoleRepository;
import com.ejercicio.myaskgpt.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts/")
public class UserEndpoints {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService userService;

	@GetMapping("/user/{userID}")
	public User userRequest(@PathVariable long userID) {
		
		return userService.userRequest(userID);
	}
	
	@GetMapping("/username/{username}")
	public User findByUsername(@PathVariable String username) {
		
		return userService.findByUsername(username);
	}
	
	@PostMapping("createUser/{username}/{password}/{roleID}")
	public void createUser(@PathVariable String username, @PathVariable String password, @PathVariable int roleID) {

		Role userRole = roleRepository.findByRoleID(roleID);
		User user = new User(username, password, userRole);
		
		userService.save(user);
	}

	@PutMapping("user/{username}/billUser/{amount}")
	public void billUser(@PathVariable String username, @PathVariable double amount){

		User user = userService.findByUsername(username);
		user.setDebt(user.getDebt() + amount);

		userService.save(user);
	}

	@PutMapping("user/{username}/pay/{amount}")
	public void userPay(@PathVariable String username, @PathVariable double amount){

		User user = userService.findByUsername(username);
		user.setDebt(user.getDebt() - amount);

		userService.save(user);
	}
}
