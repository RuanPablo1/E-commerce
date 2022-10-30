package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
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

	public Produto() {
	}

	public Produto(Long idProduto, String nomeProduto, Double valor, String descricaoTecnica, List<Imagens> imagens,
			List<Categoria> categoria) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.descricaoTecnica = descricaoTecnica;
		this.imagens = imagens;
		this.categoria = categoria;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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

	public List<Imagens> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descricaoTecnica, idProduto, imagens, nomeProduto, valor);
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
				&& Objects.equals(idProduto, other.idProduto) && Objects.equals(imagens, other.imagens)
				&& Objects.equals(nomeProduto, other.nomeProduto) && Objects.equals(valor, other.valor);
	}	
}
