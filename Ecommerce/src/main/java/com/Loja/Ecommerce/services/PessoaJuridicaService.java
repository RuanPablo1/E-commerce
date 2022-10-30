package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.PessoaJuridica;
import com.Loja.Ecommerce.repositories.PessoaJuridicaRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaJuridicaService {
	
	PessoaJuridicaRepository repository;
	
	public List<PessoaJuridica> findAll() {
		return repository.findAll();
	}

	public PessoaJuridica findById(Long id) {
		try {
			PessoaJuridica cliente = repository.findById(id).get();
			return cliente;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Cliente não encontrado para o id:" + id + ", tipo: " + PessoaJuridica.class.getName());
		}
	}

	public PessoaJuridica insert(PessoaJuridica cliente) {
		cliente.setIdUsuario(null);
		try {
			return repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public PessoaJuridica update(PessoaJuridica cliente) {
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
