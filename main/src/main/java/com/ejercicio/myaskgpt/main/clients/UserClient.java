package com.ejercicio.myaskgpt.main.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejercicio.myaskgpt.main.entities.User;

//@FeignClient(name= "myaskgpt-user-service",url="myaskgpt-user-service:${PORT:0}", path="/api/accounts")
@FeignClient(name= "myaskgpt-user-service")
public interface UserClient {
	
	
	@GetMapping("/user/{userID}")
	public User userRequest(@PathVariable long userID);
}
