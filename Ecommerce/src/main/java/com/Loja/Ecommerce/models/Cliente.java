package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Loja.Ecommerce.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cliente")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Roles role;
	
	@Column(name = "cpf_ou_cnpj")
	private String CpfOuCnpj;
	
	@Column(name = "tipo_cliente")
	private Integer tipo;

	@Column(name = "telefone")
	private String telefone;
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idPedido")
	private List<Pedido> pedidos;

	public Cliente(Long id, String nome, String email, String password, Roles role, String cpfOuCnpj, String telefone,
			TipoCliente tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.role = role;
		this.CpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCodigo();
		this.telefone = telefone;
	}
}