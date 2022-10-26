package com.LojaZuleide.EcommerceZuleide.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

import com.LojaZuleide.EcommerceZuleide.enums.StatusPedido;

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
	
	@Column(name = "data_hora")
	private LocalDateTime dataHora;
	
	@ManyToMany
	@JoinTable(name = "tb_pedidos_produtos", 
	joinColumns = @JoinColumn(name = "id_pedido"), 
	inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private Produto produtos;

	public Pedido() {
	}

	public Pedido(Long idPedido, Cliente idCliente, StatusPedido statusPedido, LocalDateTime dataHora,
			Produto produtos) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.statusPedido = statusPedido;
		this.dataHora = dataHora;
		this.produtos = produtos;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHora, idCliente, idPedido, produtos, statusPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(idPedido, other.idPedido) && Objects.equals(produtos, other.produtos)
				&& statusPedido == other.statusPedido;
	}
}
