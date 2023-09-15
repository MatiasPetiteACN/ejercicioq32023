package com.ejercicio.myaskgpt.main.services;

import java.util.List;

import com.ejercicio.myaskgpt.main.exceptions.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.main.entities.Pair;
import com.ejercicio.myaskgpt.main.repositories.PairRepository;


@Service
public class PairService {

	@Autowired
	private PairRepository pairRepository;
	
	public Pair findByID(long pairID) {return pairRepository.findByPairID(pairID);}
	
	public List<Pair> findAll() {
		return pairRepository.findAll();
	}
	public Pair findByQuestion(String question) throws QuestionNotFoundException {

		try {
			return pairRepository.findByQuestion(question);
		}
		catch(Exception e){
			throw new QuestionNotFoundException("Sorry, we dont seem to know the answer to this one yet.");
		}
	}
	
	public void save(Pair pair) {
		pairRepository.save(pair);
	}
}
