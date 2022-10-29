package com.Loja.Ecommerce.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.ItemPedido;
import com.Loja.Ecommerce.models.Pedido;

import lombok.Data;

@Data
public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Cliente idCliente;
	
	private Double total;
	
	private LocalDateTime dataHora;
	
	private List<ItemPedido> produtos;
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getIdPedido();
		this.idCliente = pedido.getIdCliente();
		this.total = pedido.getTotal();
		this.dataHora = pedido.getDataHora();
		this.produtos = pedido.getItens();
	}

	public static List<PedidoDTO> convert(List<Pedido> pedido) {
		return pedido.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}