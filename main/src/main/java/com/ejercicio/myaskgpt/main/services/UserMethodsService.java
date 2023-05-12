package com.ejercicio.myaskgpt.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.main.entities.Pares;

@Service
public class UserMethodsService {

	@Autowired
	ParesService paresService;
	
	//
	
	//metodo hacer respuesta, recibe una pregunta, la busca en el allPares y devuelve la respuesta asociada 
	//si no la encuentra devuelve excepcion(hacer)
	//Mejorar con un contains?
	public String hacerPregunta(String pregunta) {
		
		Pares par = new Pares();
		
		par.setPregunta(pregunta);
		
		List<Pares> allPares = paresService.findAll();
		
		//Agregar aca lo de la deuda
		
		for(Pares elem: allPares) {
			if(elem.getPregunta().equals(par.getPregunta())) {
				par.setRespuesta(elem.getRespuesta());
				break;
			}
			else {continue;}
		}
		return par.getRespuesta();
	}
	
	//metodo verificarDeuda
}
