package com.ejercicio.myaskgpt.userservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.userservice.entities.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long>{

	
	
}
