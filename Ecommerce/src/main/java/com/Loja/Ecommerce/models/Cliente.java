package com.Loja.Ecommerce.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.Loja.Ecommerce.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;

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
	@ManyToMany
	@JoinTable(name = "tb_clientes_roles", 
	joinColumns = @JoinColumn(name = "id_cliente"), 
	inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Roles> role;
	
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

	public Cliente(Long id, String nome, String email, String password, List<Roles> role, String cpfOuCnpj, String telefone,
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

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return this.email;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}

	public String getCpfOuCnpj() {
		return CpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		CpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CpfOuCnpj, email, endereco, id, nome, password, pedidos, role, telefone, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(CpfOuCnpj, other.CpfOuCnpj) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(pedidos, other.pedidos) && Objects.equals(role, other.role)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(tipo, other.tipo);
	}
}