package com.ejercicio.myaskgpt.main.services;

import com.ejercicio.myaskgpt.main.entities.User;
import com.ejercicio.myaskgpt.main.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DebtService {

    @Autowired
    RestTemplate restTemplate;

    public void billingService(Long userID, double amount) throws UserNotFoundException {

        try {
            Map<String, Long> pathVariables = new HashMap<String, Long>();
            pathVariables.put("userID", userID);

            User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/user/{userID}", User.class, pathVariables);

            double debt = user.getDebt();

            debt = debt + amount;

            user.setDebt(debt);
        }
        catch (Exception e){
            throw new UserNotFoundException("WHO DAT! IDENTIFY YOUSSELF, NIGGA!");
        }

    }
}
