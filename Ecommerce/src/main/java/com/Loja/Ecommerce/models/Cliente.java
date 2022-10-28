package com.Loja.Ecommerce.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_clientes")
public class Cliente extends Usuario {

	private static final long serialVersionUID = 1L;

	@Column(name = "telefone")
	private String telefone;
	
	@OneToMany(mappedBy = "idPedido")
	private List<Pedido> pedidos;
	
	public Cliente() {
	}

	public Cliente(Long idUsuario, String email, String password, String nome, List<Roles> roles, Long idCliente,
			String telefone, List<Pedido> pedidos) {
		super(idUsuario, email, password, nome, roles);
		this.telefone = telefone;
		this.pedidos = pedidos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pedidos, telefone);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(pedidos, other.pedidos) && Objects.equals(telefone, other.telefone);
	}
}
