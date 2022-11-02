package com.Loja.Ecommerce.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	@Column
	private Integer quantidade;

	@Column
	private Double preco;

	@Column
	private Double desconto;

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco, Double desconto) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

//	Getter de produto id para ter acesso a ela fora da classe original
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
}