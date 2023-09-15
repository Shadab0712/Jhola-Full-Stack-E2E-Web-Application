package com.jhola.paymentgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment/")
public class PaymentGatewayController {

	@GetMapping
	public ResponseEntity<String> printMessage() {
		return new ResponseEntity<>("Payment Gateway MicroService is bieng called", HttpStatus.OK);

	}

}
