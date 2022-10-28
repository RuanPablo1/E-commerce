package com.Loja.Ecommerce.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Cliente {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;

	public PessoaFisica() {
	}

	public PessoaFisica(Long idUsuario, String email, String password, String nome, List<Roles> roles, Long idCliente,
			String telefone, List<Pedido> pedidos, String cpf) {
		super(idUsuario, email, password, nome, roles, idCliente, telefone, pedidos);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf);
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
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
