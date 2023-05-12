package com.ejercicio.myaskgpt.userservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@ComponentScan("com.ejercicio.myaskgpt.userservice")
@ComponentScan("com.ejercicio.myaskgpt.userservice.controllers")
@ComponentScan("com.ejercicio.myaskgpt.userservice.entities")
@ComponentScan("com.ejercicio.myaskgpt.userservice.repositories")
@ComponentScan("com.ejercicio.myaskgpt.userservice.services")
public class SpringConfig {

}
