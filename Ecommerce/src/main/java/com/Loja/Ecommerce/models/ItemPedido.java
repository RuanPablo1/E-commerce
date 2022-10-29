package com.Loja.Ecommerce.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "tb_itens_pedido")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
    @EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	@Column(name = "quantidade")
	private Integer quantidade;

	@Builder
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
	}

	@JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public Produto getProduto() {
        return id.getProduto();
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
}
