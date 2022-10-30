package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.PessoaFisica;
import com.Loja.Ecommerce.repositories.PessoaFisicaRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository repository;

	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	public PessoaFisica findById(Long id) {
		try {
			PessoaFisica cliente = repository.findById(id).get();
			return cliente;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Cliente não encontrado para o id:" + id + ", tipo: " + PessoaFisica.class.getName());
		}
	}

	public PessoaFisica insert(PessoaFisica cliente) {
		cliente.setIdUsuario(null);
		try {
			return repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public PessoaFisica update(PessoaFisica cliente) {
		findById(cliente.getIdUsuario());
		try {
			return repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este cliente!");
		}
	}

}
