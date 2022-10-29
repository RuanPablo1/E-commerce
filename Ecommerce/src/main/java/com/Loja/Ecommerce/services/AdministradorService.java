package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Administrador;
import com.Loja.Ecommerce.repositories.AdministradorRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

public class AdministradorService {
	
	@Autowired
	AdministradorRepository repository;
	
	public List<Administrador> findAll() {
		return repository.findAll();
	}

	public Administrador findById(Long id) {
		try {
			Administrador administrador = repository.findById(id).get();
			return administrador;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Administrador não encontrado para o id:" + id + ", tipo: " + Administrador.class.getName());
		}
	}

	public Administrador insert(Administrador administrador) {
		administrador.setIdUsuario(null);
		try {
			return repository.save(administrador);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public Administrador update(Administrador administrador) {
		findById(administrador.getIdUsuario());
		try {
			return repository.save(administrador);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este administrador!");
		}
	}

}
