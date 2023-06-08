package com.ejercicio.myaskgpt.main.clients;

import com.ejercicio.myaskgpt.main.SpringConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejercicio.myaskgpt.main.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//@FeignClient(name= "myaskgpt-user-service",url="myaskgpt-user-service:${PORT:0}", path="/api/accounts")
@FeignClient(name= "myaskgpt-user-service", configuration = SpringConfig.class)
public interface UserClient {
	
	
	@GetMapping("/user/{userID}")
	public User userRequest(@PathVariable long userID);

	@GetMapping("/username/{username}")
	public User findByUsername(@PathVariable String username);

	@PostMapping("createUser/{username}/{password}/{roleID}")
	public void createUser(@PathVariable String username, @PathVariable String password, @PathVariable int roleID);

	@PutMapping("user/{username}/billUser/{amount}")
	public void billUser(@PathVariable String username, @PathVariable double amount);

	@PutMapping("user/{username}/pay/{amount}")
	public void userPay(@PathVariable String username, @PathVariable double amount);
}
