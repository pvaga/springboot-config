package com.example.testingweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.testingweb.service.GreetingService;

import io.swagger.annotations.ApiOperation;


@Controller
public class GreetingController {

	private final GreetingService service;

	public GreetingController(GreetingService service) {
		this.service = service;
	}

	@GetMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}

}
