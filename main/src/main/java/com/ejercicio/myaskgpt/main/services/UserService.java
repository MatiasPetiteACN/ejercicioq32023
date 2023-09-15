package com.ejercicio.myaskgpt.main.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejercicio.myaskgpt.main.entities.Pair;
import com.ejercicio.myaskgpt.main.entities.User;
import com.ejercicio.myaskgpt.main.entities.dto.UserDTODebt;
import com.ejercicio.myaskgpt.main.entities.dto.UserDTORole;
@Service
public class UserService {

	
	@Autowired
	PairService pairService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	//metodo hacer respuesta, recibe una pregunta, la busca en el allPares y devuelve la respuesta asociada 
	//si no la encuentra devuelve excepcion(hacer)
	//Mejorar con un contains? --->Si
	
	public String hacerPregunta(String question) {
		//TODO add currentUserID param for charging purposes

		Pair pair = new Pair();
		
		pair.setQuestion(question);
		
		List<Pair> allPairs = pairService.findAll();
		
		//TODO add obtain current user debt via REST request

		for(Pair elem: allPairs) {
			if (elem.getQuestion().equals(pair.getQuestion())) {
				pair.setAnswer(elem.getAnswer());
				break;
			}
		}
		//TODO add charge to user via .PostForObject

		return pair.getAnswer();
	}


	
	public UserDTODebt userDebtRequest(long userID) {
		
		Map<String, Long> pathVariables = new HashMap<>();
		pathVariables.put("userID", userID);

		User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/user/{userID}", User.class, pathVariables);

		return modelMapper.map(user, UserDTODebt.class);
		
	}
	
	public UserDTORole userRoleRequest(long userID) {
		
		Map<String, Long> pathVariables = new HashMap<>();
		pathVariables.put("userID", userID);

		User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/user/{userID}", User.class, pathVariables);

		return modelMapper.map(user, UserDTORole.class);
		
	}
	
	//method checkDebt
}
