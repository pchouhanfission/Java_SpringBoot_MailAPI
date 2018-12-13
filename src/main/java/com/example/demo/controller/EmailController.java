package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmailService;



@RestController
public class EmailController {
	
	@Autowired
	private EmailService serv;

	@CrossOrigin(origins = "*")
	@GetMapping(path="/mail/{mailto}/{name}")
	public String sendMail(@PathVariable String mailto, @PathVariable String name) {
		return serv.sendmail(mailto,name);
	}
	
}