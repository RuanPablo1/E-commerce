package com.Loja.Ecommerce.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_administradores")
public class Administrador extends Usuario{

	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}

	public Administrador(Long idUsuario, String email, String password, String nome, List<Roles> roles) {
		super(idUsuario, email, password, nome, roles);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}