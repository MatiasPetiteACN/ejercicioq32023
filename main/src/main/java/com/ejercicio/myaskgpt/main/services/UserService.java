package com.ejercicio.myaskgpt.main.services;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejercicio.myaskgpt.main.clients.UserClient;
import com.ejercicio.myaskgpt.main.entities.User;
import com.ejercicio.myaskgpt.main.entities.dto.UserDTODebt;

@Service
public class UserService {

	
	@Autowired
	PairService pairService;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ModelMapper modelMapper;
	//metodo hacer respuesta, recibe una pregunta, la busca en el allPares y devuelve la respuesta asociada 
	//si no la encuentra devuelve excepcion(hacer)
	//Mejorar con un contains? --->Si
/*	public User findByID(long userID) {
		Map<String, String> pathVar = new HashMap<String, String>();
		pathVar.put("userID", Long.toString(userID));
		return restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/users/askUsername", User.class, pathVar);
	}*/
	
/*	public String hacerPregunta(String question) {
		
		Pair pair = new Pair();
		
		pair.setQuestion(question);
		
		List<Pair> allPairs = pairService.findAll();
		
		//Agregar aca lo de la deuda
		
		for(Pair elem: allPairs) {
			if(elem.getQuestion().equals(pair.getQuestion())) {
				pair.setAnswer(elem.getAnswer());
				break;
			}
			else {continue;}
		}
		return pair.getAnswer();
	}*/
	
	public UserDTODebt userDebtRequest(long userID) {
		
		Map<String, Long> pathVariables = new HashMap<String, Long>();
		pathVariables.put("userID", userID);

		User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/user/{userID}", User.class, pathVariables);
		
		UserDTODebt userDTODebt = modelMapper.map(user, UserDTODebt.class);
		
		return userDTODebt;
		
	}
	
	//metodo verificarDeuda
}
