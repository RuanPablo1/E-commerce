package com.Loja.Ecommerce.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	
}