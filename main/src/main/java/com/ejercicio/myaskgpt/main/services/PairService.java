package com.ejercicio.myaskgpt.main.services;

import java.util.List;

import com.ejercicio.myaskgpt.main.exceptions.QuestionNotFoundException;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.main.entities.Pair;
import com.ejercicio.myaskgpt.main.repositories.PairRepository;


@Service
public class PairService {
	
	private PairRepository pairRepository;
	
	public Pair findByID(long pairID) {
		
		Pair par = new Pair();
				
		Pair repoReturn = pairRepository.findByPairID(pairID);
		
		par = repoReturn;
		
		return par;
	}
	
	public List<Pair> findAll() {
		return pairRepository.findAll();
	}
	public Pair findByPregunta(String pregunta) throws QuestionNotFoundException {

		try {
			return pairRepository.findByQuestion(pregunta);
		}
		catch(Exception e){
			throw new QuestionNotFoundException("Sorry, we dont seem to know the answer to this one.");
		}
	}
	
	public void save(Pair pair) {
		pairRepository.save(pair);
	}
}
