package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "nome_produto")
	private String nome;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "descricao_tecnica")
	private String descricaoTecnica;
	
	@Lob
	@OneToMany(mappedBy = "imagem")
	private List<Imagens> imagens;
	
	@ManyToMany
	@JoinTable(name = "tb_produtos_categorias", 
	joinColumns = @JoinColumn(name = "id_produto"), 
	inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private List<Categoria> categoria;
}