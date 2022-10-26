package com.LojaZuleide.EcommerceZuleide.models;

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
@Table(name = "tb_imagens")
public class Imagens implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagem")
	private Long idImagem;
	
	@ManyToOne
    @JoinColumn(name = "id_produto")
	private Produto idProduto;
	
	@Column(name = "imagem")
	private String imagem;

	public Imagens() {
	}

	public Imagens(Long idImagem, Produto idProduto, String imagem) {
		this.idImagem = idImagem;
		this.idProduto = idProduto;
		this.imagem = imagem;
	}

	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idImagem, idProduto, imagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagens other = (Imagens) obj;
		return Objects.equals(idImagem, other.idImagem) && Objects.equals(idProduto, other.idProduto)
				&& Objects.equals(imagem, other.imagem);
	}
}
