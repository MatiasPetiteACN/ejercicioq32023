package com.ejercicio.myaskgpt.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.userservice.entities.Accounts;
import com.ejercicio.myaskgpt.userservice.repositories.AccountsRepository;

@Service
public class AccountsService {

	private AccountsRepository accountsRepository;
	
	public String askUsername(long accountID) {
		
		List<Accounts> allAccounts = accountsRepository.findAll();
		System.out.println("service: " + allAccounts);
		
		String username = "";
		
		for(Accounts acc:allAccounts) {
			if(acc.getAccountID()== accountID){
				username= acc.getUsername();
				break;
			}
			else {continue;}
		}
		System.out.println("service: " + username);
		return username;
		
	}
}
