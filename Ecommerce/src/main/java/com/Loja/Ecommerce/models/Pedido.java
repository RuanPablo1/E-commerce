package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Loja.Ecommerce.enums.StatusPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente idCliente;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_pedido")
	private StatusPedido statusPedido;
	
	@Column(name = "total")
	private Double total;

	@Column(name = "data_hora")
	private LocalDateTime dataHora;

	@ManyToMany
	@JoinTable(name = "tb_produtos_pedido",
	joinColumns = @JoinColumn(name = "id_pedido"), 
	inverseJoinColumns = @JoinColumn(name = "id_produto"))
    //orphanRemoval = true: utilizado para remover filhos (produtos) sem pai (pedido) em caso de atualizaçao do pedido (para um número de itens menor que o anterior)
	private List<Produto> produtos;
}