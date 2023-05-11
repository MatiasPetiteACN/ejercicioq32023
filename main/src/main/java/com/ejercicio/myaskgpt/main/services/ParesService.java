package com.ejercicio.myaskgpt.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.main.entities.Pares;
import com.ejercicio.myaskgpt.main.repositories.ParesRepository;

@Service
public class ParesService {

	private ParesRepository paresRepostory;
	
	public Pares findByID(long ID) {
		
		Pares par = new Pares();
				
		Pares repoReturn = paresRepostory.findByID(ID);
		
		par = repoReturn;
		
		return par;
	}
	
	public List<Pares> findAll() {
		return paresRepostory.findAll();
	}
	public Pares findByPregunta(String pregunta) {
		
		Pares par = new Pares();
				
		Pares repoReturn = paresRepostory.findByPregunta(pregunta);
		
		par = repoReturn;
		
		return par;
	}
	
	public void save(Pares par) {
		paresRepostory.save(par);
	}
}
