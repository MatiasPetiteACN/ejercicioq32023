package com.ejercicio.myaskgpt.securityserver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ejercicio.myaskgpt.securityserver.clients.UserClient;
import com.ejercicio.myaskgpt.securityserver.entities.User;

@Service
public class AuthenticationService implements UserDetailsService{

	private final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private UserClient userClient;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
		User user = userClient.findByUsername(username);
			List<GrantedAuthority> authorities = user.getRoles()
					.stream()
					.map(role-> new SimpleGrantedAuthority(role.getAccessType()))
					.peek(authority -> log.info("Role: "+ authority.getAuthority()))
					.collect(Collectors.toList());
			log.info("User authenticated: "+username);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),true,true ,true ,authorities);
		}
		catch(Exception e){
		throw new UsernameNotFoundException("No "+username+" account was found in the system.");}
		}
}
