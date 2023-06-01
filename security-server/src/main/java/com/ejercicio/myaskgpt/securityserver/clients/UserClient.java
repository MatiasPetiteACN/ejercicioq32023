package com.ejercicio.myaskgpt.securityserver.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejercicio.myaskgpt.securityserver.entities.User;

@FeignClient(name= "myaskgpt-user-service")
public interface UserClient {

	
	@GetMapping("/user/{userID}")
	public User userRequest(@PathVariable long userID);
	
	@GetMapping("/username/{username}")
	public User findByUsername(@PathVariable String username);
}
