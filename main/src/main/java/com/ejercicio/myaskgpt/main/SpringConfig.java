package com.ejercicio.myaskgpt.main;

import feign.form.FormEncoder;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	@Bean
	public FormEncoder encoder() {
		return new FormEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());
		http.authorizeHttpRequests(amrr -> amrr
				.requestMatchers("/api/user/roleRequest","/api/user/debtRequest").hasRole("ADMIN")
			.requestMatchers("/api/accounts/user","/{userID}/ask/{question}").permitAll());
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
