package com.NJTProject.rest.webservices.restwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
		
	
	

	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
 	return new HelloWorldBean("Hello World changed");
	}
	
	
	@GetMapping(path="/hello-world/path-veriable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}
}
