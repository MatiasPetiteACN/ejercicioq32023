package com.ejercicio.myaskgpt.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.myaskgpt.main.clients.UserClient;
import com.ejercicio.myaskgpt.main.entities.dto.UserDTODebt;
import com.ejercicio.myaskgpt.main.services.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
//rest controller para que se pueda levantar desde postman


	
	@Autowired
	UserService userService;
	
	@Autowired
	UserClient userClient;
	
	@GetMapping("/userRequest/{userID}")
	public ResponseEntity<UserDTODebt> userRequest(@PathVariable long userID){

		return new ResponseEntity<>(userService.userDebtRequest(userID), HttpStatus.OK);
	}
	
	
	//mapping de usuario:preguntas
	
	
	//mapping de usuario:deuda
	
	//
}
