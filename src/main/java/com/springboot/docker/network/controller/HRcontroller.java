package com.springboot.docker.network.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.docker.network.model.Employee;

@RestController
public class HRcontroller {

	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	//private String URL = "http://localhost:8500/employees/";
	private String URL = "http://producer:8500/employees/";
	
	@GetMapping("/info/{id}")
	public Employee getInfo(@PathVariable Integer id) {
		return this.getRestTemplate().getForEntity(URL+id, Employee.class).getBody();
	}  
}
