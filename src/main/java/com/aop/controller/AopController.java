package com.aop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {
	
	@GetMapping
	public ResponseEntity<String> get(){
		return new ResponseEntity<String>("AOP TEST", HttpStatus.OK);
	}

}
