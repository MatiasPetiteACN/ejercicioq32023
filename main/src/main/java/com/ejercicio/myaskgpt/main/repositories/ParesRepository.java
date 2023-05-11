package com.ejercicio.myaskgpt.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.main.entities.Pares;

@Repository
public interface ParesRepository extends CrudRepository<Pares, Long>{

	public List<Pares> findAll();
	
	public Pares findByID(long id);
	
	public Pares findByPregunta(String pregunta);
}
