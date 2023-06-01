package com.ejercicio.myaskgpt.securityserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SpringConfig extends WebSecurityConfigurerAdapter{
	//inyectamos el servicio de usuario que creamos anteriormente (p. 16)
	@Autowired
	private UserDetailsService accountService;
	
	//Agregamos al container un bean que encripte las pass, para poder pasárselo a la f° siguiente
	@Bean
	public static BcrypPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	//creamos la f° más importante de esta clase, que se encarga de encriptar las pass.
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(this.usuarioService).passwordEnconder(passwordEncoder());
	}
	//Agregamos al container un bean con el authenticationManager
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}

}
