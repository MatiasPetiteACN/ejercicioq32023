package com.ejercicio.myaskgpt.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.myaskgpt.main.clients.UserClient;

@RestController("api/user")
public class UserController {
//rest controller para que se pueda levantar desde postman
	
	UserClient userClient;
	
	@GetMapping("/askUsername/{id}")
	public String askUsername(@RequestParam Long ID){
		System.out.println("Entre al username"); 
		return userClient.askUsername(ID);
	}
	
	
	//mapping de usuario:preguntas
	
	
	//mapping de usuario:deuda
	
	//
}
