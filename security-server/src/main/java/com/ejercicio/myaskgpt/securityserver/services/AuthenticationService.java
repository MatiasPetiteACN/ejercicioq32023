package com.ejercicio.myaskgpt.securityserver.services;

import com.ejercicio.myaskgpt.securityserver.clients.UserClient;
import com.ejercicio.myaskgpt.securityserver.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService{

	private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	private final Marker marker = MarkerFactory.getMarker("marker");
	
	@Autowired
	private UserClient userClient;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
		User user = this.userClient.findByUsername(username);
			List<SimpleGrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role-> new SimpleGrantedAuthority(role.getAccessType()))
					.toList();
			logger.debug(marker,"User authenticated: {}", username);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),true,true ,true ,authorities);
		}
		catch(Exception e){
		throw new UsernameNotFoundException("No "+username+" account was found in the system.");}
		}
}
