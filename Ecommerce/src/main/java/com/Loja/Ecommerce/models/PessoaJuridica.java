package com.Loja.Ecommerce.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica extends Cliente {

	private static final long serialVersionUID = 1L;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "razao_social")
	private String razaoSocial;

	public PessoaJuridica() {
	}

	public PessoaJuridica(Long idUsuario, String email, String password, String nome, List<Roles> roles, Long idCliente,
			String telefone, List<Pedido> pedidos, String cnpj, String razaoSocial) {
		super(idUsuario, email, password, nome, roles, idCliente, telefone, pedidos);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj, razaoSocial);
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
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(razaoSocial, other.razaoSocial);
	}
}
