package com.Loja.Ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.PessoaFisica;
import com.Loja.Ecommerce.models.PessoaJuridica;
import com.Loja.Ecommerce.services.PessoaFisicaService;
import com.Loja.Ecommerce.services.PessoaJuridicaService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	PessoaFisicaService pessoaFisicaService;
	
	@Autowired
	PessoaJuridicaService pessoaJuridicaService;
	
	@PostMapping("/pf")
	public ResponseEntity<PessoaFisica> insertPF(PessoaFisica pessoaFisica){
		pessoaFisica = pessoaFisicaService.insert(pessoaFisica);
		return new ResponseEntity<PessoaFisica>(pessoaFisica, HttpStatus.CREATED);
	}
	
	@PostMapping("/pj")
	public ResponseEntity<PessoaJuridica> insertPJ(PessoaJuridica pessoaJuridica){
		pessoaJuridica = pessoaJuridicaService.insert(pessoaJuridica);
		return new ResponseEntity<PessoaJuridica>(pessoaJuridica, HttpStatus.CREATED);
	}
}