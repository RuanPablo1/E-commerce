package com.Loja.Ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Produto;
import com.Loja.Ecommerce.services.ProdutoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }
	
	@GetMapping("/filtro")
	public ResponseEntity<List<Produto>> FindByNomeContains(@RequestParam("nome") String nome){
		List<Produto> produto = service.findByNomeProduto(nome);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insert(@Valid @RequestBody Produto produto){
		produto = service.insert(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(@Valid @RequestBody Produto produto){
		produto = service.insert(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
