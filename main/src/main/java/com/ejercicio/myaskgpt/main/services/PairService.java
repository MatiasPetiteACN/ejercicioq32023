package com.ejercicio.myaskgpt.main.services;

import java.util.List;

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
	public Pair findByPregunta(String pregunta) {
		
		Pair par = new Pair();
				
		Pair repoReturn = pairRepository.findByQuestion(pregunta);
		
		par = repoReturn;
		
		return par;
	}
	
	public void save(Pair pair) {
		pairRepository.save(pair);
	}
}
