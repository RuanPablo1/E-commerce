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
@Table(name = "tb_pessoa_juridica")
public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_juridica")
	private Long idJuridica;
	
	@ManyToOne
    @JoinColumn(name = "id_cliente")
	private Cliente idCliente;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(Long idJuridica, Cliente idCliente, String cnpj, String razaoSocial) {
		this.idJuridica = idJuridica;
		this.idCliente = idCliente;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public Long getIdJuridica() {
		return idJuridica;
	}

	public void setIdJuridica(Long idJuridica) {
		this.idJuridica = idJuridica;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
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
		return Objects.hash(cnpj, idCliente, idJuridica, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(idJuridica, other.idJuridica) && Objects.equals(razaoSocial, other.razaoSocial);
	}
}
