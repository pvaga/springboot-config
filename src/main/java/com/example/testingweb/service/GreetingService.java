package com.example.testingweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	Logger logger = LoggerFactory.getLogger(GreetingService.class);
	
	public String greet() {
		logger.trace("Called Logging Service");
		return "Hello, World from Service";
	}
}
