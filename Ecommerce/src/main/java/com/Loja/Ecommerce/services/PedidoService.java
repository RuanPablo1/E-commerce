package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.dtos.PedidoInsertDTO;
import com.Loja.Ecommerce.models.Pedido;
import com.Loja.Ecommerce.repositories.PedidoRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repository;

	public List<Pedido> findAll() {
		List<Pedido> lista = repository.findAll();
		return lista;
	}

	public Pedido findById(Long id) {
		try {
			Pedido pedido = repository.findById(id).get();
			return pedido;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Pedido não encontrado para o número:" + id + ", tipo: " + Pedido.class.getName());
		}
	}

	public Pedido insert(PedidoInsertDTO pedidodto) {
		var pedido = new Pedido();
		BeanUtils.copyProperties(pedidodto, pedido);
		try {
			return repository.save(pedido);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}
	
	public Pedido update(Pedido pedido) {
		findById(pedido.getIdPedido());
		try {
			return repository.save(pedido);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este pedido!");
		}
	}

}
