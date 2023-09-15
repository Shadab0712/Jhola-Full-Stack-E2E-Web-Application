	package com.jhola.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security/")
public class SecurityController{
	
	@GetMapping
	public ResponseEntity<String> printMessage(){
		return new ResponseEntity<>("Security Microservice is being called" , HttpStatus.OK);
	}
}
