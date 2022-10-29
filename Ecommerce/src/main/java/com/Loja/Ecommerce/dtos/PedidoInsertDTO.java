package com.Loja.Ecommerce.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.ItemPedido;
import com.Loja.Ecommerce.models.Pedido;

import lombok.Data;

@Data
public class PedidoInsertDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
	
	private Double total;
	
	private LocalDateTime dataHora;
	
	private List<ItemPedido> produtos;

	public PedidoInsertDTO(Cliente cliente, Pedido pedido) {
		this.idCliente = cliente.getIdUsuario();
		this.total = pedido.getTotal();
		this.dataHora = pedido.getDataHora();
		this.produtos = pedido.getItens();
	}
}