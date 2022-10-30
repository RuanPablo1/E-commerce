package com.Loja.Ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Produto;
import com.Loja.Ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> lista = service.findAll();		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

}
