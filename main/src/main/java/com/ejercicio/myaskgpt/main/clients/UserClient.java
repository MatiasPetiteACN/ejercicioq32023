package com.ejercicio.myaskgpt.main.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="myaskgpt-user-service", url="myaskgpt-user-service.${PORT:0}")
public interface UserClient {

	
	@GetMapping("/askUsername/{userID}")
	public String askUsername(@RequestParam long userID);
}
