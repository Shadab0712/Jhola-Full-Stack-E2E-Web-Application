package com.jhola.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email/")
public class EmailController {
	
	@GetMapping
	public ResponseEntity<String> printMessage(){
		return new ResponseEntity<>("Email MicroService is bieng called" , HttpStatus.OK);
		
	}
	

}
