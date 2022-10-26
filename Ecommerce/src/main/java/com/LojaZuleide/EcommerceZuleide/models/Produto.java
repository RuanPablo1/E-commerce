package com.LojaZuleide.EcommerceZuleide.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "produto")
	private String produto;
	
	@Column(name = "valor")
	private Double valor;
	
	@Column(name = "descricao_tecnica")
	private String descricaoTecnica;
	
	@ManyToMany
	@JoinTable(name = "tb_produtos_categorias", 
	joinColumns = @JoinColumn(name = "id_produto"), 
	inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	private Categoria categoria;

	public Produto() {
	}

	public Produto(Long idProduto, String produto, Double valor, String descricaoTecnica, Categoria categoria) {
		this.idProduto = idProduto;
		this.produto = produto;
		this.valor = valor;
		this.descricaoTecnica = descricaoTecnica;
		this.categoria = categoria;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricaoTecnica() {
		return descricaoTecnica;
	}

	public void setDescricaoTecnica(String descricaoTecnica) {
		this.descricaoTecnica = descricaoTecnica;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricaoTecnica, idProduto, produto, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descricaoTecnica, other.descricaoTecnica)
				&& Objects.equals(idProduto, other.idProduto) && Objects.equals(produto, other.produto)
				&& Objects.equals(valor, other.valor);
	}
}
