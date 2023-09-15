package com.ejercicio.myaskgpt.main.controllers;

import com.ejercicio.myaskgpt.main.Enums.CostEnums;
import com.ejercicio.myaskgpt.main.exceptions.QuestionNotFoundException;
import com.ejercicio.myaskgpt.main.exceptions.UserNotFoundException;
import com.ejercicio.myaskgpt.main.services.DebtService;
import com.ejercicio.myaskgpt.main.services.PairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.myaskgpt.main.entities.dto.UserDTODebt;
import com.ejercicio.myaskgpt.main.entities.dto.UserDTORole;
import com.ejercicio.myaskgpt.main.services.UserService;


@RestController
@RequestMapping("api/user")
public class UserController {
//rest controller para que se pueda levantar desde postman

	@Autowired
	private UserService userService;
	@Autowired
	private PairService pairService;
	@Autowired
	private DebtService debtService;

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//mapping de usuario:deuda
	@GetMapping("/{userID}/debtRequest")
	public ResponseEntity<UserDTODebt> userDebtRequest(@PathVariable long userID){

		return new ResponseEntity<>(userService.userDebtRequest(userID), HttpStatus.OK);
	}
	
	@GetMapping("/{userID}/roleRequest")
	public ResponseEntity<UserDTORole> userRoleRequest(@PathVariable long userID){

		return new ResponseEntity<>(userService.userRoleRequest(userID), HttpStatus.OK);
	}
	//mapping de usuario:preguntas
	@GetMapping("/{userID}/ask/{question}")
	public ResponseEntity<String> askQuestion(@PathVariable long userID, @PathVariable String question){
		try{
			String answer = pairService.findByQuestion(question).getAnswer();
			debtService.billingService(userID, CostEnums.valueOfQuestion());
			return ResponseEntity.ok(answer);
		} catch (UserNotFoundException | QuestionNotFoundException e) {
			logger.debug(e.getMessage());
			return ResponseEntity.internalServerError().body(e.getMessage());

		}
	}
}
