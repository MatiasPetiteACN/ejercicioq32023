package com.ejercicio.myaskgpt.userservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.userservice.entities.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long>{

	
	public Accounts findByAccountID(long accountID);
	
	public Accounts findByUsername(long accountID);
	
	public List<Accounts> findAll();
	
}
