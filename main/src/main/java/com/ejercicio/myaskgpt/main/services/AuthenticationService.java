//
//package com.ejercicio.myaskgpt.main.services;
//
//import com.ejercicio.myaskgpt.main.entities.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Marker;
//import org.slf4j.MarkerFactory;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//@Service
//public class AuthenticationService implements UserDetailsService{
//
//	private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
//	private final Marker marker = MarkerFactory.getMarker("marker");
//
//	RestTemplate restTemplate;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		Map<String, String> userIdPathVariables = new HashMap<>();
//		userIdPathVariables.put("username", username);
//
//		User user = restTemplate.getForObject("http://myaskgpt-user-service/api/accounts/username/{username}", User.class, userIdPathVariables);
//		if (Objects.isNull(user)) {
//			logger.debug(marker, "No {} account was found in the system.", username);
//			throw new UsernameNotFoundException("No " + username + " account was found in the system.");
//		}
//		List<SimpleGrantedAuthority> authorities = user.getRoles()
//				.stream()
//				.map(role -> new SimpleGrantedAuthority(role.getAccessType()))
//				.toList();
//		logger.debug(marker, "User authenticated: {}", username);
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
//	}
//}
//
