package com.ejercicio.myaskgpt.main.services;

import com.ejercicio.myaskgpt.main.entities.User;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Component
public class AuthenticationProviderService implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationProviderService.class);
    private final Marker marker = MarkerFactory.getMarker("marker");

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Map<String, String> userIdPathVariables = new HashMap<>();
        userIdPathVariables.put("username", username);

        User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/username/{username}", User.class, userIdPathVariables);
        if (Objects.isNull(user)) {
            logger.debug(marker, "No {} account was found in the system.", username);
            throw new UsernameNotFoundException("No " + username + " account was found in the system.");
        }
        else if(!user.getPassword().equals(password)) {
            logger.debug(marker, "No {} account was found in the system.", username);
            throw new BadCredentialsException("Password is incorrect for user.");
        }
        else {
            logger.debug(marker, "{} authenticated.", username);
            return new UsernamePasswordAuthenticationToken(username, password,Arrays.asList());
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
