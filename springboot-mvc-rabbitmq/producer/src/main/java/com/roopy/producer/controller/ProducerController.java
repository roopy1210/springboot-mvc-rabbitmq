package com.roopy.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roopy.producer.service.ProducerService;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerService service;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		
		service.sayHello(name);
		
		return "Hello, " + name + "!";
		
	}
	
}
