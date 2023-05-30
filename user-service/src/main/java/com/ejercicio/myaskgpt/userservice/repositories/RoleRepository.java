package com.ejercicio.myaskgpt.userservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.userservice.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
