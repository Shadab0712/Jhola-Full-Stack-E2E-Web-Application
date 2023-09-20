package com.jhola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhola.dto.UserDTO;
import com.jhola.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
		service.registerUser(userDTO);
		return new ResponseEntity<>("Account created successfully , please Login !", HttpStatus.CREATED);
	}
}
