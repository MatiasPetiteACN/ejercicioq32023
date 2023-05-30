package com.ejercicio.myaskgpt.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.myaskgpt.main.entities.Pair;

@Repository
public interface PairRepository extends CrudRepository<Pair, Long>{

	public List<Pair> findAll();
	
	public Pair findByPairID(long pairID);
	
	public Pair findByQuestion(String question);
}
