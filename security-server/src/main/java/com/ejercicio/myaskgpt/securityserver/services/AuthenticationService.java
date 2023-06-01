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

	private Logger log = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private UserClient userClient;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userClient.findByUsername(username);
		if(user==null){
			log.error("xxxx");
			throw new UsernameNotFoundException("Error en el login, no existe el usuario "+username+" en el sistema");
	}
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role-> new SimpleGrantedAuthority(role.getAccessType()))
				.peek(authority -> log.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
			log.info("Usuario autenticado: "+username);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),true,true ,true ,authorities);
		}
}
