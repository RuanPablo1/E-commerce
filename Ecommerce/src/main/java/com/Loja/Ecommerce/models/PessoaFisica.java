package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fisica")
	private Long idFisica;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente")
	private Cliente idCliente;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;

	public PessoaFisica() {
	}

	public PessoaFisica(Long idFisica, Cliente idCliente, String cpf) {
		this.idFisica = idFisica;
		this.idCliente = idCliente;
		this.cpf = cpf;
	}

	public Long getIdFisica() {
		return idFisica;
	}

	public void setIdFisica(Long idFisica) {
		this.idFisica = idFisica;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, idCliente, idFisica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(idFisica, other.idFisica);
	}
}
