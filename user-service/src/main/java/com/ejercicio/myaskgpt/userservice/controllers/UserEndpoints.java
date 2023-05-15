package com.ejercicio.myaskgpt.userservice.controllers;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.myaskgpt.userservice.services.AccountsService;

@RestController("/api/accounts/users")
public class UserEndpoints {
	
	@Autowired
	AccountsService accountsService;

	@GetMapping("/askUsername/{userID}")
	public String askUsername(@RequestParam long userID) {
		
		System.out.println("endp: " + accountsService.askUsername(userID));
		JOptionPane.showMessageDialog(null, "endp: " + accountsService.askUsername(userID));
		return accountsService.askUsername(userID);
	}
	
}
