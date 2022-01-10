package com.example.testingweb.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.testingweb.config.DbSettings;

import io.swagger.annotations.ApiOperation;

@Controller
public class HomeController {
	
	@Value("${app.description: default value}")
	private String greetingMessage;
	
	@Value("Static Message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	//SPEL: Spring Expression Evaluation language is done with #
	@Value("#{${db.connection}}")
	private Map<String, String> dbValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@Autowired
	private Environment env;

	@ApiOperation(value = "Get Default Greeting")
	@GetMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, "+ greetingMessage;
	}
	
	@ApiOperation(value = "Get List Value property", response = String.class)
	@GetMapping("/listPropert")
	public @ResponseBody String listProperty() {
		return "Hello, "+ listValues;
	}
	
	@ApiOperation(value = "Get SPEL property")
	@GetMapping("/dbValues")
	public @ResponseBody String dbValuesProperty() {
		return "Hello, "+ dbValues;
	}
	
	@ApiOperation(value = "Get Configured DB property")
	@GetMapping("/dbSettings")
	public @ResponseBody String dbSettings() {
		return "Hello, "+ dbSettings;
	}
	
	/**
	 * Don't use Environment to lookup properties not recommended
	 * Use @Value for property value mapping
	 * @return
	 */
	@ApiOperation(value = "Get Environment details")
	@GetMapping("/envdetail")
	public @ResponseBody String getEnvironmentDetails() {
		return env.getActiveProfiles().toString();
	}
}
