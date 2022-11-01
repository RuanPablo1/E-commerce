package com.Loja.Ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	
	
}