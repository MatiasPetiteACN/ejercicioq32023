package com.ejercicio.myaskgpt.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.userservice.entities.Accounts;
import com.ejercicio.myaskgpt.userservice.repositories.AccountsRepository;

@Service
public class AccountsService {

	AccountsRepository accountsRepository;
	
	List<Accounts> allAccounts = accountsRepository.findAll();
	
	public String askUsername(long accountID) {
		
		String username = "";
		
		for(Accounts acc:allAccounts) {
			if(acc.getAccountID()== accountID){
				username= acc.getUsername();
				break;
			}
			else {continue;}
		}
		return username;
	}
}
