package com.ejercicio.myaskgpt.userservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.userservice.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
	public User findByUserID(long userID);
	
	public User findByUsername(long userID);
	
	public List<User> findAll();
	
}
