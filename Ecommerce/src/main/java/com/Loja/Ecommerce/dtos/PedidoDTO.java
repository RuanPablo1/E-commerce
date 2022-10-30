package com.Loja.Ecommerce.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.Pedido;
import com.Loja.Ecommerce.models.Produto;

import lombok.Data;

@Data
public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Cliente idCliente;
	
	private Double total;
	
	private LocalDateTime dataHora;
	
	private List<Produto> produtos;
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getIdPedido();
		this.idCliente = pedido.getIdCliente();
		this.total = pedido.getTotal();
		this.dataHora = pedido.getDataHora();
		this.produtos = pedido.getProdutos();
	}

	public static List<PedidoDTO> convert(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}