package com.Loja.Ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.dtos.ClienteInsertDTO;
import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody ClienteInsertDTO clienteDTO){
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDTO, cliente);
		cliente = service.insert(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente){
		cliente = service.update(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}