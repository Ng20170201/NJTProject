package com.NJTProject.rest.webservices.restwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.NJTProject.rest.webservices.restwebservices.jwt.JwtInMemoryUserDetailsService;

@SpringBootApplication
public class RestWebServicesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(RestWebServicesApplication.class, args);
	}

}
