package com.NJTProject.rest.webservices.restwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {
		
	
	

//	@GetMapping(path="/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	

	@GetMapping(path="/basicauth")
	public AuthenticationBean helloWorldBean() {
 	return new AuthenticationBean("You are authenticated");
	}
	
	
//	@GetMapping(path="/hello-world/path-veriable/{name}")
//	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
//		return new HelloWorldBean(String.format("Hello %s", name));
//	}
}
