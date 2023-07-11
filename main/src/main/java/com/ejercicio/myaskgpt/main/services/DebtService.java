package com.ejercicio.myaskgpt.main.services;

import com.ejercicio.myaskgpt.main.entities.User;
import com.ejercicio.myaskgpt.main.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class DebtService {


    RestTemplate restTemplate;

    public void billingService(Long userID, double amount) throws UserNotFoundException {

        try {
            Map<String, Long> userIdPathVariables = new HashMap<>();
            userIdPathVariables.put("userID", userID);

            User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/user/{userID}", User.class, userIdPathVariables);


            restTemplate.put("user/{username}/billUser/{amount}", user, Objects.requireNonNull(user).getUsername(), amount);
        }
        catch (Exception e){
            throw new UserNotFoundException("User not found.");
        }

    }
}
